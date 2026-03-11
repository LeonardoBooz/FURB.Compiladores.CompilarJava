/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telas;

/**
 *
 * @author Leonardo Booz
 */
import javax.swing.*;
import java.awt.*;
import interfaces.WindowIDE;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class EditorB extends JFrame implements WindowIDE {

    private JToolBar toolBar;

    private JButton btnNovo;
    private JButton btnAbrir;
    private JButton btnSalvar;
    private JButton btnCopiar;
    private JButton btnColar;
    private JButton btnRecortar;
    private JButton btnCompilar;
    private JButton btnEquipe;
    private JTextArea lineNumbers;
    private JTextArea textIde;
    private JTextArea textMessage;

    private JLabel status;

    private JSplitPane splitPane;

    public EditorB() {

        initComponents();
        buildLayout();
        defineColor();
        aplyFontStyle();
        loadIcons();
        updateLines();
        registerEvents();
        
        setResizable(false);
        ImageIcon raw = new ImageIcon(getClass().getResource("/icons/prog.png"));
        Image img = raw.getImage().getScaledInstance(256, 256, Image.SCALE_SMOOTH);
        setIconImage(img);
        setTitle("Compilador");
        setSize(1500, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        toolBar = new JToolBar();
        toolBar.setFloatable(false);
        
        Dimension sizeBotton = new Dimension(120, 70);
        
        btnNovo = new JButton("Novo");
        btnNovo.setPreferredSize(sizeBotton);
        btnNovo.setMinimumSize(sizeBotton);
        btnNovo.setMaximumSize(sizeBotton);
        
        btnAbrir = new JButton("Abrir");
        btnAbrir.setPreferredSize(sizeBotton);
        btnAbrir.setMinimumSize(sizeBotton);
        btnAbrir.setMaximumSize(sizeBotton);
        
        btnSalvar = new JButton("Salvar");
        btnSalvar.setPreferredSize(sizeBotton);
        btnSalvar.setMinimumSize(sizeBotton);
        btnSalvar.setMaximumSize(sizeBotton);

        btnCopiar = new JButton("Copiar");
        btnCopiar.setPreferredSize(sizeBotton);
        btnCopiar.setMinimumSize(sizeBotton);
        btnCopiar.setMaximumSize(sizeBotton);
        
        btnColar = new JButton("Colar");
        btnColar.setPreferredSize(sizeBotton);
        btnColar.setMinimumSize(sizeBotton);
        btnColar.setMaximumSize(sizeBotton);
        
        btnRecortar = new JButton("Recortar");
        btnRecortar.setPreferredSize(sizeBotton);
        btnRecortar.setMinimumSize(sizeBotton);
        btnRecortar.setMaximumSize(sizeBotton);

        btnCompilar = new JButton("Compilar");
        btnCompilar.setPreferredSize(sizeBotton);
        btnCompilar.setMinimumSize(sizeBotton);
        btnCompilar.setMaximumSize(sizeBotton);
        
        btnEquipe = new JButton("Equipe");
        btnEquipe.setPreferredSize(sizeBotton);
        btnEquipe.setMinimumSize(sizeBotton);
        btnEquipe.setMaximumSize(sizeBotton);
        
        toolBar.add(btnNovo);
        toolBar.add(btnAbrir);
        toolBar.add(btnSalvar);
        toolBar.addSeparator();
        toolBar.add(btnCopiar);
        toolBar.add(btnColar);
        toolBar.add(btnRecortar);
        toolBar.addSeparator();
        toolBar.add(btnCompilar);
        toolBar.add(btnEquipe);
        
        lineNumbers = new JTextArea();
        lineNumbers.setEditable(false);
        
        textIde = new JTextArea();
        textMessage = new JTextArea();
        textMessage.setEditable(false);

        status = new JLabel(" ");
    }

    private void buildLayout() {

        JScrollPane scrollEditor = new JScrollPane(textIde);
        scrollEditor.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
        );
        scrollEditor.setHorizontalScrollBarPolicy(
            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS
        );
        scrollEditor.setRowHeaderView(lineNumbers);
        
        JScrollPane scrollMessage = new JScrollPane(textMessage);
        scrollMessage.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
        );
        scrollMessage.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS
        );
        
        splitPane = new JSplitPane(
                JSplitPane.VERTICAL_SPLIT,
                scrollEditor,
                scrollMessage
        );

        splitPane.setDividerLocation(500);

        setLayout(new BorderLayout());

        add(toolBar, BorderLayout.NORTH);
        add(splitPane, BorderLayout.CENTER);
        add(status, BorderLayout.SOUTH);
    }
    
    public void defineColor(){
        Color corBotoesToolbar = new Color(50,50, 50);
        Color corFonte = new Color(0,0,0);
        
        btnNovo.setBackground(corBotoesToolbar);
        btnNovo.setForeground(corFonte);
        btnNovo.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnNovo.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNovo.setBorder(
            BorderFactory.createMatteBorder(
                0, 1, 0, 1, Color.GRAY
            )
        );
        
        btnAbrir.setBackground(corBotoesToolbar);
        btnAbrir.setForeground(corFonte);
        btnAbrir.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnAbrir.setHorizontalTextPosition(SwingConstants.CENTER);
        btnAbrir.setBorder(
            BorderFactory.createMatteBorder(
                0, 1, 0, 1, Color.GRAY
            )
        );
        
        btnSalvar.setBackground(corBotoesToolbar);
        btnSalvar.setForeground(corFonte);
        btnSalvar.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnSalvar.setHorizontalTextPosition(SwingConstants.CENTER);
        btnSalvar.setBorder(
            BorderFactory.createMatteBorder(
                0, 1, 0, 1, Color.GRAY
            )
        );
        
        btnCopiar.setBackground(corBotoesToolbar);
        btnCopiar.setForeground(corFonte);
        btnCopiar.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnCopiar.setHorizontalTextPosition(SwingConstants.CENTER);
        btnCopiar.setBorder(
            BorderFactory.createMatteBorder(
                0, 1, 0, 1, Color.GRAY
            )
        );
        
        btnColar.setBackground(corBotoesToolbar);
        btnColar.setForeground(corFonte);
        btnColar.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnColar.setHorizontalTextPosition(SwingConstants.CENTER);
        btnColar.setBorder(
            BorderFactory.createMatteBorder(
                0, 1, 0, 1, Color.GRAY
            )
        );
        
        btnRecortar.setBackground(corBotoesToolbar);
        btnRecortar.setForeground(corFonte);
        btnRecortar.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnRecortar.setHorizontalTextPosition(SwingConstants.CENTER);
        btnRecortar.setBorder(
            BorderFactory.createMatteBorder(
                0, 1, 0, 1, Color.GRAY
            )
        );
        
        btnCompilar.setBackground(corBotoesToolbar);
        btnCompilar.setForeground(corFonte);
        btnCompilar.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnCompilar.setHorizontalTextPosition(SwingConstants.CENTER);
        btnCompilar.setBorder(
            BorderFactory.createMatteBorder(
                0, 1, 0, 1, Color.GRAY
            )
        );
        
        btnEquipe.setBackground(corBotoesToolbar);
        btnEquipe.setForeground(corFonte);
        btnEquipe.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnEquipe.setHorizontalTextPosition(SwingConstants.CENTER);
        btnEquipe.setBorder(
            BorderFactory.createMatteBorder(
                0, 1, 0, 1, Color.GRAY
            )
        );
        
        Color textosAuxiliares = new Color(150,150,150);
        
        toolBar.setBackground(new Color(37, 37, 38));
        lineNumbers.setBackground(new Color(37, 37, 38));
        lineNumbers.setForeground(textosAuxiliares);
        
        textIde.setBackground(new Color(30, 30, 30));
        textIde.setForeground(new Color(13, 50, 99));
        textMessage.setBackground(new Color(30, 30, 30));
        textMessage.setForeground(textosAuxiliares);
        status.setBackground(new Color(0, 122, 204));
        
    }
    
    public void aplyFontStyle(){
        Font codeFont = new Font("Consolas", Font.PLAIN, 20);
        textIde.setFont(codeFont);
        lineNumbers.setFont(codeFont);
    }
    
    public void loadIcons(){
        ImageIcon raw = new ImageIcon(getClass().getResource("/icons/novo.png"));
        Image img = raw.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        btnNovo.setIcon(new ImageIcon(img));
        
        raw = new ImageIcon(getClass().getResource("/icons/abrir.png"));
        img = raw.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        btnAbrir.setIcon(new ImageIcon(img));
        
        raw = new ImageIcon(getClass().getResource("/icons/salvar.png"));
        img = raw.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        btnSalvar.setIcon(new ImageIcon(img));
        
        raw = new ImageIcon(getClass().getResource("/icons/copiar.png"));
        img = raw.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        btnCopiar.setIcon(new ImageIcon(img));
        
        raw = new ImageIcon(getClass().getResource("/icons/colar.png"));
        img = raw.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        btnColar.setIcon(new ImageIcon(img));
        
        raw = new ImageIcon(getClass().getResource("/icons/cortar.png"));
        img = raw.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        btnRecortar.setIcon(new ImageIcon(img));
        
        raw = new ImageIcon(getClass().getResource("/icons/compilar.png"));
        img = raw.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        btnCompilar.setIcon(new ImageIcon(img));
        
        raw = new ImageIcon(getClass().getResource("/icons/grupo.png"));
        img = raw.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        btnEquipe.setIcon(new ImageIcon(img));
    }

    private void registerEvents() {

        btnNovo.addActionListener(e -> {
            cleanTextIde();
            cleaMessage();
            setStatus("Novo arquivo");
        });

        btnCompilar.addActionListener(e -> {
            cleaMessage();
            setMessage("Compilação de programas ainda não foi implementada.");
        });

        btnEquipe.addActionListener(e -> {
            cleaMessage();
            setMessage("Equipe de desenvolvimento do compilador.");
        });

        btnCopiar.addActionListener(e -> textIde.copy());
        btnColar.addActionListener(e -> textIde.paste());
        btnRecortar.addActionListener(e -> textIde.cut());
        
        textIde.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateLines();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateLines();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateLines();
            }
        }
        );
    }
    

    private void updateLines() {

        int total = textIde.getLineCount();
        int digits = String.valueOf(total).length();
        
        if (total == 0){
            total = 1;
        }
        
        StringBuilder linhas = new StringBuilder();

        for (int i = 1; i <= total; i++) {
            linhas.append(String.format("%" + digits + "d%n", i));
        }

        lineNumbers.setText(linhas.toString());
    }

    // =========================
    // Implementação da interface
    // =========================

    @Override
    public void setTextIde(String text) {
        textIde.setText(text);
    }

    @Override
    public String getTextIde() {
        return textIde.getText();
    }

    @Override
    public void cleanTextIde() {
        textIde.setText("");
    }

    @Override
    public void setMessage(String text) {
        textMessage.setText(text);
    }

    @Override
    public void cleaMessage() {
        textMessage.setText("");
    }

    @Override
    public void setStatus(String text) {
        status.setText(text);
    }

    @Override
    public String getStatus() {
        return status.getText();
    }    
    
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            EditorB tela = new EditorB();
            tela.setVisible(true);
        });

    }
}
