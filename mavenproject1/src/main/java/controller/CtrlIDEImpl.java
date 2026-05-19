package controller;

import java.io.StringReader;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import Interfaces.Editor;
import Interfaces.File;
import Interfaces.Message;
import Interfaces.WindowIDE;
import model.Constants;
import model.EditorImpl;
import model.FileImpl;
import model.LexicalError;
import model.Lexico;
import model.MessageImpl;
import model.SemanticError;
import model.Semantico;
import model.Sintatico;
import model.SyntaticError;
import model.Token;

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
        int linha = 1;
        char c = input.charAt(0);

        for (int i = 0; i <= position && i < input.length(); i++) {
            c = input.charAt(i);

            if (c == '\n') {
                linha++;
            }
        }

        if(c == '\n'){
            linha--;
        }

        return linha;
    }
    
    private String getClasse(Token t) {
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

    private String traduzErroLexico(LexicalError e, String input) {

        int linha = getLinha(input, e.getPosition());

        if (e.getMessage().equals("símbolo inválido")) {

            return "linha "
                    + linha
                    + ": "
                    + e.getSimbolo()
                    + " símbolo inválido";
        }

        return "linha " + linha + ": " + e.getMessage();
    }

    @Override
    public void compileArchive() {

        window.cleaMessage();

        String input = window.getTextIde()
                .replace("\r\n", "\n")
                .replace("\n\r", "\n");

        Lexico lexico = new Lexico(new StringReader(input));
        Sintatico sintatico = new Sintatico();
        Semantico semantico = new Semantico();

        StringBuilder resultado = new StringBuilder();

        try {

            sintatico.parse(lexico, semantico);

            resultado.append("programa compilado com sucesso");

        } catch (LexicalError e) {

            resultado.append(traduzErroLexico(e, input));

        } catch (SyntaticError e) {

            int linha = getLinha(input, e.getPosition());

            String encontrado =
                    getTokenEncontrado(input, e.getPosition());

            resultado.append("linha ")
                    .append(linha)
                    .append(": encontrado ")
                    .append(encontrado)
                    .append(" ")
                    .append(e.getMessage());
        } catch (SemanticError e) {

            int linha = getLinha(input, e.getPosition());

            resultado.append("linha ")
                    .append(linha)
                    .append(": ")
                    .append(e.getMessage());
        }

        window.setMessage(resultado.toString());
    }

    private String getTokenEncontrado(String input, int position) {

        try {

            Lexico lexico = new Lexico(new StringReader(input));
            Token token;

            while ((token = lexico.nextToken()) != null) {

                if (token.getPosition() >= position) {

                    switch (token.getId()) {

                        case Constants.t_cte_string:
                            return "constante_string";

                        case Constants.t_id:
                        case Constants.t_cte_int:
                        case Constants.t_cte_float:
                        case Constants.t_cte_char:
                            return token.getLexeme();

                        default:
                            return token.getLexeme();
                    }
                }
            }

        } catch (LexicalError e) {
            // ignora
        }

        return "EOF";
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