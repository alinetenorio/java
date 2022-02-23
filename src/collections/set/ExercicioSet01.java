package collections.set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ExercicioSet01 {
  public static void main(String[] args) {
    Set<String> cores = new LinkedHashSet<>(){{
      add("vermelho");
      add("laranja");
      add("amarelo");
      add("verde");
      add("azul");
      add("roxo");
    }};

    //A
    System.out.println(cores);

    //B
    System.out.println(cores.size());

    //C
    Set<String> coresTree = new TreeSet<>(cores);
    System.out.println(coresTree);

    //D
    List<String> aux = new ArrayList<>(cores);
    Collections.reverse(aux);
    System.out.println(aux);

    //E
    for(String c : cores) {
      if(c.charAt(0) == 'v') {
        System.out.println(c);
      }
    }

    for( Iterator<String> it = cores.iterator(); it.hasNext();) {
      String cor = it.next();
      if(cor.charAt(0) != 'v') {
        it.remove();
      }      
    }
    System.out.println(cores);
    
    cores.clear();
    System.out.println(cores);
    System.out.println(cores.isEmpty());
  }
}
