import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class App {
	static int[][] tab;
    
	public static void main(String[] args) {
		//escreva aqui o seu código
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();

		int[][] tab = new int[n][n];
		int op, x, r;
		for(int i=0; i < q; i++) {
			op = sc.nextInt();
			x = sc.nextInt();

			switch(op) {

				case 1:
					r = sc.nextInt();
					linha(tab, x, r);
					break;

				case 2:
					r = sc.nextInt();
					coluna(tab, x, r);
					break;
				case 3:
					int[] linha = tab[x-1];
					// Arrays.sort(linha);
					Map<Integer, Integer> count = new HashMap<>();
					for(int j = 0; j < linha.length; j++) {
						if(count.containsKey(linha[j])) {
							count.put(linha[j], count.get(linha[j]) + 1);
						} else{
							count.put(linha[j], 1);
						}
					}
			
					Map.Entry<Integer, Integer> a = (Map.Entry<Integer, Integer>) count.entrySet()
							.stream()
							.sorted(new Comp())
							.toArray()[count.size() - 1];

					System.out.println("obj: " + a.getValue());
							

				case 4:
			}
			
		}

		sc.close();

	}

	static void linha(int[][] tab, int x, int r) {
		for(int i = 0; i < tab.length; i++) {
			tab[x-1][i] = r;
		}
	}

	static void coluna(int[][] tab, int x, int r) {
		for(int i = 0; i < tab.length; i++) {
			tab[i][x-1] = r;
		}
	}

}

class Comp implements Comparator<Map.Entry<Integer, Integer>> {

	@Override
	public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
		int qtd = Integer.compare(o1.getValue(), o2.getValue());
		if(qtd != 0) return qtd;
		
		int key = Integer.compare(o1.getKey(), o2.getKey());
		return key;

	}

	

}
//2 4

// 1 1 1

// 2 2 2

// 3 1

// 3 2
