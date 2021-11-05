package jogo_da_velha.models;

/*
*Nov 5, 2020
*Edilson A. Cuamba
*
*/

public abstract class Jogador {
	private String nome;
	private char simbolo;
	private boolean minhaVez;
	private boolean vencedor;
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return this.nome;
	}
	
	public void setSimbolo(char simbolo) {
		this.simbolo = simbolo;
	}
	public char getSimbolo() {
		return this.simbolo;
	}
	
	public void setMinhaVez(boolean minhaVez) {
		this.minhaVez = minhaVez;
	}
	public boolean isMinhaVez() {
		return this.minhaVez;
	}
	
	public void setVencedor(boolean vencedor) {
		this.vencedor = vencedor;
	}
	public boolean isVencedor() {
		return this.vencedor;
	}
	
	
	
	
}
