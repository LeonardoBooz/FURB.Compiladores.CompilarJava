/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

/**
 *
 * @author Leonardo Booz
 */
public interface Editor {
    public void setContentIde(String content);
    public String getContentIde();
    public void setArchive(String content);
    public String getArchive();
    public boolean isOpenedArchive();
}
