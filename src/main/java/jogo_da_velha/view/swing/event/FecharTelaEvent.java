package jogo_da_velha.view.swing.event;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FecharTelaEvent implements ActionListener {
    JFrame tela = null;
    public FecharTelaEvent(JFrame tela){
        this.tela = tela;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        tela.setVisible(false);
        System.exit(0);
    }
}
