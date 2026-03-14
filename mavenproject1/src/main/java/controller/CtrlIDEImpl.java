package controller;

import Interfaces.WindowIDE;

/**
 * 
 * @author Enzo Kawakubo
 */
public class CtrlIDEImpl implements CtrlIDE {
    private WindowIDE window;

    public CtrlIDEImpl(WindowIDE window) {
        this.window = window;
    }

    @Override
    public void compileArchive() {
        String code = window.getTextIde();

        try {
            if (code == null || code.isEmpty()) {
                throw new Exception("Código vazio");
            }

            window.setMessage("Compilação realizada com sucesso!");
            window.setStatus("Compilado");
        } catch (Exception e) {
            window.setMessage("Erro na compilação: " + e.getMessage());
            window.setStatus("Erro");
        }
    }

    @Override
    public void saveArchive() {
        try {
            window.setStatus("Arquivo salvo com sucesso");
        } catch (Exception e) {
            window.setMessage("Erro ao salvar arquivo: " + e.getMessage());
        }
    }

    @Override
    public void openArchive() {
        try {
            String content = "Conteúdo do arquivo aberto";
            window.setTextIde(content);
            window.setStatus("Arquivo aberto");
        } catch (Exception e) {
            window.setMessage("Erro ao abrir arquivo: " + e.getMessage());
        }
    }

    @Override
    public void newArchive() {
        window.cleanTextIde();
        window.cleaMessage();
        window.setStatus("Novo arquivo");
    }

    @Override
    public void copie() {
        window.setStatus("Texto copiado");
    }

    @Override
    public void cut() {
        window.cleanTextIde();
        window.setStatus("Texto recortado");
    }

    @Override
    public void showTeam() {
        String teamInfo =
            "Equipe do Projeto:\n" +
            "Enzo Saleh Kawakubo\n" +
            "Leonardo Booz\n" +
            "Venâncio Cassua";

        window.setMessage(teamInfo);
    }
}