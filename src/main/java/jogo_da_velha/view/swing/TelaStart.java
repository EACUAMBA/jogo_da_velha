package jogo_da_velha.view.swing;

import jogo_da_velha.view.swing.event.ClickAvancarTelaStartEvent;
import jogo_da_velha.view.swing.util.Resource;
import jogo_da_velha.view.swing.util.Utils;
import sun.net.ResourceManager;
import sun.security.util.Resources;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;

public class TelaStart extends JFrame {
    private JLabel titulo;
    private JTextArea corpo;
    private JButton btnAvancar;
    private JPanel panel;

    public TelaStart(){
        super("Sobre nos!");
    }
    public void  mostrar(){
        this.setSize(300, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Utils.obterCorDark());
        GridLayout gl = new GridLayout(3, 1, 5, 5);
        FlowLayout fl = new FlowLayout();
        fl.setAlignment(FlowLayout.LEADING);
        fl.setHgap(5);
        fl.setVgap(2);
        fl.setAlignOnBaseline(true);
        BorderLayout bl = new BorderLayout();
        bl.setHgap(10);

        Border borderPanel = new LineBorder(Utils.obterCorDark(), 20);
        this.panel = new JPanel();
        this.panel.setBackground(Utils.obterCorDark());
        this.panel.setForeground(Utils.obterCorLight());
        this.panel.setLayout(bl);
        this.panel.setBorder(borderPanel);
        this.panel.setAlignmentY(JPanel.CENTER_ALIGNMENT);

        this.titulo = new JLabel();
        this.corpo = new JTextArea();
        this.btnAvancar = new JButton();

        this.titulo.setAlignmentX(JLabel.CENTER);
        this.titulo.setAlignmentY(JLabel.CENTER);
        this.titulo.setText("Jogo da Velha");
        this.titulo.setFont(Utils.obterFontTitulo());
        this.titulo.setForeground(Utils.obterCorLight());
        Border border = new LineBorder(Utils.obterCorDark(), 5);
        this.titulo.setBorder(border);
        this.panel.add(this.titulo, BorderLayout.NORTH);

        this.corpo.setFont(Utils.obterFontTextoComum());
        this.corpo.setForeground(Utils.obterCorLight());
        this.corpo.setText(
                "Este jogo foi desenvolvido por Edilson Alexandre Cuamba nos seus tempos livres com o intuito de aprimorar o seu conhecimento em Java SE, é um projecto prático que tem várias views, sendo está SWING, até aqui já fiz um no terminal."
        );
        this.corpo.setLineWrap(true);
        this.corpo.setWrapStyleWord(true);
        this.corpo.setEnabled(false);
        this.corpo.setBackground(Utils.obterCorDark());
        this.corpo.setForeground(Utils.obterCorLight());
        this.corpo.setAlignmentY(JTextArea.CENTER_ALIGNMENT);
        this.corpo.setAlignmentX(JTextArea.CENTER_ALIGNMENT);

        Border borderCorpo = new LineBorder(Utils.obterCorDark(), 5);
        this.corpo.setBorder(borderCorpo);
        this.panel.add(this.corpo, BorderLayout.CENTER);


        Icon icon = new ImageIcon(Utils.obterBytesApartirFilePath(Utils.obterPathResource().resolve("icon/chevron_right.png")));
        this.btnAvancar.setText("Avançar");
        this.btnAvancar.setIcon(icon);
        this.btnAvancar.setBackground(Utils.obterCorLight());
        this.btnAvancar.setForeground(Utils.obterCorDark());
        this.btnAvancar.setFont(Utils.obterFontTextoComum());
        this.btnAvancar.setHorizontalAlignment(JButton.CENTER);
        this.btnAvancar.setToolTipText("Clique aqui para avançar!");
        this.btnAvancar.setHorizontalTextPosition(SwingConstants.LEFT);
        this.btnAvancar.addActionListener(new ClickAvancarTelaStartEvent());
        this.panel.add(this.btnAvancar, BorderLayout.SOUTH);

        this.add(this.panel, BorderLayout.CENTER);
        this.panel.updateUI();
    }

}
