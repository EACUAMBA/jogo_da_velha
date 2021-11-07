package jogo_da_velha.view.swing.event;

import jogo_da_velha.view.swing.TelaGetInfo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickAvancarTelaStartEvent implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        TelaGetInfo telaGetInfo = new TelaGetInfo();
        telaGetInfo.mostrar();
        ((JButton)e.getSource()).getParent().getParent().getParent().getParent().getParent()
                .setVisible(false);
    }
}
