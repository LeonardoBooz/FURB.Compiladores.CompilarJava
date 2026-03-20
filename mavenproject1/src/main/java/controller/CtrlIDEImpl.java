package controller;

import model.Token;
import model.LexicalError;
import model.Lexico;
import Interfaces.WindowIDE;
import Interfaces.Editor;
import Interfaces.File;
import Interfaces.Message;
import model.EditorImpl;
import model.FileImpl;
import model.MessageImpl;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Constants;

public class CtrlIDEImpl implements CtrlIDE {

private WindowIDE window;
private Editor editor;
private File file;
private Message message;

public CtrlIDEImpl(WindowIDE window) {
    this.window = window;
    this.editor = new EditorImpl();
    this.file = new FileImpl();
    this.message = new MessageImpl();
}

@Override
public void newArchive() {
    editor.setArchive(null);
    editor.setContentIde("");

    window.cleanTextIde();
    window.cleaMessage();
    window.setStatus("");
}

@Override
public void openArchive() {
    JFileChooser chooser = new JFileChooser();
    chooser.setFileFilter(new FileNameExtensionFilter("Arquivos TXT", "txt"));

    int result = chooser.showOpenDialog(null);

    if (result == JFileChooser.APPROVE_OPTION) {
        java.io.File selected = chooser.getSelectedFile();
        String path = selected.getAbsolutePath();

        String content = file.openArchive(path);

        editor.setArchive(path);
        editor.setContentIde(content);

        window.setTextIde(content);
        window.cleaMessage();
        window.setStatus(path);
    }
}

@Override
public void saveArchive() {
    String content = window.getTextIde();

    if (!editor.isOpenedArchive()) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("Arquivos TXT", "txt"));

        int result = chooser.showSaveDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            java.io.File selected = chooser.getSelectedFile();
            String path = selected.getAbsolutePath();

            if (!path.endsWith(".txt")) {
                path += ".txt";
            }

            file.saveArchive(path, content);

            editor.setArchive(path);
            editor.setContentIde(content);

            window.cleaMessage();
            window.setStatus(path);
        }

    } else {
        String path = editor.getArchive();

        file.saveArchive(path, content);
        editor.setContentIde(content);

        window.cleaMessage();
    }
}

private int getLinha(String input, int position) {
    return input.substring(0, position).split("\n").length;
}

private boolean isPalavraReservada(String lexema) {
    switch (lexema) {
        case "ask": case "bool": case "char": case "define":
        case "end": case "elif": case "else": case "false":
        case "float": case "if": case "int": case "main":
        case "repeat": case "string": case "tell":
        case "true": case "until": case "while":
            return true;
        default:
            return false;
    }
}

private String getClasse(Token t) {

    if (t.getId() == Constants.t_id && isPalavraReservada(t.getLexeme())) {
        return "palavra reservada";
    }

    switch (t.getId()) {
        case Constants.t_id: return "identificador";
        case Constants.t_cte_int: return "constante_int";
        case Constants.t_cte_float: return "constante_float";
        case Constants.t_cte_char: return "constante_char";
        case Constants.t_cte_string: return "constante_string";
        default: return "símbolo especial";
    }
}

private String formatarToken(Token t, String input) {
    int linha = getLinha(input, t.getPosition());
    return "linha " + linha + " " + getClasse(t) + " " + t.getLexeme();
}

@Override
public void compileArchive() {

    window.cleaMessage();

    String input = window.getTextIde();
    Lexico lexico = new Lexico(input);

    StringBuilder resultado = new StringBuilder();

    try {
        Token token;

        while ((token = lexico.nextToken()) != null) {
            resultado.append(formatarToken(token, input)).append("\n");
        }

        resultado.append("\nprograma compilado com sucesso");

    } catch (LexicalError e) {
        int linha = getLinha(input, e.getPosition());
        resultado = new StringBuilder("linha " + linha + ": " + e.getMessage());
    }

    window.setMessage(resultado.toString());
}

@Override
public void showTeam() {

    window.cleaMessage();

    message.setMessage(
            "Equipe de desenvolvimento do compilador:\n"
            + "Leonardo Booz\n"
            + "Venâncio Cassua\n"
            + "Enzo Kawakubo"
    );

    window.setMessage(message.getMessage());
}

}