package view;


public class Interface {
	
	
	/**
	 * 
	 * @param tabuleiro
	 * @param change
	 */
	public void playerView(int[][] tabuleiro, boolean change){
		
		if(change){
		
			if(tabuleiro[0][0]==0) System.out.print("  ");//0 = vazio
			if(tabuleiro[0][0]==1) System.out.print("O ");//1 = AI
			if(tabuleiro[0][0]==2) System.out.print("X ");//2 = Humano
			
			if(tabuleiro[0][1]==0) System.out.print("  ");
			if(tabuleiro[0][1]==1) System.out.print("O ");
			if(tabuleiro[0][1]==2) System.out.print("X ");
			
			if(tabuleiro[0][2]==0) System.out.print("  |\n");
			if(tabuleiro[0][2]==1) System.out.print("O |\n");
			if(tabuleiro[0][2]==2) System.out.print("X |\n");
			
			
			if(tabuleiro[1][0]==0) System.out.print("  ");
			if(tabuleiro[1][0]==1) System.out.print("O ");
			if(tabuleiro[1][0]==2) System.out.print("X ");
			
			if(tabuleiro[1][1]==0) System.out.print("  ");
			if(tabuleiro[1][1]==1) System.out.print("O ");
			if(tabuleiro[1][1]==2) System.out.print("X ");
			
			if(tabuleiro[1][2]==0) System.out.print("  |\n");
			if(tabuleiro[1][2]==1) System.out.print("O |\n");
			if(tabuleiro[1][2]==2) System.out.print("X |\n");
			
			
			if(tabuleiro[2][0]==0) System.out.print("  ");
			if(tabuleiro[2][0]==1) System.out.print("O ");
			if(tabuleiro[2][0]==2) System.out.print("X ");
			
			if(tabuleiro[2][1]==0) System.out.print("  ");
			if(tabuleiro[2][1]==1) System.out.print("O ");
			if(tabuleiro[2][1]==2) System.out.print("X ");
			
			if(tabuleiro[2][2]==0) System.out.print("  |\n");
			if(tabuleiro[2][2]==1) System.out.print("O |\n");
			if(tabuleiro[2][2]==2) System.out.print("X |\n\n");
		
		}else{
		
			if(tabuleiro[0][0]==0) System.out.print("  ");
			if(tabuleiro[0][0]==1) System.out.print("X ");
			if(tabuleiro[0][0]==2) System.out.print("O ");
			
			if(tabuleiro[0][1]==0) System.out.print("  ");
			if(tabuleiro[0][1]==1) System.out.print("X ");
			if(tabuleiro[0][1]==2) System.out.print("O ");
			
			if(tabuleiro[0][2]==0) System.out.print("  |\n");
			if(tabuleiro[0][2]==1) System.out.print("X |\n");
			if(tabuleiro[0][2]==2) System.out.print("O |\n");
			
			
			if(tabuleiro[1][0]==0) System.out.print("  ");
			if(tabuleiro[1][0]==1) System.out.print("X ");
			if(tabuleiro[1][0]==2) System.out.print("O ");
			
			if(tabuleiro[1][1]==0) System.out.print("  ");
			if(tabuleiro[1][1]==1) System.out.print("X ");
			if(tabuleiro[1][1]==2) System.out.print("O ");
			
			if(tabuleiro[1][2]==0) System.out.print("  |\n");
			if(tabuleiro[1][2]==1) System.out.print("X |\n");
			if(tabuleiro[1][2]==2) System.out.print("O |\n");
			
			
			if(tabuleiro[2][0]==0) System.out.print("  ");
			if(tabuleiro[2][0]==1) System.out.print("X ");
			if(tabuleiro[2][0]==2) System.out.print("O ");
			
			if(tabuleiro[2][1]==0) System.out.print("  ");
			if(tabuleiro[2][1]==1) System.out.print("X ");
			if(tabuleiro[2][1]==2) System.out.print("O ");
			
			if(tabuleiro[2][2]==0) System.out.print("  |\n");
			if(tabuleiro[2][2]==1) System.out.print("X |\n");
			if(tabuleiro[2][2]==2) System.out.print("O |\n\n");
			
		}
	}
}
