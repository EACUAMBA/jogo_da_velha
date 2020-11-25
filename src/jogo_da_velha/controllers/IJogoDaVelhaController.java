package jogo_da_velha.controllers;

import jogo_da_velha.models.ImagemTabuleiro;

/*
*Nov 23, 2020
*Edilson A. Cuamba
*
*/

public interface IJogoDaVelhaController {
	public ImagemTabuleiro inicializarJogo(String nome1, char simbolo1, String nome2, char simbolo2);
	public ImagemTabuleiro posicionarDado(int linha, int coluna);
}
