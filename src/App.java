import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class App {
	static int[][] tab;
    
	public static void main(String[] args) {
			//escreva aqui o seu código
			Scanner sc = new Scanner(System.in);
		//	int n = sc.nextInt();
		//	int q = sc.nextInt();

			int n = 5;
			int q = 2;
			
			tab = new int[n][n];
			
			int op, x, r;
			for(int i = 0; i<q; i++) {
				op = sc.nextInt();
				x = sc.nextInt();
				
				if(op < 3) {
					r = sc.nextInt();
					
					if( op == 1 ) opLinha(x, r);
					else opColuna(x, r);
					
				} else {
					if( op == 3 ) System.out.println(freqLinha(x));
					else  System.out.println(freqColuna(x));
				}
			}
			
			sc.close();
	}
	
	static void opLinha(int x, int r) {
		for(int i = 0; i < tab.length; i++) {
			tab[x-1][i] = r;
		}
	}
	
	static void opColuna(int x, int r) {
		for(int i = 0; i < tab.length; i++) {
			tab[i][x-1] = r;
		}
	}
	
	 static int freqLinha(int x) {
		Arrays.sort(tab[x-1]);
		int count = 0, countMax = 0, numMax = 0;
		for(int i = 1; i < tab.length; i++) {
			int anterior = tab[x-1][i-1];
			int atual = tab[x-1][i];
		 
			if( atual == anterior ){
				count ++;
			} else {
				if( count >= countMax ) {
					countMax = count;
					numMax = atual;
					count = 0;
				}
			}
		}
		return numMax;
	}
	
	static int freqColuna(int x) {
		int[] coluna = new int[x];

		for(int i = 0; i < tab.length; i++) {
			coluna[i] = tab[i][x-1];
		}
		
		Arrays.sort(coluna);
		
		int count = 0, countMax = 0, numMax = 0;
		for(int i = 1; i < tab.length; i++) {
			int anterior = coluna[i-1];
			int atual = coluna[i];
		 
			if( atual == anterior ){
				count ++;
			} else {
				if( count >= countMax ) {
					countMax = count;
					numMax = atual;
					count = 0;
				}				
			}
		}
		return numMax;
	}
}

//2 4

// 1 1 1

// 2 2 2

// 3 1

// 3 2
