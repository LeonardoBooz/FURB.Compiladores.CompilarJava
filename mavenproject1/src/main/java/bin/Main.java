package bin;


import javax.swing.SwingUtilities;
import view.Editor;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Leonardo Booz
 */
public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            Editor tela = new Editor();
            tela.setVisible(true);
        });

    }
    
}
