package padroes_projeto.decorator;

public abstract class DecoradorArvore implements IArvore{
  private IArvore arvore;
    
  public DecoradorArvore(IArvore arvore) {
    this.arvore = arvore;
  }

  @Override
  public String decorar() {
      return arvore.decorar();
  }
}
