package jogo_da_velha.models;

/**
 * Nov 5, 2020
 * Edilson A. Cuamba
 *
 * Atualizado no dia 5 de Novembro de 2021
 * Classe responsável por <b>representar uma posição no tabuleiro</b>, onde uma posição pode esta ocupada se tiver uma instância de Jogador ou não caso seja nula.
 */
public class Posicao {
    private Jogador jogador;

    public Posicao() {
    }

    public Posicao(Jogador jogador) {
        this.jogador = jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public Jogador getJogador() {
        return this.jogador;
    }

	/**
	 * Verifica se a posição actual está ocupada, retorna <b>true</b> se estiver ocupada.
	 *
	 * @return boolean
	 */
	public boolean posicaoEstaOcupada() {
    	return this.jogador != null;
    }
}
