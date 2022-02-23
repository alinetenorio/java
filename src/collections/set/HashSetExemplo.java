package collections.set;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class HashSetExemplo {
  public static void main(String[] args) {
    Set<Double> notas = new HashSet<>(){{
      add(5.4);
      add(7.4);
      add(102.4);
      add(3.4);
    }};
    
    System.out.println(notas);
    System.out.println(notas.contains(7.4));
    System.out.println(Collections.min(notas));
    System.out.println(Collections.max(notas));
    notas.remove(102.4);
    System.out.println(notas);

  }
}

