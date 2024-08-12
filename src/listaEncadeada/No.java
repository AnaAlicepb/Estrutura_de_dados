package listaEncadeada;

public class No<T> {

    private T algarismo;
    private No<T> proximo;

    public No(T algarismo, No<T> proximo) {
        this.algarismo = algarismo;
        this.proximo = proximo;
    }

    public No(T algarismo) {
        this.algarismo = algarismo;
        this.proximo = null;
    }

    public T getAlgarismo() {
        return algarismo;
    }

    public void setAlgarismo(T algarismo) {
        this.algarismo = algarismo;
    }

    public No<T> getProximo() {
        return proximo;
    }

    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return "No [algarismo=" + algarismo + ", proximo=" + proximo + "]";
    }
}
