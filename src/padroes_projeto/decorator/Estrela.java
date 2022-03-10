package padroes_projeto.decorator;

public class Estrela extends DecoradorArvore{
  public Estrela(IArvore arvore) {
    super(arvore);
  }

  public String decorar() {
      return super.decorar() + decorarComGlobo();
  }

  private String decorarComGlobo() {
      return " com estrela";
  }  
}
