package collections.set;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetExemplo {
  public static void main(String[] args) {
    //LinkedHashSet: salva a ordem de inserção dos elementos
    Set<Double> notas = new LinkedHashSet<>(){{
      add(5.4);
      add(7.4);
      add(102.4);
      add(3.4);
    }};

    System.out.println(notas);
    System.out.println(notas.contains(7.4));
    notas.remove(102.4);
    System.out.println(notas);
    
  }
}
