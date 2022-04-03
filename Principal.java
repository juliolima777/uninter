package com.uninter;

import java.util.Scanner;

public class Principal {
	
	//M�dodos que definem as jogadas do computador no tabuleiro conforme o N�vel.
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

    //Inicializa��o das Classes
	public static void main(String[] args) {
		Tabuleiro tab = new Tabuleiro();
        Scanner scan = new Scanner(System.in);
        Computador con;
        Jogador jogador = new Jogador('X');
        
        

        
        //Incializa��o do Jogo
        System.out.println("Bem Vindo ao Jogo da Velha!");
        System.out.println("Escolha a o N�vel do computador de 1 a 3.");
        
        int nivel = scan.nextInt();
        
        //Inicializa��o do Jogo conforme o N�vel de computador selecionado pelo Usu�rio
        if(nivel == 1) {
        	System.out.println("Computador N�vel 1 Selecionado!");
        	con = new Computador(); 
            intro(tab);
            
            //Comando While para manter o jogo executando enquanto houverem jogadas v�lidas ou um vencedor
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
        	System.out.println("Computador N�vel 2 Selecionado!");
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
        	System.out.println("Computador N�vel 3 Selecionado!");
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


	//M�dodo para inicializa��o do tabuleiro
	public static void intro(Tabuleiro tab) {
        
        System.out.println("Escolha um n�mero de 1 a 9. Conforme o Tabuleiro!");
        tab.showOptions();
    }

	//M�todo para imprimir o jogo empatado
    public static void gameTie(Tabuleiro tab) {
        System.out.println("Jogo Empatado!");
        tab.printBoard();
        System.exit(0);
    }

    //M�todo para incializar o print do vencedor
    public static void gameWon(Tabuleiro tab) {
        finalPrint(tab);
        System.exit(0);
    }


    //M�dodo para imprimir o vencedor
    public static void finalPrint(Tabuleiro tab) {
    	tab.printBoard();
        System.out.printf("%s Venceu o Jogo!", tab.getWinner());


	}

}
