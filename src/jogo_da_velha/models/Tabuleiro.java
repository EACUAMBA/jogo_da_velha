package jogo_da_velha.models;

/*
*Nov 5, 2020
*Edilson A. Cuamba
*
*/

public class Tabuleiro {
	private Jogador jogador1;
	private Jogador jogador2;
	private Posicao[][] posicoes = new Posicao[3][3];
	private boolean jogoTermoniu;
	
	//Metodos funcionais
	
	
	public void trocarJogadorActual() {
		if(this.jogador1.isMinhaVez()) {
			this.jogador1.setMinhaVez(false);
			this.jogador2.setMinhaVez(true);
		}else if(this.jogador2.isMinhaVez()) {
			this.jogador2.setMinhaVez(false);
			this.jogador1.setMinhaVez(true);
		}
	}
	public Jogador pegarJogadorActual() {
		if(this.jogador1.isMinhaVez()) {
			return this.jogador1;
		}else {
			return this.jogador2;
		}
		
	}
	
	public void colocarDadoNaPosicao(int linha, int coluna) {
		Jogador jogadorActual = this.pegarJogadorActual();
		this.posicoes[linha][coluna].setJogador(jogadorActual);
	}
	public ImagemTabuleiro posicionarDado(int linha, int coluna) {
		
		boolean ocupado = this.verificarDisponibilidadePosicao(linha, coluna);
		if(!ocupado) {
			this.colocarDadoNaPosicao(linha, coluna);
			
			
			//Gambiarra - isso não devia ser assim estruturamos mal o codigo!
			if(this.temPosicoesVazias()) {
				this.trocarJogadorActual();
			}else if(this.ouveVencedor()) {
				this.trocarJogadorActual();
			}
			
			
			return this.criarImagemTabuleiro();
			
		}else {
			ImagemTabuleiro imagemTabuleiro = this.criarImagemTabuleiro();
			imagemTabuleiro.setMensagem("\n***** Posição já está ocupada, selecione outra por favor. *****\n" + imagemTabuleiro.getMensagem());
			return imagemTabuleiro;
		}
		
		
	}
	public boolean verificarDisponibilidadePosicao(int linha, int coluna) {
		boolean ocupado = this.posicoes[linha][coluna].posicaoEstaOcupada();
		return ocupado;
	}
	
	public void criarPosicoes() {
		for(int linha = 0; linha < this.posicoes.length; linha++) {
			for(int coluna=0; coluna< this.posicoes[linha].length; coluna++) {
				this.posicoes[linha][coluna] = new Posicao();
			}
		}
	}
	public ImagemTabuleiro inicializarTabuleiro(String nome1, char simbolo1, String nome2, char simbolo2) {
		this.jogador1 = new JogadorHumano();
		this.jogador1.setNome(nome1);
		this.jogador1.setSimbolo(simbolo1);
		this.jogador1.setMinhaVez(true);
		
		this.jogador2 = new JogadorHumano();
		this.jogador2.setNome(nome2);
		this.jogador2.setSimbolo(simbolo2);
		
		this.jogoTermoniu = false;
		
		this.criarPosicoes();

		return this.criarImagemTabuleiro();
	}
	public ImagemTabuleiro criarImagemTabuleiro() {
		ImagemTabuleiro imagemTabuleiro = new ImagemTabuleiro();
		Jogador jogadorActual = this.pegarJogadorActual();
		if(this.jogoTermoniu) {
			if(this.ouveVencedor()) {
				String mensagem = "****** " + jogadorActual.getNome() + " venceu o jogo! *****\nVencedor: " + jogadorActual.getNome() + "\nSimbolo: " + jogadorActual.getSimbolo();
				imagemTabuleiro.setMensagem(mensagem);
				imagemTabuleiro.setPosicoes(posicoes);
			}else {
				String mensagem = "****** Jogo terminou empatado*****";
				imagemTabuleiro.setMensagem(mensagem);
				imagemTabuleiro.setPosicoes(posicoes);
			}
			
			
		}else {
		String mensagem = "Vez de " + jogadorActual.getNome() + "\nSimbolo: " + jogadorActual.getSimbolo();
		imagemTabuleiro.setMensagem(mensagem);
		imagemTabuleiro.setPosicoes(this.posicoes);
		}
		
		return imagemTabuleiro;
	}
	public boolean temPosicoesVazias() {
		boolean encontrouPosicaoVazia = false;
		
		for(int i = 0; i <= (2); i++) {
			for(int j = 0; j <= (2); j++) {
				if(!this.posicoes[i][j].posicaoEstaOcupada()) {
					encontrouPosicaoVazia = true;
				}
			}
		}
		
		return encontrouPosicaoVazia;
	}
	public boolean ouveVencedor() {
		if(this.jogador1.isVencedor()) {
			return true;
		}else if(this.jogador2.isVencedor()) {
			return true;
		}else{
			return false;
		}
	}
	//Getters and setters
	public void setJogoTerminou(boolean jogoTerminou) {
		this.jogoTermoniu = jogoTerminou;
	}
}
