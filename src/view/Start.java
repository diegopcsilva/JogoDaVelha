package view;

import java.util.Scanner;

import controller.GameMaster;

public class Start {

	private static Scanner entrada;
	static boolean inicia;
	static boolean iniciaEscolha;
	static int level;
	static int X;
	static int Y;
	static boolean seX;
	static boolean loop;
	static boolean menu = true;

	public void start() {
		System.out.println("Início - Jogo da Velha");
		entrada = new Scanner(System.in);

		System.out
				.println("Quer começar? Se sim digite: true. Se não digite: false ");
		iniciaEscolha = entrada.nextBoolean();
		inicia = iniciaEscolha;
		System.out
				.println("Quer ser X ou O? Se X, digite: true. Se não digite: false ");
		seX = entrada.nextBoolean();
		System.out
				.println("Escolha o nível. Para fácil, digite 0 , médio 1, díficil 2.");
		level = entrada.nextInt();
		
		GameMaster newGame = new GameMaster(iniciaEscolha, seX, level);
		newGame.play();
		
	}	
		
}
