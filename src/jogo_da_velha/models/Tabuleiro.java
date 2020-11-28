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

	// Metodos funcionais

	public void trocarJogadorActual() {
		if (this.jogador1.isMinhaVez()) {
			this.jogador1.setMinhaVez(false);
			this.jogador2.setMinhaVez(true);
		} else if (this.jogador2.isMinhaVez()) {
			this.jogador2.setMinhaVez(false);
			this.jogador1.setMinhaVez(true);
		}
	}

	public Jogador pegarJogadorActual() {
		if (this.jogador1.isMinhaVez()) {
			return this.jogador1;
		} else {
			return this.jogador2;
		}

	}

	public ImagemTabuleiro notificarPosicaoOcupada() {
		ImagemTabuleiro imagemTabuleiro = criarImagemTabuleiro();
		imagemTabuleiro.setMensagem("\n\n*****Posição selecionada está ocupada volte a selecionar outra*****\n"
				+ imagemTabuleiro.getMensagem());
		return imagemTabuleiro;
	}

	public void colocarDadoNaPosicao(int linha, int coluna, Jogador jogador) {
		this.posicoes[linha][coluna].setJogador(jogador);
	}

	public ImagemTabuleiro posicionarDado(int linha, int coluna) {
		boolean jogoEmAndamdento = temosJogoEmAndamento();
		if (jogoEmAndamdento) {
			boolean ocupado = this.posicaoEstaIndisponivel(linha, coluna);
			if (ocupado) {
				return notificarPosicaoOcupada();
			} else {
				Jogador jogadorActual = pegarJogadorActual();
				this.colocarDadoNaPosicao(linha, coluna, jogadorActual);
				boolean ouveVencedor = temosVencedor();
				if (ouveVencedor) {
					return terminarJogo("\n\n*****Jogo Terminou*****\n**********Temos um vencedor, é o <<<<< "
							+ jogadorActual.getNome() + " >>>>> ***********");
				} else {
					boolean temPosicoesVazias = temPosicoesVazias();
					if (temPosicoesVazias) {
						return trocarJogadorActualCriarImagem();
					} else {
						return terminarJogo("\n\n*****Jogo Terminou*****\n**********Foi um empate***********");
					}
				}
			}

		} else {
			return notificarJogoTerminou();
		}
	}

	public ImagemTabuleiro notificarJogoTerminou() {

		ImagemTabuleiro imagemTabuleiro = criarImagemTabuleiro();
		if (temosVencedor()) {
			imagemTabuleiro.setMensagem(
					"\n\n*****Jogo já terminou! O vencedor foi " + pegarJogadorActual().getNome() + ". *****\n");
		} else {
			imagemTabuleiro.setMensagem("\n\n*****Jogo já terminou! Foi um empate. *****\n");
		}
		return imagemTabuleiro;
	}

	public ImagemTabuleiro trocarJogadorActualCriarImagem() {
		trocarJogadorActual();
		return criarImagemTabuleiro();
	}

	public boolean temosVencedor() {
		
		
		for (int linha = 0; linha < this.posicoes.length; linha++) {
			if ( this.posicoes[linha][0].temEsteJogador(this.posicoes[linha][1].getJogador())
					&& this.posicoes[linha][0].temEsteJogador(
							this.posicoes[linha][2].getJogador())) {
				return true;
			}

		}

		for (int coluna = 0; coluna < this.posicoes.length; coluna++) {
			if (this.posicoes[0][coluna].temEsteJogador(this.posicoes[1][coluna].getJogador())
					&& this.posicoes[0][coluna].temEsteJogador(this.posicoes[2][coluna].getJogador())) {
				return true;
			}

		}
		
		if(this.posicoes[0][0].temEsteJogador(this.posicoes[1][1].getJogador())
				&& this.posicoes[0][0].temEsteJogador(
				this.posicoes[2][2].getJogador())) {
			return true;
		}else if(this.posicoes[2][0].temEsteJogador(this.posicoes[1][1].getJogador())
				&& this.posicoes[2][0].temEsteJogador(this.posicoes[0][2].getJogador())){
			return true;
		}else {
			return false;
		}
		
		

	}

	public ImagemTabuleiro terminarJogo(String texto) {
		this.jogoTermoniu = true;
		ImagemTabuleiro imagemTabuleiro = new ImagemTabuleiro();
		imagemTabuleiro.setMensagem(texto);
		imagemTabuleiro.setPosicoes(this.posicoes);
		return imagemTabuleiro;
	}

	public boolean posicaoEstaIndisponivel(int linha, int coluna) {
		boolean ocupado = this.posicoes[linha][coluna].posicaoEstaOcupada();
		return ocupado;
	}

	public void criarPosicoes() {
		for (int linha = 0; linha < this.posicoes.length; linha++) {
			for (int coluna = 0; coluna < this.posicoes[linha].length; coluna++) {
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
		String mensagem = "Vez de " + jogadorActual.getNome() + "\nSimbolo: " + jogadorActual.getSimbolo();
		imagemTabuleiro.setMensagem(mensagem);
		imagemTabuleiro.setPosicoes(this.posicoes);
		return imagemTabuleiro;
	}

	public boolean temPosicoesVazias() {

		for (int i = 0; i <= (2); i++) {
			for (int j = 0; j <= (2); j++) {
				if (this.posicoes[i][j].posicaoEstaOcupada())
					;
				else
					return true;
			}
		}

		return false;
	}

	public boolean ouveVencedor() {
		if (this.jogador1.isVencedor()) {
			return true;
		} else if (this.jogador2.isVencedor()) {
			return true;
		} else {
			return false;
		}
	}

	// Getters and setters
	public void setJogoTerminou(boolean jogoTerminou) {
		this.jogoTermoniu = jogoTerminou;
	}

	public boolean temosJogoEmAndamento() {
		return !this.jogoTermoniu;
	}
}
