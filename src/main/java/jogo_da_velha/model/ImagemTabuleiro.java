package jogo_da_velha.model;

/**
 * Nov 5, 2020
 * Edilson A. Cuamba
 * Atualizado no dia 5 de Novembro de 2021 por Edilson Alexandre Cuamba
 * Está classe representa uma imagem/estado actual do tabuleiro com mensagens, array do tabuleiro actual, Jogador actual, Jogador Vencedor, se houve vencedor (boolean).
 */

public class ImagemTabuleiro {
    private String mensagem;
    private Posicao[][] posicoes;
    private Jogador jogadorActual;
    private Jogador jogadorVencedor;
    private boolean houveVencedor;
    private boolean houveEmpate;
    private boolean terminou;

    public ImagemTabuleiro(String mensagem, Posicao[][] posicoes, Jogador jogadorActual, Jogador jogadorVencedor, boolean houveVencedor, boolean houveEmpate, boolean terminou) {
        this.mensagem = mensagem;
        this.jogadorActual = jogadorActual;
        this.jogadorVencedor = jogadorVencedor;
        this.posicoes = posicoes;
        this.houveVencedor = houveVencedor;
        this.houveEmpate = houveEmpate;
        this.terminou = terminou;
    }

    public String getMensagem() {
        return this.mensagem;
    }

    public Posicao[][] getPosicoes() {
        return this.posicoes;
    }

    public Jogador getJogadorActual() {
        return jogadorActual;
    }

    public Jogador getJogadorVencedor() {
        return jogadorVencedor;
    }

    public boolean isHouveVencedor() {
        return houveVencedor;
    }

    public boolean isHouveEmpate(){
        return this.houveEmpate;
    }

    public boolean isTerminou(){
        return this.terminou;
    }
}
