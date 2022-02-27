package collections.stream;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;
import java.util.function.Function;

import collections.set.Serie;

public class Funcional {
  public static void main(String[] args) {
    Map<Integer, Serie> series = new HashMap<>(){{
      put(1, new Serie("Alagoinha", "Boa viagem", 52));
      put(2, new Serie("Alagoinha", "Barco", 5));
      put(3, new Serie("Abobora", "Banana", 3));
    }};

    System.out.println(series);

    //===Classe anônima
    Set<Map.Entry<Integer, Serie>> seriesTree = new TreeSet<>(new Comparator<Entry<Integer, Serie>>() {
      @Override
      public int compare(Map.Entry<Integer, Serie> o1, Entry<Integer, Serie> o2) {        
        return Integer.compare(o1.getValue().tempoEpisodio, o2.getValue().tempoEpisodio);
      }
    });
    seriesTree.addAll(series.entrySet());
    System.out.println(seriesTree);

    //===Interface funcional
    Set<Map.Entry<Integer, Serie>> seriesTreeFunc = new TreeSet<>(Comparator.comparing( 
      new Function<Map.Entry<Integer, Serie>, Integer>() {
        @Override
        public Integer apply(Entry<Integer, Serie> t) {         
          return t.getValue().tempoEpisodio;
        }
      }
    ));
    seriesTreeFunc.addAll(series.entrySet());
    System.out.println(seriesTreeFunc);

    //===Lambda
    Set<Map.Entry<Integer, Serie>> seriesTreeLambda = new TreeSet<>(Comparator.comparing(
      e -> e.getValue().tempoEpisodio
    ));
    seriesTreeLambda.addAll(series.entrySet());
    System.out.println(seriesTreeLambda);
  }
}
