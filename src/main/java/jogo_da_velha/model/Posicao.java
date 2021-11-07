package jogo_da_velha.model;

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

    public boolean posicionarJogador(Jogador jogador) {
        boolean naoTemJogador =  !this.posicaoEstaOcupada();
        if(naoTemJogador){
            this.jogador = jogador;
        }
        return naoTemJogador;
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

    /**
     * Compara duas posições se tem o mesmo jogador nelas
     * @param o, espero uma instância de Posicao
     * @return boolean, true se forem iguais e false caso contrario.
     */
    public boolean equals(Object o){
	    if(o == null) return false;
	    Posicao posicao = o instanceof Posicao ? (Posicao)o : null;
	    if (posicao == null) return false;
	    return posicao.jogador.getSimbolo().equals(this.jogador.getSimbolo());
    }

    /**
     * Compara duas posições se tem o mosmo jogador nelas
     * @param posicao, o espero uma instância de Posicao
     * @param outra, outra espero uma instância de Posicao
     * @return boolean, true se forem iguais e false caso contrario.
     */
    public static boolean equals(Posicao posicao, Posicao outra){
        if(posicao.jogador == null) return false;
        if(outra.jogador == null) return false;
        return posicao.equals(outra);
    }
}
