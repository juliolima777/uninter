package com.uninter;


public class Tabuleiro {
	//Cria��o da matriz que constroi o tabuleiro
    private final char[][] board = {
            {' ','|',' ','|',' '},
            {'-','+','-','+','-'},
            {' ','|',' ','|',' '},
            {'-','+','-','+','-'},
            {' ','|',' ','|',' '}
    };

    //Reserva as posi��es para as Jogadas	
    private final char[] placements = {' ',' ',' ',' ',' ',' ',' ',' ',' '};

    //Cria um vetor para armazenas as poss�veis posi��es de Vit�ria	
    public String[] winningPositions = new String[8];

    private char winner;

    private void updateWinningPositions() {
        winningPositions[0] = "" + this.placements[0] + this.placements[1] + this.placements[2];
        winningPositions[1] = "" + this.placements[3] + this.placements[4] + this.placements[5];
        winningPositions[2] = "" + this.placements[6] + this.placements[7] + this.placements[8];
        winningPositions[3] = "" + this.placements[0] + this.placements[3] + this.placements[6];
        winningPositions[4] = "" + this.placements[1] + this.placements[4] + this.placements[7];
        winningPositions[5] = "" + this.placements[2] + this.placements[5] + this.placements[8];
        winningPositions[6] = "" + this.placements[0] + this.placements[4] + this.placements[8];
        winningPositions[7] = "" + this.placements[6] + this.placements[4] + this.placements[2];
    }

    public char[][] getBoard() {
        return this.board;
    }

    public char getWinner() {
        return winner;
    }

    public char[] getPlacements() {
        return this.placements;
    }

    //M�todo para verificar se temos um vencedor na partida
    public boolean isWon() {

        updateWinningPositions();

        for(String position : winningPositions) {
            if( isPositionWon(position) ) {
                setWinner(position);
                return true;
            }
        }
        return false;
    }
    
    //M�todo para validar as posi��es vencedoras
    private static boolean isPositionWon(String position) {
        return position.equals("XXX") || position.equals("OOO");
    }

    //M�dodo para definir qual o vencedor da partida
    public void setWinner(String winner) {
        this.winner = winner.charAt(0);
    }

    //M�dodo para mostrar o Tabuleiro
    public void printBoard() {
        int count = 0;
        for (char[] row : this.board) {
            for(char col : row) {
                if (col == ' ') {
                    System.out.print(this.placements[count]);
                    count++;
                } else {
                    System.out.print(col);
                }
            }
            System.out.println();
        }
    }

    //M�todos para imprimir o Tabuleiro com as op��es a ser selecionadas
    public void showOptions() {
        int count = 1;
        for (char[] row : this.board) {
            for (char col : row) {
                if (col == ' ') {
                    System.out.print(count);
                    count++;
                } else {
                    System.out.print(col);
                }
            }
            System.out.println();
        }
    }

    //M�todo para verificar se todas as casas j� est�o preenchidas
    public boolean isLastMove() {
        for(char placement : placements) {
            if (placement == ' ') {
                return false;
            }
        }
        return true;
    }

    //M�todos para setar as posi��es tomadas pelo Jogador ou Computador
    public void placeUserPosition(int position, char XorO) {
        this.placements[position-1] = XorO;
    }
    public void placeComputerPosition(int position, char XorO) {
        this.placements[position] = XorO;
    }

    public boolean positionIsTaken(int position) {
        return this.placements[position-1] != ' ';
    }

    //M�dodo para verificar se houve um empate no Jogo
    public boolean isTie() {
        for(char placement : this.getPlacements()){
            if(placement == ' ') {
                return false;
            }
        }
        return true;
    }

}
