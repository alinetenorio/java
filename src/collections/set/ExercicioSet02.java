package collections.set;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class ExercicioSet02 {
  public static void main(String[] args) {
    Set<LinguagemFavorita> lang = new LinkedHashSet<>(){{
      add(new LinguagemFavorita("php", 7789, "vscode"));
      add(new LinguagemFavorita("java", 1234, "intellij"));
      add(new LinguagemFavorita("java", 7789, "spyder"));
    }};
    
    //A
    System.out.println(lang);
    System.out.println("\n\n");
    
    //B    
    Set<LinguagemFavorita> lang2 = new TreeSet<>(lang);
    System.out.println(lang2);

    //C
    Set<LinguagemFavorita> lang3 = new TreeSet<>(new ComparatorIde());
    lang3.addAll(lang);
    System.out.println(lang3);

    //D
    Set<LinguagemFavorita> lang4 = new TreeSet<>(new ComparatorAnoNome());
    lang4.addAll(lang);
    System.out.println(lang4);

  }
}

class LinguagemFavorita implements Comparable<LinguagemFavorita>{
  String nome;
  int ano;
  String ide;

  public LinguagemFavorita( String n, int a, String i ) {
    this.nome = n;
    this.ano = a;
    this.ide = i;
  }

  @Override
  public String toString() {
    return "LinguagemFavorita [ano=" + ano + ", ide=" + ide + ", nome=" + nome + "]\n";
  }

  @Override
  public int compareTo(LinguagemFavorita o) {
    return this.nome.compareTo(o.nome);
  }

}

class ComparatorIde implements Comparator<LinguagemFavorita> {

  @Override
  public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
    return o1.ide.compareTo(o2.ide);
  }

}

class ComparatorAnoNome implements Comparator<LinguagemFavorita> {

  @Override
  public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
    int ano = Integer.compare(o1.ano, o2.ano);
    if( ano != 0 ) return ano;

    int nome = o1.nome.compareTo(o2.nome);
    if( nome != 0 ) return nome;

    return 0;
  }

class ComparatorNomeAnoIde implements Comparator<LinguagemFavorita> {

  @Override
  public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
    int nome = o1.nome.compareTo(o2.nome);
    if( nome != 0 ) return nome;

    int ano = Integer.compare(o1.ano, o2.ano);
    if( ano != 0 ) return ano;

    int ide = o1.ide.compareTo(o2.ide);
    if( ide != 0 ) return ide;

    return 0;
  }
}

}