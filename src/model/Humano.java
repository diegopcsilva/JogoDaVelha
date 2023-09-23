package model;

import java.util.Scanner;

public class Humano {
	
	
	private Scanner sc = new Scanner(System.in);
	
	
	public Humano() {
	}

	public  int getEixoX() {
		System.out.println("Escolha uma posição, digitando a linha (1-3)");		
		return (sc.nextInt()) -1;
	}


	public int getEixoY() {
		System.out.println("Escolha uma posição, digitando a coluna (1-3)");
		return (sc.nextInt()) -1;
	}
	
	
	

}
