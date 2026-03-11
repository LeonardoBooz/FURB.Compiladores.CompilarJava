/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import Interfaces.Editor;

/**
 *
 * @author Venancio
 */
public class EditorImpl implements Editor {

    private String contentIde;
    private String archive;

    @Override
    public void setContentIde(String content) {
        this.contentIde = content;
    }

    @Override
    public String getContentIde() {
        return contentIde;
    }

    @Override
    public void setArchive(String archive) {
        this.archive = archive;
    }

    @Override
    public String getArchive() {
        return archive;
    }

    @Override
    public boolean isOpenedArchive() {
        return archive != null && !archive.isEmpty();
    }

}
