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

	//M�dodo para definir a Jogada do Humano. Validando se as jogadas s�o v�lidas ou n�o
    public void userMove(Tabuleiro tab, Scanner scan) {

        int userMove = 0;
        while(!(userMove < 10) || !(userMove > 0)) {
            try {
                userMove = scan.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("Tipo de dado inv�lido.");
                System.out.println("Fechando o jogo...");
                System.exit(0);
            }

            if ( !(userMove > 0) || !(userMove < 10) ) {
                System.out.println("Escolha um n�mero de 1 a 9.");
//                game.positionIsTaken(userMove);
            } else if (tab.positionIsTaken(userMove)) {
                System.out.println("Movimento j� realizado!");
                System.out.println("Escolha outra posi��o");
                userMove = 0;
            }

        }

        tab.placeUserPosition(userMove, jogador);
    }

}
