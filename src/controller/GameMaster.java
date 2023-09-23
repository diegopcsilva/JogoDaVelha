package controller;

import java.util.ArrayList;
import java.util.List;

import model.AI;
import model.AIeasy;
import model.AIhard;
import model.AImedium;
import model.Humano;
import model.Tabuleiro;
import view.Interface;

public class GameMaster {
	
	private boolean whoStart;
	private boolean whoStartChoice;
	private boolean piece;
	private int level;
	private List<AI> aiLevel = new ArrayList<AI>();
	private Humano humano = new Humano();
	
	public GameMaster(boolean whoStartChoice, boolean piece, int level) {
		aiLevel.add(new AIeasy());
		aiLevel.add(new AImedium());
		aiLevel.add(new AIhard());
		this.whoStartChoice = whoStartChoice;
		this.piece = piece;
		this.level = level;
		this.whoStart = whoStartChoice;
	}
	
	public void play(){
		boolean loop = true;
		while (loop) {

			Tabuleiro tabu = new Tabuleiro();

			AI ai = aiLevel.get(level);

			Interface inter = new Interface();
			// tabu.view();

			tabu.clear();

			boolean emJogo = true;
			while (emJogo) {

				ai.updateScore(tabu.getM());

				if (whoStart) {

					tabu.jogada(humano.getEixoX(), humano.getEixoY());
					ai.updateScore(tabu.getM());
					inter.playerView(tabu.getM(), piece);
					if (ai.velha()) {
						System.out.println("Deu velha.");
						break;
					}
					if (ai.perdeu()) {
						System.out.println("Você Perdeu.");
						break;
					}
					if (ai.ganhou()) {
						System.out.println("Você Ganhou.");
						break;
					}
				}
				whoStart = true;
				System.out.println("É Vez do computador.");

				ai.updateScore(tabu.getM());
				tabu.setM(ai.jogada(tabu.getM()));
				ai.updateScore(tabu.getM());
				inter.playerView(tabu.getM(), piece);
				if (ai.velha()) {
					System.out.println("Deu velha.");
					break;
				}
				if (ai.perdeu()) {
					System.out.println("Você Perdeu.");
					break;
				}
				if (ai.ganhou()) {
					System.out.println("Você Ganhou.");
					break;
				}
			}
			whoStart = whoStartChoice;			
		}

	}


	public boolean isWhoStart() {
		return whoStart;
	}

	public void setWhoStart(boolean whoStart) {
		this.whoStart = whoStart;
	}

	public boolean isPiece() {
		return piece;
	}

	public void setPiece(boolean piece) {
		this.piece = piece;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}	

}
