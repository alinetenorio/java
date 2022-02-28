package collections.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.plaf.metal.MetalScrollBarUI;

public class StreamExemplo {
  public static void main(String[] args) {
    List<String> listaMeses = new ArrayList<>(){{
      add("janeiro");
      add("fevereiro");
    }}; 
    System.out.println(listaMeses);

    Stream<String> stream = listaMeses.stream();

    //Com SAM
    stream.forEach( new Consumer<String>() {
      @Override
      public void accept(String t) {        
        System.out.println(t);
      }      
    });
    System.out.println();

    //Com Lambda
    listaMeses.stream().forEach( e -> System.out.println(e) );
    System.out.println();

    //Com Referência de método - Method Reference
    listaMeses.stream().forEach( System.out::println );
    System.out.println();
    String a = "25.6555";
    String b = String.format("%.2s", a);
    System.out.println(a);
    System.out.println(b);

    //5 primeiros números e colocar em Set
    Set<String> setMeses = listaMeses.stream()
      .limit(5)
      .collect(Collectors.toSet());

    System.out.println(setMeses);

    //Parse para Integer

    // listaMeses.stream()
    //   .map(new Function<String, Integer>() {

    //     @Override
    //     public Integer apply(String t) {         
    //       if( t.charAt(0) == 'j' ) return 0;
    //       else return 1;
    //     }
        
    //   })
    //   .forEach(System.out::println);

    List<Integer> mesesInt = listaMeses.stream()
      .map(t -> {
        if( t.charAt(0) == 'j' ) return 11;
          else return 6;
      })
      .collect(Collectors.toList());

    System.out.println(mesesInt);

    //Números pares maiores que 2
    System.out.println("Números pares maiores que 2");
    // mesesInt.stream()
    //   .filter(new Predicate<Integer>() {

    //     @Override
    //     public boolean test(Integer t) {          
    //       if( t > 2 && t % 2 == 0 )
    //         return true;
    //       return false;
    //     }
        
    //   })
    //   .forEach(System.out::println);

    mesesInt.stream()
      .filter(t -> t > 2 && t % 2 == 0)
      .forEach(System.out::println);

    //Média da lista
    mesesInt.stream()
      .mapToInt(Integer::intValue)
      .average()
      .ifPresent(System.out::println);

    //Remover os ímpares
    mesesInt.removeIf(e -> e % 2 != 0);
    System.out.println(mesesInt);
  }
}
