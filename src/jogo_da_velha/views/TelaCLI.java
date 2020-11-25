package jogo_da_velha.views;

import java.util.Scanner;
import jogo_da_velha.models.*;
import jogo_da_velha.controllers.*;

//Nov 5, 2020
//Edilson A. Cuamba

public class TelaCLI {
	private IJogoDaVelhaController iJogoDaVelhaController;
	private Scanner scanner = new Scanner(System.in);

	public void setJogoDaVelhaController(JogoDaVelhaController jogoDaVelhaController) {
		this.iJogoDaVelhaController = jogoDaVelhaController;
	}

	public void iniciarJogo() {
		System.out.println("Bem vindo ao jogo da Velha desenvolvido por Edilson Alexandre Cuamba da Thunder Moz\n"
				+ "(Empresa de Desenvolvimento de Software Manutenção de Infraestruturas e muito mais).");

		System.out.println("Menu (lembre-se ao selecionar 0 durante o jogo, ira sair do jogo)\r\n" + "\r\n"
				+ "1 - Iniciar Jogo;\r\n" + "0 - Sair;");
		String opcao = "";

		while (!opcao.equals("1") && !opcao.equals("0")) {
			System.out.print("Insira a sua opção:");
			opcao = this.scanner.nextLine();
		}
		if (opcao.equals("1")) {
			String nome1 = this.pedirNomeJogador("primeiro jogador");
			char simbolo1 = this.pedirSimbolo(' ', nome1);

			String nome2 = this.pedirNomeJogador("segundo jogador");
			char simbolo2 = this.pedirSimbolo(simbolo1, nome2);

			System.out.println("Obrigado, Como só existem duas opções assumimos que o " + nome2 + " usara o simbolo: "
					+ simbolo2 + "; que restou!");
			System.out.printf("%nEntão temos%nJogador 1: %s, com simbolo: %s;", nome1, simbolo1);
			System.out.printf("%nJogador 2: %s, com simbolo: %s;%n%n", nome2, simbolo2);

			this.mostrarImagemTabuleiro(this.iJogoDaVelhaController.inicializarJogo(nome1, simbolo1, nome2, simbolo2));

			this.jogando();

		}

		if (opcao.contains("0")) {
			return;
		}
	}

	public void jogando() {
		String posicao = "";

		// Variavel de escape do do-while
		boolean continuarPedindo = true;
		do {
			System.out.print("Insira a posição que deseja jogar:");
			posicao = scanner.nextLine();

			for (int numero = 0; numero <= 10; numero++) {
				if (posicao.equals(numero + "")) {
					continuarPedindo = false;
				}
			}
		} while (continuarPedindo);

		if (posicao.equals("0")) {
			this.fecharJogo();
			return;
		}

		if (posicao.equals("10")) {
			System.out.print("\nReiniciando Jogo!\n");
			this.iniciarJogo();
			return;
		}

		//
		int linha = -1;
		int coluna = -1;

		if (posicao.equals("1")) {
			linha = 0;
			coluna = 0;
		} else if (posicao.equals("2")) {
			linha = 0;
			coluna = 1;
		} else if (posicao.equals("3")) {
			linha = 0;
			coluna = 2;
		} else if (posicao.equals("4")) {
			linha = 1;
			coluna = 0;
		} else if (posicao.equals("5")) {
			linha = 1;
			coluna = 1;
		} else if (posicao.equals("6")) {
			linha = 1;
			coluna = 2;
		} else if (posicao.equals("7")) {
			linha = 2;
			coluna = 0;
		} else if (posicao.equals("8")) {
			linha = 2;
			coluna = 1;
		} else if (posicao.equals("9")) {
			linha = 2;
			coluna = 2;
		}

		//
		
		ImagemTabuleiro imagemTabuleiro = this.iJogoDaVelhaController.posicionarDado(linha, coluna);;
		
		this.mostrarImagemTabuleiro(imagemTabuleiro);
		
		this.jogando();

	}

	public void fecharJogo() {

		System.out.println("Adeus, o jogo esta fechando!");

	}

	public String pedirNomeJogador(String primeiroOuSegundo) {
		String nome = "";
		while (nome.isEmpty()) {
			System.out.print("Insira o nome do " + primeiroOuSegundo + " : ");
			nome = this.scanner.nextLine().trim();
		}
		return nome;
	}

	public char pedirSimbolo(char simboloUsado, String nomejogador) {

		if (simboloUsado == 'O') {
			return 'X';
		} else if (simboloUsado == 'X') {
			return 'O';
		}

		char simbolo = ' ';
		String valor = "";

		while (!valor.trim().equals("1") && !valor.trim().equals("2")) {
			System.out.print("Escolha o simbolo para jogador " + nomejogador
					+ ":\n\t1 - O\n\t2 - X\nInsira o numero correspondente: ");
			valor = this.scanner.nextLine().trim();
		}

		if (valor.contains("1")) {
			simbolo = 'O';
		} else {
			simbolo = 'X';
		}
		return simbolo;
	}

	public void mostrarImagemTabuleiro(ImagemTabuleiro imagemTabuleiro) {
		System.out.printf("%n%s%n", imagemTabuleiro.getMensagem());

		int contador = 1;
		for (int l = 0; l < imagemTabuleiro.getPosicoes().length; l++) {
			String linha = "\n            ";

			for (int c = 0; c < imagemTabuleiro.getPosicoes()[l].length; c = c + 1) {
				if (imagemTabuleiro.getPosicoes()[l][c].posicaoEstaOcupada()) {
					linha = linha + " " + imagemTabuleiro.getPosicoes()[l][c].getJogador().getSimbolo() + "       ";

					contador = contador + 1;
				} else {
					linha = linha + "[" + contador + "]      ";
					contador = contador + 1;
				}
			}

			System.out.print(linha);
		}

		System.out.println(
				"\n\nInsira 10 para reiniciar o jogo.\nInsira 0 para fechar o jogo.\nInsira a opção (Digite o número): ");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TelaCLI telaCLI = new TelaCLI();
		telaCLI.setJogoDaVelhaController(new JogoDaVelhaController());
		telaCLI.iniciarJogo();

	}

}
