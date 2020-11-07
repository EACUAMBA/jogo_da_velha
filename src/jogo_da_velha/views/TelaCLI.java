package jogo_da_velha.views;

import java.util.Scanner;
import jogo_da_velha.controllers.JogoDaVelhaController;

//Nov 5, 2020
//Edilson A. Cuamba

public class TelaCLI {
	private JogoDaVelhaController jogoDaVelhaController;
	private Scanner scanner = new Scanner(System.in);
	
	public void setJogoDaVelhaController(JogoDaVelhaController jogoDaVelhaController) {
		this.jogoDaVelhaController = jogoDaVelhaController;
	}
	
	public void iniciarJogo() {
		System.out.println("Bem vindo ao jogo da Velha desenvolvido por Edilson Alexandre Cuamba da Thunder Moz\n" + 
				"(Empresa de Desenvolvimento de Software Manutenção de Infraestruturas e muito mais).");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Menu (lembre-se ao selecionar 0 durante o jogo, ira sair do jogo)\r\n" + 
				"\r\n" + 
				"1 - Iniciar Jogo;\r\n" + 
				"0 - Sair;");
		System.out.print("Insira a sua opção:");
		String opcao = this.scanner.nextLine();
		
		
		if(Integer.parseInt(opcao.trim()) == 0) {
			return;
		}
	}
	
	public static void main(String[] args) {
	// TODO Auto-generated method stub
	
		TelaCLI telaCLI = new TelaCLI();
		telaCLI.setJogoDaVelhaController(new JogoDaVelhaController());
		telaCLI.iniciarJogo();
	
	
	}

}
