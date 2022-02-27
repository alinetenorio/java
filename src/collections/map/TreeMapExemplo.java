package collections.map;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExemplo {
  public static void main(String[] args) {
    //Insere chaves em ordem
    Map<String, Integer> teste = new TreeMap<>(){{
      put("T99", 1);
      put("T1", 1);
      put("T2", 2);
      put("T3", 3);
    }};

    System.out.println(teste);
    teste.clear();
    System.out.println(teste.isEmpty());
  }
}
