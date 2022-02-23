package collections.set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExemplo {
  public static void main(String[] args) {
    //Funciona: Double tem um comparable
    Set<Double> notas = new TreeSet<>(){{
      add(7.4);
      add(5.4);
      add(102.4);
      add(3.4);
      add(3.4);
    }};

    // //Erro: Classe Teste não tem comparable
    // Set<Teste> testes = new TreeSet<>(){{
    //   add(new Teste(7.4));
    //   add(new Teste(5.4));
    //   add(new Teste(102.4));
    //   add(new Teste(3.4));
    //   add(new Teste(3.4));
    // }};

    //O TreeSet é impresso em ordem crescente:
    System.out.println(notas);
    notas.remove(102.4);
    System.out.println(notas);

    notas.clear();
    System.out.println(notas.isEmpty());
    System.out.println(notas);

    Set<Serie> series = new TreeSet<>(){{
      add(new Serie("Alagoinha", "Boa viagem", 52));
      add(new Serie("Alagoinha", "Barco", 2));
      add(new Serie("Abobora", "Banana", 3));
    }};
    
    System.out.println(series);
    System.out.println("\n\n");
    
    Set<Serie> series2 = new TreeSet<>(new ComparatorNomeGenero());
    series2.addAll(series);
    System.out.println(series2);
    
  }
}

class Teste {
  double a;
  public Teste(double a) {
    this.a = a;
  }
}

class ComparatorNomeGenero implements Comparator<Serie> {

  @Override
  public int compare(Serie s1, Serie s2) {
    int nomeComparacao = s1.nome.compareTo(s2.nome);
    if( nomeComparacao != 0 ) return nomeComparacao;
    
    int generoComparacao = s1.genero.compareTo(s2.genero);
    if( generoComparacao != 0 ) return generoComparacao;

    return 0;
  }
  
}