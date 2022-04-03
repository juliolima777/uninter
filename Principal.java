package com.uninter;

import java.util.Scanner;

public class Principal {
	
	//Médodos que definem as jogadas do computador no tabuleiro conforme o Nível.
    public static void computerMove(Tabuleiro tab, Computador computer) {
        int computerMove = computer.bestMove(tab.getPlacements());
        tab.placeComputerPosition(computerMove, 'O'); 
    }
    
    public static void computerMove2(Tabuleiro tab, Computador1 con) {
        int computerMove = con.bestMove(tab.getPlacements());
        tab.placeComputerPosition(computerMove, 'O'); 
    }
    public static void computerMove3(Tabuleiro tab, Computador2 con) {
        int computerMove = con.bestMove(tab.getPlacements());
        tab.placeComputerPosition(computerMove, 'O'); 
    }  

    //Inicialização das Classes
	public static void main(String[] args) {
		Tabuleiro tab = new Tabuleiro();
        Scanner scan = new Scanner(System.in);
        Computador con;
        Jogador jogador = new Jogador('X');
        
        

        
        //Incialização do Jogo
        System.out.println("Bem Vindo ao Jogo da Velha!");
        System.out.println("Escolha a o Nível do computador de 1 a 3.");
        
        int nivel = scan.nextInt();
        
        //Inicialização do Jogo conforme o Nível de computador selecionado pelo Usuário
        if(nivel == 1) {
        	System.out.println("Computador Nível 1 Selecionado!");
        	con = new Computador(); 
            intro(tab);
            
            //Comando While para manter o jogo executando enquanto houverem jogadas válidas ou um vencedor
            while(!tab.isWon()) {
            	jogador.userMove(tab, scan);

                if (tab.isLastMove()) {
                    if (tab.isWon()) gameWon(tab);
                    else gameTie(tab);
                } else computerMove(tab, con);

                tab.printBoard();
            }

            finalPrint(tab);
        	
        }
        else if(nivel == 2) {
        	System.out.println("Computador Nível 2 Selecionado!");
        	con = new Computador1(); 
            intro(tab);

            while(!tab.isWon()) {
            	jogador.userMove(tab, scan);

                if (tab.isLastMove()) {
                    if (tab.isWon()) gameWon(tab);
                    else gameTie(tab);
                } else computerMove2(tab, (Computador1) con);

                tab.printBoard();
            }

            finalPrint(tab);        	
        	
        }
        else if(nivel == 3) {
        	System.out.println("Computador Nível 3 Selecionado!");
        	con = new Computador2(); 
            intro(tab);

            while(!tab.isWon()) {
            	jogador.userMove(tab, scan);

                if (tab.isLastMove()) {
                    if (tab.isWon()) gameWon(tab);
                    else gameTie(tab);
                } else computerMove3(tab, (Computador2) con);

                tab.printBoard();
            }
        	
        	
        }        
        
                
        

    }


	//Médodo para inicialização do tabuleiro
	public static void intro(Tabuleiro tab) {
        
        System.out.println("Escolha um número de 1 a 9. Conforme o Tabuleiro!");
        tab.showOptions();
    }

	//Método para imprimir o jogo empatado
    public static void gameTie(Tabuleiro tab) {
        System.out.println("Jogo Empatado!");
        tab.printBoard();
        System.exit(0);
    }

    //Método para incializar o print do vencedor
    public static void gameWon(Tabuleiro tab) {
        finalPrint(tab);
        System.exit(0);
    }


    //Médodo para imprimir o vencedor
    public static void finalPrint(Tabuleiro tab) {
    	tab.printBoard();
        System.out.printf("%s Venceu o Jogo!", tab.getWinner());


	}

}
