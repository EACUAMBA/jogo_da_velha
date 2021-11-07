package jogo_da_velha.model;

/**
 * Nov 5, 2020
 * Edilson A. Cuamba
 * <p>
 * Atualizado no dia 5 de Novembro de 2021 por Edilson Alexandre Cuamba
 */

public class Tabuleiro {
    private Jogador jogador1;
    private Jogador jogador2;
    private Posicao[][] posicoes = new Posicao[3][3];
    private boolean terminou;

    /**
     * Alterna o jogador actual, coloca true para quem é jogador actual e false para quem já foi.
     */
    private void alternarJogadorActual() {
        if (this.jogador1.isMinhaVez()) {
            this.jogador1.setMinhaVez(false);
            this.jogador2.setMinhaVez(true);
        } else {
            this.jogador2.setMinhaVez(false);
            this.jogador1.setMinhaVez(true);
        }
    }

    /**
     * Retorna o jogador actual entre dois jogadores.
     *
     * @return Jogador actual
     */
    public Jogador obterJogadorActual() {
        if (this.jogador1.isMinhaVez()) {
            return this.jogador1;
        } else {
            return this.jogador2;
        }

    }

    /**
     * Posiciona o jogador em uma posição especifica passada como argumento e delega alguém para verificar se é vencedor..
     *
     * @param linha
     * @param coluna
     * @return boolean, true se posicionou e false se não posicionou
     */
    public boolean posicionarJogador(int linha, int coluna) {
        Jogador jogadorActual = this.obterJogadorActual();

        boolean posicionou = this.posicoes[linha][coluna].posicionarJogador(jogadorActual);
        return posicionou;
    }

    /**
     * Verifica o estado do tabuleiro se ouve um vencedor depois (caso não houve vencedor), verifica se ainda tem jogadas possíveis
     *
     * @return
     */
    public void verificaEstadoTabuleiro() {
        boolean alguemVenceu = this.verificaVencedor();
        if (alguemVenceu) {
            this.terminou = true;
            return;
        }

        Integer posicoesRestantes = this.verificaJogadasRestantes();
        if (posicoesRestantes == 0) {
            this.terminou = true;
        }
    }

    private Integer verificaJogadasRestantes() {
        Integer numeroPosicoesVazias = 0;
        for (Posicao[] posicoesLinha : this.posicoes) {
            for (Posicao posicao : posicoesLinha) {
                if (!posicao.posicaoEstaOcupada()) {
                    numeroPosicoesVazias += 1;
                }
            }
        }
        return numeroPosicoesVazias;
    }

    /**
     * Verifica se no tabuleiro ouve vencedor, se houve coloca true na propriedade souVencedor do jogador.
     *
     * @return true se ouve vencedor caso contrário false
     */
    private boolean verificaVencedor() {
        Boolean eleVenceu = false;
        for (int i = 0; i < this.posicoes[0].length; i++) {
            //Verificando cada linha se tem valores iguais em toda ela
            if (Posicao.equals(this.posicoes[i][0], this.posicoes[i][1])) {
                if (Posicao.equals(this.posicoes[i][0], this.posicoes[i][2])) {
                    eleVenceu = true;
                    this.posicoes[i][0].getJogador().setSouVencedor(true);
                }
            }

            //Verificando a coluna se tem valores iguais em toda ela.
            if (Posicao.equals(this.posicoes[0][i], this.posicoes[1][i])) {
                if (Posicao.equals(this.posicoes[0][i], this.posicoes[2][i])) {
                    eleVenceu = true;
                    this.posicoes[0][i].getJogador().setSouVencedor(true);
                }
            }
        }

        if (Posicao.equals(this.posicoes[0][0], this.posicoes[1][1]))
            if (Posicao.equals(this.posicoes[0][0], this.posicoes[2][2])) {
                eleVenceu = true;
                this.posicoes[0][0].getJogador().setSouVencedor(true);
            }

        if (Posicao.equals(this.posicoes[2][0], this.posicoes[1][1]))
            if (Posicao.equals(this.posicoes[2][0], this.posicoes[0][2])) {
                eleVenceu = true;
                this.posicoes[2][0].getJogador().setSouVencedor(true);
            }
        return eleVenceu;
    }

    /**
     * Posiciona o dado e depois verifica se oo jogo continua, caso continue retorna uma imagemTabuleiro com o estado do tabuleiro actual caso não, vamos verificar se houve vencedor, se não vamos retornar uma mensagen jogo terminou empatados.
     *
     * @param linha
     * @param coluna
     * @return ImagemTabuleiro, estado actual do tabuleiro
     */
    public ImagemTabuleiro posicionarDado(int linha, int coluna) {
        boolean posicionou = this.posicionarJogador(linha, coluna);
        if (posicionou) {
            this.verificaEstadoTabuleiro();
            return this.geraImagemTabuleiro(null);
        } else {
            return this.geraImagemTabuleiro("A posição que você escolheu esta ocupada! Tente novamente!");
        }
    }


    /**
     * Gera uma imagem do estado actual do tabuleiro e retorna.
     *
     * @return ImagemTabuleiro, representa o estado.
     */
    public ImagemTabuleiro geraImagemTabuleiro(String note) {
        String mensagem = "Nada a dizer...";
        Posicao[][] posicoes = this.posicoes;
        Jogador jogadorActual = this.obterJogadorActual();
        Jogador jogadorVencedor = null;
        boolean houveVencedor = false;
        boolean houveEmpate = false;


        if (this.terminou) {
            if (this.ouveVencedor()) {
                mensagem = "Temos um vencedor!";
                jogadorVencedor = jogadorActual;
                houveVencedor = true;
            } else {
                mensagem = "Que pena foi empate!";
                houveEmpate = true;
            }
        } else {
            if ((note != null)) {
                mensagem = note;
                jogadorActual = this.obterJogadorActual();

            } else {
                this.alternarJogadorActual();
                jogadorActual = this.obterJogadorActual();
                mensagem = "O jogo continua.";
            }

        }
        return new ImagemTabuleiro(mensagem, posicoes, jogadorActual, jogadorVencedor, houveVencedor, houveEmpate, this.terminou);
    }

    /**
     * Verifica se temos um jogador com o selo vencedor.
     *
     * @return true se temos um vencedor e false caso não.
     */
    public boolean ouveVencedor() {
        return (this.jogador1.isSouVencedor() || this.jogador2.isSouVencedor());
    }

    // TODO: 11/6/2021 Melhorar os metodos abaixo
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

        this.criarPosicoes();

        return this.geraImagemTabuleiro("O jogo inicia...");
    }
}
