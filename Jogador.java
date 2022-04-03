package com.uninter;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Jogador {
	
	private static char jogador;

	public Jogador(char jogador) {
		super();
		this.setJogador(jogador);
	}

	public char getJogador() {
		return jogador;
	}

	public void setJogador(char jogador) {
		Jogador.jogador = jogador;
	}

	//Médodo para definir a Jogada do Humano. Validando se as jogadas são válidas ou não
    public void userMove(Tabuleiro tab, Scanner scan) {

        int userMove = 0;
        while(!(userMove < 10) || !(userMove > 0)) {
            try {
                userMove = scan.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("Tipo de dado inválido.");
                System.out.println("Fechando o jogo...");
                System.exit(0);
            }

            if ( !(userMove > 0) || !(userMove < 10) ) {
                System.out.println("Escolha um número de 1 a 9.");
//                game.positionIsTaken(userMove);
            } else if (tab.positionIsTaken(userMove)) {
                System.out.println("Movimento já realizado!");
                System.out.println("Escolha outra posição");
                userMove = 0;
            }

        }

        tab.placeUserPosition(userMove, jogador);
    }

}
