package collections.map;

import java.util.HashMap;
import java.util.Map;

public class DadoExercicio {
  public static void main(String[] args) {
    Map<Integer, Integer> resultados = new HashMap<>();

    int[] dado = new int[6];
    int n;
    for(int i=0; i<100;i++){
      n = (int)(Math.random()*6);
      resultados.put(n, ++dado[n]);
    }

    System.out.println(resultados);
  }
}
