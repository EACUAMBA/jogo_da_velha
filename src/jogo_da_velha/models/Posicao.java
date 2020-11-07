package jogo_da_velha.models;

/*
*Nov 5, 2020
*Edilson A. Cuamba
*
*/

public class Posicao {
	private Jogador jogador;
	
	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
	public Jogador getJogador() {
		return this.jogador;
	}
	public boolean posicaoEstaOcupada() {
		if(this.jogador != null) {
			return true;
		}
		return false;
	}
}
