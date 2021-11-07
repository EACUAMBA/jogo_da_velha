package jogo_da_velha.view.swing;

import jogo_da_velha.model.ImagemTabuleiro;
import jogo_da_velha.model.Posicao;
import jogo_da_velha.model.Tabuleiro;
import jogo_da_velha.view.swing.util.Utils;

import javax.rmi.CORBA.Util;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaJogo extends JFrame {
    private String nome1, nome2;
    private Character simbolo1, simbolo2;

    private JPanel msgPainel = new JPanel(), matrizPainel = new JPanel(), resetPainel= new JPanel();
    private JButton[][] btnPosicoes = new JButton[3][3];
    private JButton resetJogo = new JButton("Reiniciar Jogo",
            new ImageIcon(Utils.obterBytesApartirFilePath(Utils.obterPathResource().resolve("icon/refresh.png"))));

    private JLabel msg = new JLabel();
    private JLabel itmsg = new JLabel();

    private Tabuleiro tabuleiro;
    private Border border;
    private Border border2;
    private TelaGetInfo telaGetInfo;

    public TelaJogo(String nome1, Character simbolo1, String nome2, Character simbolo2, TelaGetInfo telaGetInfo) {
        super("Jogo da Velha");
        this.nome1 = nome1;
        this.nome2 = nome2;
        this.simbolo1 = simbolo1;
        this.simbolo2 = simbolo2;
        this.border = new LineBorder(Utils.obterCorLight(), 10);
        this.border2 = new LineBorder(Utils.obterCorDark(), 10);
        this.getContentPane().setBackground(Utils.obterCorDark());
        this.telaGetInfo = telaGetInfo;


        this.resetJogo.setBackground(Utils.obterCorDark());
        this.resetJogo.setForeground(Utils.obterCorLight());
        this.resetJogo.setFont(Utils.obterFontTitulo());
        this.resetJogo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaGetInfo.setVisible(true);
                TelaJogo.this.setVisible(false);
            }
        });
        this.start();
    }

    private void start() {
        this.setSize(300, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.msgPainel.setBackground(Utils.obterCorLight());
        this.msgPainel.setBorder(border);
        this.matrizPainel.setBackground(Utils.obterCorDark());
        this.matrizPainel.setBorder(border2);
        this.resetPainel.setBackground(Utils.obterCorLight());
        this.resetPainel.setBorder(this.border);

        //Colocando paineis
        this.add(this.msgPainel, BorderLayout.NORTH);
        this.add(this.matrizPainel, BorderLayout.CENTER);
        this.add(this.resetPainel, BorderLayout.SOUTH);

        //Reset Painel
        this.resetPainel.add(this.resetJogo);

        //Colocando a matrix
        this.matrizPainel.setLayout(new GridLayout(3, 3, 10, 10));
        for (int i = 0; i<this.btnPosicoes.length; i++){
            for (int j = 0; j<this.btnPosicoes[i].length; j++){
                this.btnPosicoes[i][j] = new JButton();
                this.btnPosicoes[i][j].setName(String.format("%d,%d", i, j));
                this.btnPosicoes[i][j].addActionListener(new ClickPosicionarDado());
            }
        }


        this.msgPainel.setLayout(new GridLayout(2, 1, 5, 5));
        this.msg.setFont(Utils.obterFontTextoComum());
        this.msgPainel.add(this.msg);

        this.itmsg.setFont(Utils.obterFontTextoComum().deriveFont(Font.BOLD, 16));
        this.msgPainel.add(this.itmsg);

        tabuleiro = new Tabuleiro();
        ImagemTabuleiro it = tabuleiro.inicializarTabuleiro(nome1, simbolo1, nome2, simbolo2);

        this.msg.setText(it.getMensagem());
        this.itmsg.setText("Vez de " + it.getJogadorActual().getNome());

        this.carregaPosicoesNaTela(it.getPosicoes());

    }
    private void carregaPosicoesNaTela(Posicao[][] posicaos){
        for(int i =0; i< posicaos.length; i++){
            for(int j=0 ; j < posicaos[i].length; j++){
                Icon iconX = new ImageIcon(Utils.obterBytesApartirFilePath(Utils.obterPathResource().resolve("icon/close.png")));
                Icon iconO = new ImageIcon(Utils.obterBytesApartirFilePath(Utils.obterPathResource().resolve("icon/radio_button_unchecked.png")));

                if(posicaos[i][j].posicaoEstaOcupada()) {
                    if (posicaos[i][j].getJogador().getSimbolo().equals('O')) {
                        this.btnPosicoes[i][j].setIcon(iconO);
                    } else if (posicaos[i][j].getJogador().getSimbolo().equals('X')) {
                        this.btnPosicoes[i][j].setIcon(iconX);
                    }
                }
            }
        }
        for (int i = 0; i<this.btnPosicoes.length; i++){
            for (int j = 0; j<this.btnPosicoes[i].length; j++){

                this.matrizPainel.add(this.btnPosicoes[j][i]);
            }
        }
    }

    public class ClickPosicionarDado implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String posicaoString = ((JButton)e.getSource()).getName();
            String[] cordenadaString = posicaoString.trim().split(",");
            int posX = Integer.parseInt(cordenadaString[0]);
            int posO = Integer.parseInt(cordenadaString[1]);
            ImagemTabuleiro imagemTabuleiro = tabuleiro.posicionarDado(posX, posO);
            carregaPosicoesNaTela(imagemTabuleiro.getPosicoes());
            if(imagemTabuleiro.isTerminou()) {
                bloqueaJButtons();

                msg.setText(imagemTabuleiro.getMensagem());
                itmsg.setText("Que pena");
                if(imagemTabuleiro.isHouveVencedor()) {
                    msg.setText(imagemTabuleiro.getMensagem() );
                    itmsg.setText("Vencedor: " + imagemTabuleiro.getJogadorVencedor().getNome());
                }
            }else {
                msg.setText(imagemTabuleiro.getMensagem() );
                itmsg.setText("Vez de " + imagemTabuleiro.getJogadorActual().getNome());

            }


        }
    }

    private void bloqueaJButtons(){
        for (int i = 0; i<this.btnPosicoes.length; i++){
            for (int j = 0; j<this.btnPosicoes[i].length; j++){

                this.btnPosicoes[j][i].setEnabled(false);
            }
        }
    }
}
