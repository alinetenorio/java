package collections.list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

import javax.sound.sampled.SourceDataLine;

public class ArrayListExemplo {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void inicializar() {
    
    //** Sem generics
    // List lista = new ArrayList();
    // lista.add("teste");
    // lista.add(1);
    // System.out.println(lista.get(0).getClass().getSimpleName());
    // System.out.println(lista.get(1).getClass().getSimpleName());

    // List<String> lista = new ArrayList();
    // lista.add("teste");
    // lista.add(1);

    // List lista = new ArrayList<String>();
    // List<String> listaString = lista;
    // lista.add("teste");
    // lista.add(1);
    // listaString.add("teste 2");
    // //Erro: listaString.add(2);
    // System.out.println(lista.get(0).getClass().getSimpleName());
    // System.out.println(lista.get(1).getClass().getSimpleName());

    //** Com generics
    // List<String> lista = new ArrayList<String>();
    // lista.add("teste");
    // //Erro: lista.add(1);
    
    // ** Com generics e diamond operator (usa inferência de tipo)
    List<String> lista = new ArrayList<>();
    lista.add("teste");

    //** Usando a implementação (é uma boa prática usar a especificação)
    // ArrayList<String> lista = new ArrayList<>();
    // lista.add("teste");

    //** Povoando na declaração */
    // List<String> lista = Arrays.asList("teste 1", "teste 2");
    // //Erro: lista.add("teste 3");
    // System.out.println(lista);

    // List<String> lista = new ArrayList<>(Arrays.asList("teste 1", "teste 2"));
    // lista.add("teste 3");

    //** Povoando na declaração, lista imutável */
    // List<String> lista = List.of("teste 1", "teste 2");
    // //Erro: lista.add("teste 3");
    // System.out.println(lista);

    List<String> listaMeses = new ArrayList<>(){{
      add("janeiro");
      add("fevereiro");
    }}; 
    System.out.println(listaMeses);
  }

  public static void operacoes() {
    List<String> lista = new ArrayList<>();
    //Adicionando no final da lista
    lista.add("t1");
    lista.add("t2");
    lista.add("t3");

    List<Double> listaDouble = new ArrayList<>();
    //Adicionando no final da lista
    listaDouble.add(7d);
    listaDouble.add(2.0);
    listaDouble.add(3.5);

    // //Posição de um elemnto
    // System.out.println(lista.indexOf("t2"));

    // //Adicionando em index específico
    // lista.add(2, "t2.1");
    // System.out.println(lista);

    // //Substituindo elemento
    // System.out.println(lista.get(2));
    // lista.set(2, "t2.2");
    // System.out.println(lista.get(2));

    // //Verificar se contém elemento na lista
    // System.out.println(lista.contains("t5"));
    // System.out.println(lista.contains("t1"));

    //Maior elemento da lista
    System.out.println(Collections.max(lista));
    System.out.println(Collections.max(listaDouble));

    //Menor elemento da lista
    System.out.println(Collections.min(lista));
    System.out.println(Collections.min(listaDouble));

    //Iterator
    Iterator<String> iterator = lista.iterator();
    while( iterator.hasNext() ) {
      System.out.println("Iterator while: " + iterator.next());
    }
    for(Iterator<String> i = lista.iterator(); i.hasNext();) {
      System.out.println("Iterator for: " + i.next());
    }

    /*Erro: ao usar for-each, não podemos modificar a collection
    for(String s : lista){
      lista.remove(s);
    } 
    */

    for(Iterator<String> it = lista.iterator(); it.hasNext();) {
      if(it.next().equals("t2"))
        it.remove();
    }

    lista.clear();
  
    // IntStream is = IntStream.range(0, lista.size());
    // for(int i: is.toArray()) {
    //   lista.remove(lista.get(0));
    // }

    // int t = lista.size();
    // for(int i=0; i<t;i++){
    //   lista.remove(lista.get(0));
    // }

    System.out.println(lista);
  }

  public static void exercicioComparable() {
  List<Aluno> alunos = new ArrayList<>() {{
    add(new Aluno("joao", 30));
    add(new Aluno("maria", 20));
    add(new Aluno("ze", 40));
  }};
  
  System.out.println("\nAlunos com ordenação original:");
  System.out.println(alunos);

  //Ordem aleatória
  System.out.println("\nAlunos com ordenação aleatória:");
  Collections.shuffle(alunos);
  System.out.println(alunos);

  //Por idade
  System.out.println("\nAlunos com ordenação por idade:");
  Collections.sort(alunos);
  System.out.println(alunos);
}

  public static void exercicioComparator() {
  List<Aluno> alunos = new ArrayList<>() {{
    add(new Aluno("ze", 40));
    add(new Aluno("joao", 30));
    add(new Aluno("maria", 20));
  }};
  
  System.out.println("\nAlunos com ordenação original:");
  System.out.println(alunos);

  //Por nome
  System.out.println("\nAlunos com ordenação por nome:");
  Collections.sort(alunos, new ComparatorAluno());
  // alunos.sort(new ComparatorAluno());
  System.out.println(alunos);
}
  
  public static void exercicioTemperatura() throws IOException {
    List<Float> temp = new ArrayList<>();
    String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho"};

    for(int i = 0; i < 6; i++) {
      temp.add(Float.parseFloat(br.readLine()));
    }

    float media = 0;
    for( Float t : temp ) {
      media += t;
    }
    media /= temp.size();
    System.out.println("Média: " + media);

    int mes;
    for( Float t : temp ) {
      if( t > media ) {
        mes = temp.indexOf(t);
        System.out.println( t + " - " + meses[mes]);
      }
    }
  }
  
  public static void exercicioCrime() throws IOException {
    List<Boolean> respostas = new LinkedList<>();

    System.out.println("Responda com s ou n");
    System.out.println("Telefonou?");
    respostas.add(br.readLine().equals("s") ? true : false);
    System.out.println("Local?");
    respostas.add(br.readLine().equals("s") ? true : false);
    System.out.println("Mora?");
    respostas.add(br.readLine().equals("s") ? true : false);
    System.out.println("Devia?");
    respostas.add(br.readLine().equals("s") ? true : false);
    System.out.println("Trabalhou?");
    respostas.add(br.readLine().equals("s") ? true : false);

    int count = 0;
    for( Boolean res : respostas ) {
      if( res ) count++; 
    }

    if( count < 2 ) System.out.println("Inocente");
    if( count == 2 ) System.out.println("Suspeita");
    if( count >= 3 && count <= 4 ) System.out.println("Cúmplice");
    if( count == 5 ) System.out.println("Assassina");
  }
  public static void main(String[] args) throws IOException {
    // inicializar();
    // operacoes();
    // exercicioComparable();
    // exercicioComparator();
    // exercicioTemperatura();
    exercicioCrime();
  }

}

class Aluno implements Comparable<Aluno> {

  private String nome;
  private int idade;

  public Aluno(String nome, int idade) {
    this.nome = nome;
    this.idade = idade;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getIdade() {
    return idade;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  @Override
  public String toString() {
    return "Aluno [nome=" + nome + ", idade=" + idade + "]";
  }

  @Override
  public int compareTo(Aluno aluno) {
    // return ((Integer) this.getIdade()).compareTo((Integer)aluno.getIdade());
    return Integer.compare(this.getIdade(), aluno.getIdade());
  }  
  
}

class ComparatorAluno implements Comparator<Aluno> {

  @Override
  public int compare(Aluno a1, Aluno a2) {
    // TODO Auto-generated method stub
    return a1.getNome().compareTo(a2.getNome());
  }
  
}