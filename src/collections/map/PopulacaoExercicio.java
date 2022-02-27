package collections.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

public class PopulacaoExercicio {
  public static void main(String[] args) {
    Map<String, Integer> populacao = new LinkedHashMap<>(){{
      put("PE", 1);
      put("AL", 2);
      put("CE", 3);
      put("RN", 4);
    }};
  
    //Atualizar população do RN
    populacao.put("RN", 36);

    //Conferir se PB está no dicionário, caso não, adicionar
    if( !populacao.containsKey("PB") ) {
      populacao.put("PB", 10);
    }

    //Exiba a população de PE
    System.out.println(populacao.get("PE"));

    //Exibir estados e população na ordem que foram inseridos
    System.out.println(populacao);
    
    //Exibir estados e população em ordem alfabética
    Map<String, Integer> populacaoTree = new TreeMap<>(populacao);
    System.out.println(populacaoTree);

    //Estado com a menor população
    //int min = Collections.min(populacao.values());
    int min = -1, max = 0;
    String estadoMenor = "", estadoMaior = "";
    for( Iterator<String> i = populacao.keySet().iterator(); i.hasNext(); ) {
      String key = i.next();
      if(min == -1 || populacao.get(key).compareTo(min) < 0) {
        min = populacao.get(key);
        estadoMenor = key;
      }
      if(populacao.get(key).compareTo(max) > 0) {
        max = populacao.get(key);
        estadoMaior = key;
      }
    }
    System.out.println(estadoMenor + "  " + min);
    System.out.println(estadoMaior + "  " + max);
    
    int soma = 0;
    for(Iterator<String> i = populacao.keySet().iterator(); i.hasNext(); ) {
      soma += populacao.get(i.next());
    }
    System.out.println(soma);
    System.out.println(soma/populacao.size());
    
    for(Iterator<String> i = populacao.keySet().iterator(); i.hasNext(); ) {
      String n = i.next();
      if(populacao.get(n) < 4) {
        i.remove();
      }
    }
    System.out.println(populacao);
    populacao.clear();
    System.out.println(populacao.isEmpty());
  }
}
