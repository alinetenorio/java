package padroes_projeto.decorator;

public class Main {
  public static void main(String[] args) {
    IArvore arvore = new Globo(new Arvore());
    System.out.println(arvore.decorar());

    IArvore arvore2 = new Estrela(new Globo(new Arvore()));
    System.out.println(arvore2.decorar());
  }
  
}
