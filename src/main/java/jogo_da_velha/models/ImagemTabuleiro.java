package jogo_da_velha.models;

/**
 * Nov 5, 2020
 * Edilson A. Cuamba
 * Atualizado no dia 5 de Novembro de 2021 por Edilson Alexandre Cuamba
 * Está classe abstrata representa uma abstração da(o) imagem/estado actual do tabuleiro com mensagens e o array do tabuleiro actual.
 */

public abstract class ImagemTabuleiro {
    private String mensagem;
    private Posicao[][] posicoes;

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
