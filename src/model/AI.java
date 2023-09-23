package model;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class AI {
	
	Random gerador = new Random();
	
	int score;
	
	int round=0;
	
	private static int row1;
	private static int row2;
	private static int row3;
	
	private static int column1;
	private static int column2;
	private static int column3;
	
	private static int inclined1;
	private static int inclined2;
	
	protected boolean easy    ;
	protected boolean medium ;
	protected boolean hard   ;
	
	public AI() {
		easy = false;
		medium = false;
		hard = false;
		// TODO Auto-generated constructor stub
	}
	//public int[][] preferredMoves = {{1, 1}, {0, 0}, {0, 2}, {2, 0}, {2, 2},{0, 1}, {1, 0}, {1, 2}, {2, 1}};
	
	/*int[] lines = { { 0, 1, 2 }, { 3, 4, 5 }, 
            { 6, 7, 8 }, { 0, 3, 6 }, 
            { 1, 4, 7 }, { 2, 5, 8 }, 
            { 0, 4, 8 }, { 2, 4, 6 } 
            };*/
	public int[][] jogada(int[][] is) {
		round++;
		if (round==1 && is[1][1]==0){
			is[1][1]=1;
			return is;
		}
		if (round==1 && is[1][1]!=0){
			int mem = gerador.nextInt(4);
				if (mem == 0) is[0][0]=1;
				if (mem == 1) is[2][0]=1;
				if (mem == 2) is[0][2]=1;
				if (mem == 3) is[2][2]=1;
			return is;
		}
		
		
		
		return bestMove(is);
	}	
	public int[][] bestMove(int[][] is){
		List<Integer> scores = new ArrayList<Integer>();
		//System.out.printf("Tests \n"); 
		
		
	
		scores.add(row1);
		scores.add(row2);
		scores.add(row3);
		scores.add(column1);
		scores.add(column2);
		scores.add(column3);
		scores.add(inclined1);
		scores.add(inclined2);
		int maior = scores.get(0);
		
		for(int i = 0; i < scores.size()-1;i++) {
			if (maior<scores.get(i))
					maior = scores.get(i);
			  //System.out.println();  
			}  
		/*for(int i = 0; i < scores.size()-1;i++) {
			if (maior==scores.get(i)){
				scores.get(i);
				
			}	
		}*/ 
		if (row1==maior){
			if(is[0][0]==0){
				is[0][0]=1;// 1 é a jogado do PC
				return is;
			}
			if(is[0][2]==0){
				is[0][2]=1;
				return is;
			}
			if(is[0][1]==0){
				is[0][1]=1;
				return is;
			}
			
		}
		if (row2==maior){
			if(is[1][0]==0){
				is[1][0]=1;
				return is;
			}
			if(is[1][1]==0){
				is[1][1]=1;
				return is;
			}
			if(is[1][2]==0){
				is[1][2]=1;
				return is;
			}
		}
		if (row3==maior){
			if(is[2][0]==0){
				is[2][0]=1;
				return is;
			}
			if(is[2][1]==0){
				is[2][1]=1;
				return is;
			}
			if(is[2][2]==0){
				is[2][2]=1;
				return is;
			}
		}
		if (column1==maior){
			if(is[0][0]==0){
				is[0][0]=1;
				return is;
			}
			if(is[1][0]==0){
				is[1][0]=1;
				return is;
			}
			if(is[2][0]==0){
				is[2][0]=1;
				return is;
			}
		}
		if (column2==maior){
			if(is[0][1]==0){
				is[0][1]=1;
				return is;
			}
			if(is[1][1]==0){
				is[1][1]=1;
				return is;
			}
			if(is[2][1]==0){
				is[2][1]=1;
				return is;
			}
		}
		if (column3==maior){
			if(is[0][2]==0){
				is[0][2]=1;
				return is;
			}
						
			if(is[2][2]==0){
				is[2][2]=1;
				return is;
			}
			if(is[1][2]==0){
				is[1][2]=1;
				return is;
			}	
		}
		if (inclined1==maior){
			if(is[0][0]==0){
				is[0][0]=1;
				return is;
			}
			if(is[1][1]==0){
				is[1][1]=1;
				return is;
			}
			if(is[2][2]==0){
				is[2][2]=1;
				return is;
			}
		}
		if (inclined2==maior){
			if(is[0][2]==0){
				is[0][2]=1;
				return is;
			}
			if(is[1][1]==0){
				is[1][1]=1;
				return is;
			}
			if(is[2][0]==0){
				is[2][0]=1;
				return is;
			}
		}
		return is;
		
	}
	private void zerador(){
		setColumn1(0);
		setColumn2(0);
		setColumn3(0);
		setRow1(0);
		setRow2(0);
		setRow3(0);
		setInclined1(0);
		setInclined2(0);
	}
	public boolean velha(){
		if(row1==0 & row2==0 & row3==0 & column1==0 & column2==0 & column3==0 & inclined1==0 & inclined2==0){
			round =0;
			return true;
		}
		return false;
	}
	public boolean perdeu(){
		if(row1==1000 || row2==1000 || row3==1000 || column1==1000 || column2==1000 || column3==1000 || inclined1==1000 || inclined2==1000){
			round =0;
			return true;
		}
		return false;
	}
	public boolean ganhou(){
		if(row1==1001 || row2==1001 || row3==1001 || column1==1001 || column2==1001 || column3==1001 || inclined1==1001 || inclined2==1001){
			round =0;
			return true;
		}
		return false;
	}
	public void updateScore(int[][] m){
		zerador();
		if (m[0][0]==0 & m[0][1] ==0 & m[0][2]==0) row1 = 1;
		
		if (m[0][0]==1 & m[0][1] ==2 & m[0][2]==0) row1 = 000;//computador será 1("X")
		if (m[0][0]==1 & m[0][1] ==0 & m[0][2]==2) row1 = 000;
		if (m[0][0]==2 & m[0][1] ==1 & m[0][2]==0) row1 = 000;
		if (m[0][0]==0 & m[0][1] ==1 & m[0][2]==2) row1 = 000;
		if (m[0][0]==0 & m[0][1] ==2 & m[0][2]==1) row1 = 000;
		if (m[0][0]==2 & m[0][1] ==0 & m[0][2]==1) row1 = 000;
		
		if (m[0][0]==0 & m[0][1] ==1 & m[0][2]==0) row1 = 010;
		if (m[0][0]==0 & m[0][1] ==0 & m[0][2]==1) row1 = 010;
		if (m[0][0]==1 & m[0][1] ==0 & m[0][2]==0) row1 = 010;
		
		if (m[0][0]==1 & m[0][1] ==1 & m[0][2]==0) row1 = 100;
		if (m[0][0]==1 & m[0][1] ==0 & m[0][2]==1) row1 = 100;
		if (m[0][0]==0 & m[0][1] ==1 & m[0][2]==1) row1 = 100;
		
		if (m[0][0]==1 & m[0][1] ==1 & m[0][2]==1) row1 = 1000;
		
		//defesa
		
		if (!medium) {
			if (m[0][0] == 2 & m[0][1] == 0 & m[0][2] == 2)
				row1 = 020;
			if (m[0][0] == 2 & m[0][1] == 2 & m[0][2] == 0)
				row1 = 020;
			if (m[0][0] == 0 & m[0][1] == 2 & m[0][2] == 2)
				row1 = 020;
		}
		
		
		
		////////////////////////////////
		
		if (m[1][0]==0 & m[1][1] ==0 & m[1][2]==0) row2 = 1;
		
		if (m[1][0]==1 & m[1][1] ==2 & m[1][2]==0) row2 = 000;
		if (m[1][0]==1 & m[1][1] ==0 & m[1][2]==2) row2 = 000;
		if (m[1][0]==2 & m[1][1] ==1 & m[1][2]==0) row2 = 000;
		if (m[1][0]==0 & m[1][1] ==1 & m[1][2]==2) row2 = 000;
		if (m[1][0]==0 & m[1][1] ==2 & m[1][2]==1) row2 = 000;
		if (m[1][0]==2 & m[1][1] ==0 & m[1][2]==1) row2 = 000;
		
		if (m[1][0]==0 & m[1][1] ==1 & m[1][2]==0) row2 = 010;
		if (m[1][0]==0 & m[1][1] ==0 & m[1][2]==1) row2 = 010;
		if (m[1][0]==1 & m[1][1] ==0 & m[1][2]==0) row2 = 010;
		
		if (m[1][0]==1 & m[1][1] ==1 & m[1][2]==0) row2 = 100;
		if (m[1][0]==1 & m[1][1] ==0 & m[1][2]==1) row2 = 100;
		if (m[1][0]==0 & m[1][1] ==1 & m[1][2]==1) row2 = 100;
		
		if (m[1][0]==1 & m[1][1] ==1 & m[1][2]==1) row2 = 1000;
		
		//defesa
		
		if (!medium) {
			if (m[1][0] == 2 & m[1][1] == 0 & m[1][2] == 2)
				row2 = 020;
			if (m[1][0] == 2 & m[1][1] == 2 & m[1][2] == 0)
				row2 = 020;
			if (m[1][0] == 0 & m[1][1] == 2 & m[1][2] == 2)
				row2 = 020;
		}
		
		
		///////////////////////////////////
		
		if (m[2][0]==0 & m[2][1] ==0 & m[2][2]==0) row3 = 1;
		
		if (m[2][0]==1 & m[2][1] ==2 & m[2][2]==0) row3 = 000;
		if (m[2][0]==1 & m[2][1] ==0 & m[2][2]==2) row3 = 000;
		if (m[2][0]==2 & m[2][1] ==1 & m[2][2]==0) row3 = 000;
		if (m[2][0]==0 & m[2][1] ==1 & m[2][2]==2) row3 = 000;
		if (m[2][0]==0 & m[2][1] ==2 & m[2][2]==1) row3 = 000;
		if (m[2][0]==2 & m[2][1] ==0 & m[2][2]==1) row3 = 000;
		
		if (m[2][0]==0 & m[2][1] ==1 & m[2][2]==0) row3 = 010;
		if (m[2][0]==0 & m[2][1] ==0 & m[2][2]==1) row3 = 010;
		if (m[2][0]==1 & m[2][1] ==0 & m[2][2]==0) row3 = 010;
		
		if (m[2][0]==1 & m[2][1] ==1 & m[2][2]==0) row3 = 100;
		if (m[2][0]==1 & m[2][1] ==0 & m[2][2]==1) row3 = 100;
		if (m[2][0]==0 & m[2][1] ==1 & m[2][2]==1) row3 = 100;
		
		if (m[2][0]==1 & m[2][1] ==1 & m[2][2]==1) row3 = 1000;
		
		//defesa
		
		if (!medium) {
			if (m[2][0] == 2 & m[2][1] == 0 & m[2][2] == 2)
				row3 = 020;
			if (m[2][0] == 2 & m[2][1] == 2 & m[2][2] == 0)
				row3 = 020;
			if (m[2][0] == 0 & m[2][1] == 2 & m[2][2] == 2)
				row3 = 020;
		}
		
		
		////////////////////////////////////
		
		if (m[0][0]==0 & m[1][0] ==0 & m[2][0]==0) column1 = 1;
		
		if (m[0][0]==1 & m[1][0] ==2 & m[2][0]==0) column1 = 000;//computador será 1("X")
		if (m[0][0]==1 & m[1][0] ==0 & m[2][0]==2) column1 = 000;
		if (m[0][0]==2 & m[1][0] ==1 & m[2][0]==0) column1 = 000;
		if (m[0][0]==0 & m[1][0] ==1 & m[2][0]==2) column1 = 000;
		if (m[0][0]==0 & m[1][0] ==2 & m[2][0]==1) column1 = 000;
		if (m[0][0]==2 & m[1][0] ==0 & m[2][0]==1) column1 = 000;
		
		if (m[0][0]==0 & m[1][0] ==1 & m[2][0]==0) column1 = 010;
		if (m[0][0]==0 & m[1][0] ==0 & m[2][0]==1) column1 = 010;
		if (m[0][0]==1 & m[1][0] ==0 & m[2][0]==0) column1 = 010;
		
		if (m[0][0]==1 & m[1][0] ==1 & m[2][0]==0) column1 = 100;
		if (m[0][0]==1 & m[1][0] ==0 & m[2][0]==1) column1 = 100;
		if (m[0][0]==0 & m[1][0] ==1 & m[2][0]==1) column1 = 100;
		
		if (m[0][0]==1 & m[1][0] ==1 & m[2][0]==1) column1 = 1000;
		
		//def
		
		
		if (!medium) {
			if (m[0][0] == 2 & m[1][0] == 0 & m[2][0] == 2)
				column1 = 020;
			if (m[0][0] == 2 & m[1][0] == 2 & m[2][0] == 0)
				column1 = 020;
			if (m[0][0] == 0 & m[1][0] == 2 & m[2][0] == 2)
				column1 = 020;
		}
		
		
		////////////////////////////////
		
		if (m[0][1]==0 & m[1][1] ==0 & m[2][1]==0) column2 = 1;
		
		if (m[0][1]==1 & m[1][1] ==2 & m[2][1]==0) column2 = 000;
		if (m[0][1]==1 & m[1][1] ==0 & m[2][1]==2) column2 = 000;
		if (m[0][1]==2 & m[1][1] ==1 & m[2][1]==0) column2 = 000;
		if (m[0][1]==0 & m[1][1] ==1 & m[2][1]==2) column2 = 000;
		if (m[0][1]==0 & m[1][1] ==2 & m[2][1]==1) column2 = 000;
		if (m[0][1]==2 & m[1][1] ==0 & m[2][1]==1) column2 = 000;
		
		if (m[0][1]==0 & m[1][1] ==1 & m[2][1]==0) column2 = 010;
		if (m[0][1]==0 & m[1][1] ==0 & m[2][1]==1) column2 = 010;
		if (m[0][1]==1 & m[1][1] ==0 & m[2][1]==0) column2 = 010;
		
		if (m[0][1]==1 & m[1][1] ==1 & m[2][1]==0) column2 = 100;
		if (m[0][1]==1 & m[1][1] ==0 & m[2][1]==1) column2 = 100;
		if (m[0][1]==0 & m[1][1] ==1 & m[2][1]==1) column2 = 100;
		
		if (m[0][1]==1 & m[1][1] ==1 & m[2][1]==1) column2 = 1000;
		
		//def
		
		if (!medium) {
			if (m[0][1] == 2 & m[1][1] == 0 & m[2][1] == 2)
				column2 = 020;
			if (m[0][1] == 2 & m[1][1] == 2 & m[2][1] == 0)
				column2 = 020;
			if (m[0][1] == 0 & m[1][1] == 2 & m[2][1] == 2)
				column2 = 020;
		}
		
		
		///////////////////////////////////
		
		if (m[0][2]==0 & m[1][2] ==0 & m[2][2]==0) column3 = 1;
		
		if (m[0][2]==1 & m[1][2] ==2 & m[2][2]==0) column3 = 000;
		if (m[0][2]==1 & m[1][2] ==0 & m[2][2]==2) column3 = 000;
		if (m[0][2]==2 & m[1][2] ==1 & m[2][2]==0) column3 = 000;
		if (m[0][2]==0 & m[1][2] ==1 & m[2][2]==2) column3 = 000;
		if (m[0][2]==0 & m[1][2] ==2 & m[2][2]==1) column3 = 000;
		if (m[0][2]==2 & m[1][2] ==0 & m[2][2]==1) column3 = 000;
		
		if (m[0][2]==0 & m[1][2] ==1 & m[2][2]==0) column3 = 010;
		if (m[0][2]==0 & m[1][2] ==0 & m[2][2]==1) column3 = 010;
		if (m[0][2]==1 & m[1][2] ==0 & m[2][2]==0) column3 = 010;
		
		if (m[0][2]==1 & m[1][2] ==1 & m[2][2]==0) column3 = 100;
		if (m[0][2]==1 & m[1][2] ==0 & m[2][2]==1) column3 = 100;
		if (m[0][2]==0 & m[1][2] ==1 & m[2][2]==1) column3 = 100;
		
		if (m[0][2]==1 & m[1][2] ==1 & m[2][2]==1) column3 = 1000;
		
		//def
		
		if (!medium) {
			if (m[0][2] == 2 & m[1][2] == 0 & m[2][2] == 2)
				column3 = 020;
			if (m[0][2] == 2 & m[1][2] == 2 & m[2][2] == 0)
				column3 = 020;
			if (m[0][2] == 0 & m[1][2] == 2 & m[2][2] == 2)
				column3 = 020;
		}
		
		
		/////////////////////////////////////
		
		if (m[0][0]==0 & m[1][1] ==0 & m[2][2]==0) inclined1 = 1;
		
		if (m[0][0]==1 & m[1][1] ==2 & m[2][2]==0) inclined1 = 000;//computador será 1("X")
		if (m[0][0]==1 & m[1][1] ==0 & m[2][2]==2) inclined1 = 000;
		if (m[0][0]==2 & m[1][1] ==1 & m[2][2]==0) inclined1 = 000;
		if (m[0][0]==0 & m[1][1] ==1 & m[2][2]==2) inclined1 = 000;
		if (m[0][0]==0 & m[1][1] ==2 & m[2][2]==1) inclined1 = 000;
		if (m[0][0]==2 & m[1][1] ==0 & m[2][2]==1) inclined1 = 000;
		
		if (m[0][0]==0 & m[1][1] ==1 & m[2][2]==0) inclined1 = 010;
		if (m[0][0]==0 & m[1][1] ==0 & m[2][2]==1) inclined1 = 010;
		if (m[0][0]==1 & m[1][1] ==0 & m[2][2]==0) inclined1 = 010;
		
		if (m[0][0]==1 & m[1][1] ==1 & m[2][2]==0) inclined1 = 100;
		if (m[0][0]==1 & m[1][1] ==0 & m[2][2]==1) inclined1 = 100;
		if (m[0][0]==0 & m[1][1] ==1 & m[2][2]==1) inclined1 = 100;
		
		if (m[0][0]==1 & m[1][1] ==1 & m[2][2]==1) inclined1 = 1000;
		
		//def
		
		if (!medium) {
			if (m[0][0] == 2 & m[1][1] == 0 & m[2][2] == 2)
				inclined1 = 020;
			if (m[0][0] == 2 & m[1][1] == 2 & m[2][2] == 0)
				inclined1 = 020;
			if (m[0][0] == 0 & m[1][1] == 2 & m[2][2] == 2)
				inclined1 = 020;
		}
		
		
		//////////////////////////////////
		
		if (m[2][0]==0 & m[1][1] ==0 & m[0][2]==0) inclined2 = 1;
		
		if (m[2][0]==1 & m[1][1] ==2 & m[0][2]==0) inclined2 = 000;
		if (m[2][0]==1 & m[1][1] ==0 & m[0][2]==2) inclined2 = 000;
		if (m[2][0]==2 & m[1][1] ==1 & m[0][2]==0) inclined2 = 000;
		if (m[2][0]==0 & m[1][1] ==1 & m[0][2]==2) inclined2 = 000;
		if (m[2][0]==0 & m[1][1] ==2 & m[0][2]==1) inclined2 = 000;
		if (m[2][0]==2 & m[1][1] ==0 & m[0][2]==1) inclined2 = 000;
		
		if (m[2][0]==0 & m[1][1] ==1 & m[0][2]==0) inclined2 = 010;
		if (m[2][0]==0 & m[1][1] ==0 & m[0][2]==1) inclined2 = 010;
		if (m[2][0]==1 & m[1][1] ==0 & m[0][2]==0) inclined2 = 010;
		
		if (m[2][0]==1 & m[1][1] ==1 & m[0][2]==0) inclined2 = 100;
		if (m[2][0]==1 & m[1][1] ==0 & m[0][2]==1) inclined2 = 100;
		if (m[2][0]==0 & m[1][1] ==1 & m[0][2]==1) inclined2 = 100;
		
		if (m[2][0]==1 & m[1][1] ==1 & m[0][2]==1) inclined2 = 1000;
		
		//player ganha
		
		if (m[0][0]==2 & m[0][1] ==2 & m[0][2]==2) row1      = 1001;
		if (m[1][0]==2 & m[1][1] ==2 & m[1][2]==2) row2 	 = 1001;
		if (m[2][0]==2 & m[2][1] ==2 & m[2][2]==2) row3 	 = 1001;
		if (m[0][0]==2 & m[1][0] ==2 & m[2][0]==2) column1 	 = 1001;
		if (m[0][1]==2 & m[1][1] ==2 & m[2][1]==2) column2 	 = 1001;
		if (m[0][2]==2 & m[1][2] ==2 & m[2][2]==2) column3 	 = 1001;
		if (m[0][0]==2 & m[1][1] ==2 & m[2][2]==2) inclined1 = 1001;
		if (m[2][0]==2 & m[1][1] ==2 & m[0][2]==2) inclined2 = 1001;
		/*if (m[2][0]==2 & m[1][1] ==0 & m[0][2]==2) inclined2 = 020;
		if (m[2][0]==2 & m[1][1] ==2 & m[0][2]==0) inclined2 = 020;
		if (m[2][0]==0 & m[1][1] ==2 & m[0][2]==2) inclined2 = 020;*/
		
		//def inclinada
		
		
		//DEFESA
		
		
		
		/*for(int i=0;i<3;i++){
			
			System.out.printf("\n");
			
			for(int j=0;j<3;j++){
				
				System.out.printf("%d ",m[i][j]);	
			}
		}*/
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getRow1() {
		return row1;
	}
	public static void setRow1(int row1) {
		AI.row1 = row1;
	}
	public int getRow2() {
		return row2;
	}
	public void setRow2(int row2) {
		AI.row2 = row2;
	}
	public int getRow3() {
		return row3;
	}
	public static void setRow3(int row3) {
		AI.row3 = row3;
	}
	public int getColumn1() {
		return column1;
	}
	public static void setColumn1(int column1) {
		AI.column1 = column1;
	}
	public int getColumn2() {
		return column2;
	}
	public static void setColumn2(int column2) {
		AI.column2 = column2;
	}
	public int getColumn3() {
		return column3;
	}
	public static void setColumn3(int column3) {
		AI.column3 = column3;
	}
	public int getInclined1() {
		return inclined1;
	}
	public static void setInclined1(int inclined1) {
		AI.inclined1 = inclined1;
	}
	public int getInclined2() {
		return inclined2;
	}
	public static void setInclined2(int inclined2) {
		AI.inclined2 = inclined2;
	}
	
}
