package collections.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExemplo {
  public static void main(String[] args) {
    //Salva a ordem em que os elementos foram inseridos
    Map<String, Integer> teste = new LinkedHashMap<>(){{
      put("T1", 1);
      put("T2", 2);
      put("T3", 3);
      put("T4", 4);
    }};

    System.out.println(teste);
  }
}
