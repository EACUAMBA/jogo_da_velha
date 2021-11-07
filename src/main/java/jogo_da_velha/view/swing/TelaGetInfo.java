package jogo_da_velha.view.swing;

import jogo_da_velha.view.swing.event.ClickBotaoJogarEvent;
import jogo_da_velha.view.swing.event.FecharTelaEvent;
import jogo_da_velha.view.swing.util.Utils;

import javax.rmi.CORBA.Util;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaGetInfo extends JFrame {
    private JPanel panelJogador1, panelJogador2;
    private JTextField nomeTxt1, nomeTxt2;
    private JLabel rotuloPanel1, rotuloPanel2;
    private JRadioButton simbolo1O, simbolo1X;
    private ButtonGroup simbolo1RadioGroup;

    private JRadioButton simbolo2O, simbolo2X;
    private ButtonGroup simbolo2RadioGroup;
    private JButton btnJogar;

    private Border border;

    public TelaGetInfo() {
        super("Resgistre os Jogadores");
        this.border = new LineBorder(Utils.obterCorDark(), 10);
    }

    public void mostrar() {
        this.setSize(300, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Utils.obterCorDark());
        GridLayout twoRowOneColumnLayout = new GridLayout(3, 1, 5, 5);
        this.setLayout(twoRowOneColumnLayout);


        this.add(this.geraPainelJogador1());
        this.add(this.geraPainelJogador2());

        JPanel painelJogar = new JPanel();
        painelJogar.setBackground(Utils.obterCorDark());
        painelJogar.setForeground(Utils.obterCorLight());
        painelJogar.setLayout(new GridLayout(2, 1, 10, 10));
        painelJogar.setBorder(this.border);

        this.btnJogar = new JButton("Jogar");
        this.btnJogar.setForeground(Utils.obterCorDark());
        this.btnJogar.setBackground(Utils.obterCorLight());
        this.btnJogar.setFont(Utils.obterFontTitulo());
        this.btnJogar.setBorder(null);
        this.btnJogar.addActionListener(new ClickBotaoJogarEvent(this));

        JButton btnSair = new JButton("Sair");
        btnSair.setBackground(new Color(237, 37, 78));
        btnSair.setForeground(Utils.obterCorLight());
        btnSair.setFont(Utils.obterFontTitulo());
        btnSair.addActionListener(new FecharTelaEvent(this));
        btnSair.setBorder(null);

        painelJogar.add(this.btnJogar);
        painelJogar.add(btnSair);

        this.add(painelJogar);


    }

    private JPanel geraPainelJogador1(){
        this.panelJogador1 = new JPanel();
        GridLayout threeRowsAndOneColumnLayout = new GridLayout(3, 1, 5, 5);
        this.panelJogador1.setLayout(threeRowsAndOneColumnLayout);
        this.panelJogador1.setBackground(Utils.obterCorDark());
        this.panelJogador1.setForeground(Utils.obterCorLight());
        this.panelJogador1.setBorder(this.border);


        Icon icon = new ImageIcon(Utils.obterBytesApartirFilePath(Utils.obterPathResource().resolve("icon/profile.png")));
        this.rotuloPanel1 = new JLabel("Jogador 1");
        this.rotuloPanel1.setFont(Utils.obterFontTitulo());
        this.rotuloPanel1.setIcon(icon);
        this.rotuloPanel1.setBackground(Utils.obterCorDark());
        this.rotuloPanel1.setForeground(Utils.obterCorLight());
        this.panelJogador1.add(this.rotuloPanel1);

        JPanel painel = new JPanel();
        painel.setBackground(Utils.obterCorDark());
        painel.setForeground(Utils.obterCorLight());
        painel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel label = new JLabel("Nome: ");
        label.setFont(Utils.obterFontTextoComum());
        label.setBackground(Utils.obterCorDark());
        label.setForeground(Utils.obterCorLight());

        this.nomeTxt1 = new JTextField(13);
        this.setBackground(Utils.obterCorLight());
        this.nomeTxt1.setFont(Utils.obterFontTextoComum());
        this.nomeTxt1.setBorder(null);

        painel.add(label);
        painel.add(nomeTxt1);

        //Simbolo
        JPanel painelSimbolo = new JPanel();
        painelSimbolo.setBackground(Utils.obterCorDark());
        painelSimbolo.setForeground(Utils.obterCorLight());
        painelSimbolo.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel labelSimbolo = new JLabel("Simbolo: ");
        labelSimbolo.setFont(Utils.obterFontTextoComum());
        labelSimbolo.setBackground(Utils.obterCorDark());
        labelSimbolo.setForeground(Utils.obterCorLight());
        painelSimbolo.add(labelSimbolo);

        this.simbolo1RadioGroup = new ButtonGroup();
        this.simbolo1O = new JRadioButton("O");
        this.simbolo1X = new JRadioButton("X");
        this.simbolo1O.setBackground(Utils.obterCorDark());
        this.simbolo1O.setForeground(Utils.obterCorLight());
        this.simbolo1X.setForeground(Utils.obterCorLight());
        this.simbolo1X.setBackground(Utils.obterCorDark());
        this.simbolo1X.setSelected(true);
        this.simbolo1O.addActionListener(new SelecionaOutroRadio());
        this.simbolo1X.addActionListener(new SelecionaOutroRadio());
        this.simbolo1RadioGroup.add(this.simbolo1O);
        this.simbolo1RadioGroup.add(this.simbolo1X);
        painelSimbolo.add(this.simbolo1O);
        painelSimbolo.add(this.simbolo1X);

        this.panelJogador1.add(painel);
        this.panelJogador1.add(painelSimbolo);
        return this.panelJogador1;
    }
    private JPanel geraPainelJogador2(){
        this.panelJogador2 = new JPanel();
        GridLayout threeRowsAndOneColumnLayout = new GridLayout(3, 1, 5, 5);
        this.panelJogador2.setLayout(threeRowsAndOneColumnLayout);
        this.panelJogador2.setBackground(Utils.obterCorDark());
        this.panelJogador2.setForeground(Utils.obterCorLight());
        this.panelJogador2.setBorder(this.border);

        Icon icon = new ImageIcon(Utils.obterBytesApartirFilePath(Utils.obterPathResource().resolve("icon/profile.png")));
        this.rotuloPanel2 = new JLabel("Jogador 2");
        this.rotuloPanel2.setFont(Utils.obterFontTitulo());
        this.rotuloPanel2.setIcon(icon);
        this.rotuloPanel2.setBackground(Utils.obterCorDark());
        this.rotuloPanel2.setForeground(Utils.obterCorLight());
        this.panelJogador2.add(this.rotuloPanel2);

        JPanel painel = new JPanel();
        painel.setBackground(Utils.obterCorDark());
        painel.setForeground(Utils.obterCorLight());
        painel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel label = new JLabel("Nome: ");
        label.setFont(Utils.obterFontTextoComum());
        label.setBackground(Utils.obterCorDark());
        label.setForeground(Utils.obterCorLight());

        this.nomeTxt2 = new JTextField(13);
        this.setBackground(Utils.obterCorLight());
        this.nomeTxt2.setFont(Utils.obterFontTextoComum());
        this.nomeTxt2.setBorder(null);

        painel.add(label);
        painel.add(nomeTxt2);

        //Simbolo
        JPanel painelSimbolo = new JPanel();
        painelSimbolo.setBackground(Utils.obterCorDark());
        painelSimbolo.setForeground(Utils.obterCorLight());
        painelSimbolo.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel labelSimbolo = new JLabel("Simbolo: ");
        labelSimbolo.setFont(Utils.obterFontTextoComum());
        labelSimbolo.setBackground(Utils.obterCorDark());
        labelSimbolo.setForeground(Utils.obterCorLight());
        painelSimbolo.add(labelSimbolo);

        this.simbolo2RadioGroup = new ButtonGroup();
        this.simbolo2O = new JRadioButton("O");
        this.simbolo2X = new JRadioButton("X");
        this.simbolo2O.setBackground(Utils.obterCorDark());
        this.simbolo2O.setForeground(Utils.obterCorLight());
        this.simbolo2X.setForeground(Utils.obterCorLight());
        this.simbolo2X.setBackground(Utils.obterCorDark());
        this.simbolo2O.addActionListener(new SelecionaOutroRadio());
        this.simbolo2X.addActionListener(new SelecionaOutroRadio());
        this.simbolo2O.setSelected(true);
        this.simbolo2RadioGroup.add(this.simbolo2O);
        this.simbolo2RadioGroup.add(this.simbolo2X);
        painelSimbolo.add(this.simbolo2O);
        painelSimbolo.add(this.simbolo2X);

        this.panelJogador2.add(painel);
        this.panelJogador2.add(painelSimbolo);
        return this.panelJogador2;
    }

    public JTextField getNomeTxt1() {
        return nomeTxt1;
    }

    public JTextField getNomeTxt2() {
        return nomeTxt2;
    }

    public JRadioButton getSimbolo1O() {
        return simbolo1O;
    }

    public JRadioButton getSimbolo1X() {
        return simbolo1X;
    }

    public JRadioButton getSimbolo2O() {
        return simbolo2O;
    }

    public JRadioButton getSimbolo2X() {
        return simbolo2X;
    }


class SelecionaOutroRadio implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {

            if(TelaGetInfo.this.getSimbolo1O().isSelected()){
                TelaGetInfo.this.getSimbolo2X().setSelected(true);
            }

            if(TelaGetInfo.this.getSimbolo1X().isSelected()){
                TelaGetInfo.this.getSimbolo2O().setSelected(true);
            }

    }
}
}