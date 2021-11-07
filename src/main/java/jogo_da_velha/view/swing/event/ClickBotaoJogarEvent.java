package jogo_da_velha.view.swing.event;

import jogo_da_velha.view.swing.TelaGetInfo;
import jogo_da_velha.view.swing.TelaJogo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickBotaoJogarEvent implements ActionListener {
    private TelaGetInfo tela;
    private String nome1, nome2;
    private Character simbolo1, simbolo2;

    public ClickBotaoJogarEvent(TelaGetInfo tela){
        this.tela = tela;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(passouNaValidacao(tela.getNomeTxt1())){
            nome1 = tela.getNomeTxt1().getText();
        }else {
            JOptionPane.showMessageDialog(tela, "Por favor insira o nome no campo nome do Jogador 1", "Erro na validação", JOptionPane.ERROR_MESSAGE);
        return;
        }
        if(passouNaValidacao(tela.getNomeTxt2())){
            nome2 = tela.getNomeTxt2().getText();
        }else {
            JOptionPane.showMessageDialog(tela, "Por favor insira o nome no campo nome do Jogador 2", "Erro na validação", JOptionPane.ERROR_MESSAGE);
            return;
        }
        simbolo1 = obterSimboloDoRadio(tela.getSimbolo1O(), tela.getSimbolo1X());
        simbolo2 = obterSimboloDoRadio(tela.getSimbolo2O(), tela.getSimbolo2X());

        System.out.println(this.nome1);
        System.out.println(this.nome2);
        System.out.println(this.simbolo1);
        System.out.println(this.simbolo2);

        tela.setVisible(false);
        new TelaJogo(nome1, simbolo1, nome2, simbolo2, tela);
    }

    public Character obterSimboloDoRadio(JRadioButton radioButton1, JRadioButton radioButton2){
        String simbolo = null;
        if(radioButton1.isSelected()){
            simbolo = radioButton1.getText();
        }else {
            simbolo = radioButton2.getText();
        }

        return simbolo.trim().toUpperCase().trim().charAt(0);
    }

    private boolean passouNaValidacao(JTextField textField){
        String value = textField.getText();
        return !value.trim().isEmpty();
    }
}
