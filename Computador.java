package com.uninter;

import java.util.Random;

public class Computador {
	
	//Utiliza��o da Biblioteca Random para selecionar as jogadas do Computador
    static Random rand = new Random();

    //M�dodoo para preencher as posi��es do Vetor de Jogadas 
    public int move(char[] placements) {

        int guess;
        do {
            guess = guess();
        } while (placements[guess] != ' ');

        return guess;
    }

    //M�todo para o computador escolher um n�mero de 1 a 9
    public static int guess() {
        return rand.nextInt(9);
    }

    //M�todo para escolher o Melhor movimento do Computador. � Com esse m�todo que definimos a dificuldade do computador
    public int bestMove(char[] placements) {

        int bestScore = -1000;
        int bestMove = 0;
        for( char i=0; i < placements.length; i++) {
            if (placements[i] == ' ' ) {
                int score = minimax(i, placements,true);
                if (score > bestScore) {
                    bestScore = score;
                    bestMove = i;
                    
                }
            }
        }


        return bestMove;
    }

    //M�todo para analise de poss�veis jogadas do computador
    private static int minimax(int placement, char [] placements, boolean isMaximizing) {
    	Tabuleiro tab = new Tabuleiro();
        char[] copyPlacements = recreateGame(tab, placements);

        int score = 10;//Essa vari�vel define qual ser� a dificuldade (0 � o mais dif�cil Poss�vel) - Dificuldade f�cil

        if(isMaximizing && tab.isWon()){
            return 1;
        } else if(!isMaximizing && tab.isWon()) {
            return -1;
        } else if(tab.isTie()) {
            return 0;
        }

        if(isMaximizing) {
        	tab.placeComputerPosition(placement,'O');
            if(tab.isWon()) {
                return 1;
            }
            for( char i=0; i < placements.length; i++) {
                if (placements[i] == ' ' ) {
                    score += minimax(i, copyPlacements, false);
                }
            }

        } else {
        	tab.placeUserPosition(placement+1,'X');
            if(tab.isWon()) {
                return -1;
            }
            for( char i=0; i < placements.length; i++) {
                if (placements[i] == ' ' ) {
                    score += minimax(i, copyPlacements, true);
                }
            }
        }

        return score;

    }


    private static char[] recreateGame(Tabuleiro game, char[] placements) {
        for (char i=0; i < placements.length; i++) {
            if(placements[i] == 'X') {
                game.placeUserPosition(i+1, 'X');
            } else if (placements[i] == 'O') {
                game.placeComputerPosition(i, 'O');
            }
        }
        return game.getPlacements();
    }

}
