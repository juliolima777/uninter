package com.uninter;


public class Tabuleiro {
	//Criação da matriz que constroi o tabuleiro
    private final char[][] board = {
            {' ','|',' ','|',' '},
            {'-','+','-','+','-'},
            {' ','|',' ','|',' '},
            {'-','+','-','+','-'},
            {' ','|',' ','|',' '}
    };

    //Reserva as posições para as Jogadas	
    private final char[] placements = {' ',' ',' ',' ',' ',' ',' ',' ',' '};

    //Cria um vetor para armazenas as possíveis posições de Vitória	
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

    //Método para verificar se temos um vencedor na partida
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
    
    //Método para validar as posições vencedoras
    private static boolean isPositionWon(String position) {
        return position.equals("XXX") || position.equals("OOO");
    }

    //Médodo para definir qual o vencedor da partida
    public void setWinner(String winner) {
        this.winner = winner.charAt(0);
    }

    //Médodo para mostrar o Tabuleiro
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

    //Métodos para imprimir o Tabuleiro com as opções a ser selecionadas
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

    //Método para verificar se todas as casas já estão preenchidas
    public boolean isLastMove() {
        for(char placement : placements) {
            if (placement == ' ') {
                return false;
            }
        }
        return true;
    }

    //Métodos para setar as posições tomadas pelo Jogador ou Computador
    public void placeUserPosition(int position, char XorO) {
        this.placements[position-1] = XorO;
    }
    public void placeComputerPosition(int position, char XorO) {
        this.placements[position] = XorO;
    }

    public boolean positionIsTaken(int position) {
        return this.placements[position-1] != ' ';
    }

    //Médodo para verificar se houve um empate no Jogo
    public boolean isTie() {
        for(char placement : this.getPlacements()){
            if(placement == ' ') {
                return false;
            }
        }
        return true;
    }

}
