package jogo_da_velha.models;

/*
*Nov 5, 2020
*Edilson A. Cuamba
*
*/

public class ImagemTabuleiro {
	private String mensagem;
	private Posicao posicoes[][];
	
	
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getMensagem() {
		return this.mensagem;
	}
	
	
	public void setPosicoes(Posicao[][] posicoes) {
		this.posicoes = posicoes;
	}
	public Posicao[][] getPosicoes() {
		return this.posicoes;
	}
}
