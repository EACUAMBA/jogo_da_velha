package jogo_da_velha.controller;

import jogo_da_velha.model.ImagemTabuleiro;
import jogo_da_velha.model.Tabuleiro;;

/*
*Nov 5, 2020
*Edilson A. Cuamba
*
*/

public class JogoDaVelhaController implements IJogoDaVelhaController {
	private Tabuleiro tabuleiro;

	@Override
	public ImagemTabuleiro inicializarJogo(String nome1, char simbolo1, String nome2, char simbolo2) {
		tabuleiro = new Tabuleiro();
		if (tabuleiro == null)
			return null;
		
		return tabuleiro.inicializarTabuleiro(nome1, simbolo1, nome2, simbolo2);
	}

	@Override
	public ImagemTabuleiro posicionarDado(int linha, int coluna) {
		// TODO Auto-generated method stub
		
		return this.tabuleiro.posicionarDado(linha, coluna);
		
	}
	

}
