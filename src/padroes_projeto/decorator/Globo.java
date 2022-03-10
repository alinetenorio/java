package padroes_projeto.decorator;

public class Globo extends DecoradorArvore{
    public Globo(IArvore arvore) {
        super(arvore);
    }

    public String decorar() {
        return super.decorar() + decorarComGlobo();
    }

    private String decorarComGlobo() {
        return " com globos";
    }
}
