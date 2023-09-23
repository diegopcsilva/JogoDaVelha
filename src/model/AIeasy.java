package model;

public class AIeasy extends AI {

	public AIeasy() {
		// TODO Auto-generated constructor stub
		super();
		easy = true;

	}

	// Random gerador = new Random();

	public int[][] jogada(int[][] is) {

		while (true) {
			int mem = gerador.nextInt(9);

			if (mem == 0) {
				if (is[0][0] == 0) {
					is[0][0] = 1;// 1 é a jogada do PC
					return is;
				}
			}
			if (mem == 1) {
				if (is[0][1] == 0) {
					is[0][1] = 1;// 1 é a jogado do PC
					return is;
				}
			}
			if (mem == 2) {
				if (is[0][2] == 0) {
					is[0][2] = 1;// 1 é a jogado do PC
					return is;
				}
			}
			if (mem == 3) {
				if (is[1][0] == 0) {
					is[1][0] = 1;// 1 é a jogada do PC
					return is;
				}
			}
			if (mem == 4) {
				if (is[1][1] == 0) {
					is[1][1] = 1;// 1 é a jogado do PC
					return is;
				}
			}
			if (mem == 5) {
				if (is[1][2] == 0) {
					is[1][2] = 1;// 1 é a jogado do PC
					return is;
				}
			}
			if (mem == 6) {
				if (is[2][0] == 0) {
					is[2][0] = 1;// 1 é a jogada do PC
					return is;
				}
			}
			if (mem == 7) {
				if (is[2][1] == 0) {
					is[2][1] = 1;// 1 é a jogado do PC
					return is;
				}
			}
			if (mem == 8) {
				if (is[2][2] == 0) {
					is[2][2] = 1;// 1 é a jogado do PC
					return is;
				}
			}
		}

	}

}
