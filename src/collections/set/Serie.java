package collections.set;

public class Serie implements Comparable<Serie> {
  //Ao usar implementações que usem Hash, é preciso
  //sobreescrever o equals() e o hash()

  String nome;
  String genero;
  Integer tempoEpisodio;

  public Serie(String n, String g, Integer t) {
    this.nome = n;
    this.genero = g;
    this.tempoEpisodio = t;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((genero == null) ? 0 : genero.hashCode());
    result = prime * result + ((nome == null) ? 0 : nome.hashCode());
    result = prime * result + ((tempoEpisodio == null) ? 0 : tempoEpisodio.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Serie other = (Serie) obj;
    if (genero == null) {
      if (other.genero != null)
        return false;
    } else if (!genero.equals(other.genero))
      return false;
    if (nome == null) {
      if (other.nome != null)
        return false;
    } else if (!nome.equals(other.nome))
      return false;
    if (tempoEpisodio == null) {
      if (other.tempoEpisodio != null)
        return false;
    } else if (!tempoEpisodio.equals(other.tempoEpisodio))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Serie [genero=" + genero + ", nome=" + nome + ", tempoEpisodio=" + tempoEpisodio + "]\n";
  }

  @Override
  public int compareTo(Serie o) {    
    
    return Integer.compare(this.tempoEpisodio, o.tempoEpisodio);
  }
  
}
