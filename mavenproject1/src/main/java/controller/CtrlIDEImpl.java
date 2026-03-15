package controller;

import Interfaces.WindowIDE;
import Interfaces.Editor;
import Interfaces.File;
import Interfaces.Message;

import model.EditorImpl;
import model.FileImpl;
import model.MessageImpl;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * 
 * @author Enzo Kawakubo
 */
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

    @Override
    public void compileArchive() {

        window.cleaMessage();

        message.setMessage("Compilação de programas ainda não foi implementada.");

        window.setMessage(message.getMessage());
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