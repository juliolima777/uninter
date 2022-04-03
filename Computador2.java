package com.uninter;

import java.util.Random;

public class Computador2 extends Computador {
	static Random rand = new Random();
	
	//A única questão que muda na herança da classe computador é a dificuldade
    private static int minimax(int placement, char [] placements, boolean isMaximizing) {
    	Tabuleiro tab = new Tabuleiro();
        char[] copyPlacements = recreateGame(tab, placements);

        int score = 0;// Dificuldade máxima

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
