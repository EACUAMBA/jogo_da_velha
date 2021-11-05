package jogo_da_velha.models;

/**
 * Nov 5, 2020
 * Edilson A. Cuamba
 *
 * Atualizado no dia 5 de Novembro de 2021 por Edilson Alexandre Cuamba
 * Esta classe abstrata é uma representa abstrata de um jogador, com todos os dados cruciais para o jogo poder decorrer.
 */

public abstract class Jogador {
    private String nome;
    private Character simbolo;
    private boolean minhaVez;
    private boolean souVencedor;

    public Jogador() {
    }

    public Jogador(String nome) {
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setSimbolo(Character simbolo) {
        this.simbolo = simbolo;
    }

    public Character getSimbolo() {
        return this.simbolo;
    }

    public void setMinhaVez(boolean minhaVez) {
        this.minhaVez = minhaVez;
    }

    public boolean isMinhaVez() {
        return this.minhaVez;
    }

    public void setSouVencedor(boolean souVencedor) {
        this.souVencedor = souVencedor;
    }

    public boolean isSouVencedor() {
        return this.souVencedor;
    }


}
