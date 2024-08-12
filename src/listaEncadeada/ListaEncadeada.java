package listaEncadeada;

public class ListaEncadeada<T> {

    private No<T> inicio;
    private No<T> ultimo;
    private int tamanho = 0;
    private final int NAO_ENCONTRADO = -1;

    public void adiciona(T algarismo) {
        No<T> celula = new No<>(algarismo);
        if (this.tamanho == 0) {
            this.inicio = celula;
        } else {
            this.ultimo.setProximo(celula);
        }
        this.ultimo = celula;
        this.tamanho++;
    }

    private No<T> buscaEncapsulado(int posicao) {
        if (this.posicaoNaoExiste(posicao)) {
            throw new IllegalArgumentException("NAO_EXISTE");
        }

        No<T> noAtual = this.inicio;
        for (int i = 0; i < posicao; i++) {
            noAtual = noAtual.getProximo();
        }

        return noAtual;
    }

    private boolean posicaoNaoExiste(int posicao) {
        return !(posicao >= 0 && posicao < this.tamanho);
    }

    public void adicionaInicio(T algarismo) {
        if (this.tamanho == 0) {
            No<T> novoNo = new No<>(algarismo);
            this.inicio = novoNo;
            this.ultimo = novoNo;
        } else {
            No<T> novoNo = new No<>(algarismo, this.inicio);
            this.inicio = novoNo;
        }
        this.tamanho++;
    }

    public void insertWithPosition(int posicao, T algarismo) {
        if (this.posicaoNaoExiste(posicao)) {
            throw new IllegalArgumentException("Posicao invalida");
        }
        if (posicao == 0) {
            this.adicionaInicio(algarismo);
        } else if (posicao == this.tamanho) {
            this.adiciona(algarismo);
        } else {
            No<T> noAnterior = this.buscaEncapsulado(posicao - 1);
            No<T> proximoNo = noAnterior.getProximo();
            No<T> novoNo = new No<>(algarismo, proximoNo);
            noAnterior.setProximo(novoNo);
            this.tamanho++;
        }
    }

    public T buscaIndex(int index) {
        return this.buscaEncapsulado(index).getAlgarismo();
    }

    public int busca(T algarismo) {
        int posicao = 0;
        No<T> nodeAtual = this.inicio;
        while (nodeAtual != null) {
            if (nodeAtual.getAlgarismo().equals(algarismo)) {
                return posicao;
            }
            posicao++;
            nodeAtual = nodeAtual.getProximo();
        }
        return NAO_ENCONTRADO;
    }

    public String printList() {
        if (this.tamanho == 0) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        No<T> atual = this.inicio;
        for (int i = 0; i < this.tamanho - 1; i++) {
            builder.append(atual.getAlgarismo()).append(",");
            atual = atual.getProximo();
        }
        builder.append(atual.getAlgarismo()).append("]");
        return builder.toString();
    }

    public void clearList() {
        this.inicio = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public T pop() {
        if (this.tamanho == 0) {
            throw new RuntimeException("LISTA_VAZIA");
        }
        if (this.tamanho == 1) {
            return this.removeInicio();
        }
        No<T> penultimoNo = this.buscaEncapsulado(this.tamanho - 2);
        T removido = penultimoNo.getProximo().getAlgarismo();
        penultimoNo.setProximo(null);
        this.ultimo = penultimoNo;
        this.tamanho--;
        return removido;
    }

    private T removeInicio() {
        if (this.tamanho == 0) {
            throw new RuntimeException("LISTA_VAZIA");
        }
        T removido = this.inicio.getAlgarismo();
        this.inicio = this.inicio.getProximo();
        this.tamanho--;

        if (this.tamanho == 0) {
            this.ultimo = null;
        }

        return removido;
    }

    public T remove(int posicao) {
        if (this.posicaoNaoExiste(posicao)) {
            throw new IllegalArgumentException("NAO_EXISTE");
        }

        if (posicao == 0) {
            return this.removeInicio();
        }
        if (posicao == this.tamanho - 1) {
            return this.pop();
        }
        No<T> noAnterior = this.buscaEncapsulado(posicao - 1);
        No<T> atual = noAnterior.getProximo();
        No<T> proximo = atual.getProximo();
        noAnterior.setProximo(proximo);
        this.tamanho--;
        return atual.getAlgarismo();
    }
}
