package collections.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

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
  }
}
