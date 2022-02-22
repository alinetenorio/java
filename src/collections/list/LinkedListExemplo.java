package collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExemplo {
  public static void main(String[] args) {
    System.out.println("Crie uma lista chamada notas2 " +
                  "e coloque todos os elementos da list Arraylist nessa nova lista: ");
          System.out.println("Mostre a primeira nota da nova lista sem removê-la: ");
          System.out.println("Mostre a primeira nota da nova lista removendo-a: ");
  
    List<Float> notas1 = new ArrayList<>(Arrays.asList(5f, 9f, 8f, 7.5f));
    LinkedList<Float> notas2 = new LinkedList<>(notas1);
    
    System.out.println("notas2: " + notas2);
    System.out.println("Primeira nota sem remover: " + notas2.peek());
    System.out.println("Primeira nota sem remover: " + notas2.peekFirst());
    System.out.println("Primeira nota removendo: " + notas2.removeFirst());
    System.out.println("notas2: " + notas2);
    System.out.println("Primeira nota removendo: " + notas2.pop());
    System.out.println("notas2: " + notas2);
    
  }
}
