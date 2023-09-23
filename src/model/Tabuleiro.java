package model;


public class Tabuleiro {
	
	int m[][] = new int[3][3];
	
	public int[][] getM() {
		return m;
	}

	public void setM(int[][] m) {
		this.m = m;
	}

	public Tabuleiro() {
		// TODO Auto-generated constructor stub
		
		for(int i=0;i<3;i++){
			
			for(int j=0;j<3;j++){
				m[i][j]=0;	
			}
		}	
	}
	
	
	public void jogada(int a,int b){
		m[a][b]=2;
	}
	
	public void view(){
		
		for(int i=0;i<3;i++){
			
			System.out.printf("\n");
			
			for(int j=0;j<3;j++){
				
				System.out.printf("%d ",m[i][j]);	
			}
		}	
	}

	public void clear() {
		// TODO Auto-generated method stub
		for(int i=0;i<3;i++){
			
			for(int j=0;j<3;j++){
				m[i][j]=0;	
			}
		}
	}
	
}

