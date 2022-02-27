package collections.map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class HashMapExemplo {
  public static void main(String[] args) {
    //key deve ser único, valores podem ser duplicados
    Map<String, Integer> teste = new HashMap<>(){{
      put("T1", 1);
      put("T2", 2);
      put("T3", 3);
      put("T7", 7);
    }};

    System.out.println(teste);
    
    //Adicionar novo - chave única
    teste.put("T4", 4);

    //Se chave já existir, é uma edição
    teste.put("T1", 7);
    System.out.println(teste);
    
    System.out.println(teste.containsKey("T1"));
    System.out.println(teste.containsValue(8));

    System.out.println(teste.keySet());
    //.values() -> retorna collection
    // Erro:
    // List<Integer> ab = (List<Integer>) teste.values();
    Collection<Integer> a = teste.values();
    List<Integer> b = new ArrayList<>(a);
    System.out.println(a);
    System.out.println(b);

    //Imprimindo key com o maior value
    int max = Collections.max(a);
    //Set<Entry<String, Integer>> entries = teste.entrySet();

    for(Entry<String, Integer> entry : teste.entrySet()) {
      if(entry.getValue() == max) {
        System.out.println(entry.getKey());
      }
    }

    //Soma dos valores
    int soma = 0;
    for(Iterator<Integer> i = teste.values().iterator(); i.hasNext();) {
      soma += i.next();
    }
    System.out.println("soma: " + soma);

    teste.remove("T2");
    System.out.println(teste);

  }
}
