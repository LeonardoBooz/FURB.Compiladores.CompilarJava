/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import view.File;

/**
 *
 * @author Venancio
 */
public class FileImpl implements File {

    @Override
    public String openArchive(String archive) {

        try {
            return Files.readString(Path.of(archive));
        } catch (IOException e) {
            return "";
        }

    }

    @Override
    public void saveArchive(String archive, String content) {

        try {
            Files.writeString(Path.of(archive), content);
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo");
        }

    }

}
