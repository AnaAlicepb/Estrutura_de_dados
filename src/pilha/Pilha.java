package pilha;

public class Pilha {

    private Object[] pilha;
    private int posicao;

    public Pilha(int pilhaLenght) {
        this.posicao = -1;
        pilha = new Object[pilhaLenght];
    }

    public boolean isPilhaEmpty() {
        return this.posicao == -1;
    }

    public int size() {
        if (this.isPilhaEmpty()) {
            return 0;
        } else {
            return this.posicao + 1;
        }
    }

    public void push(int valor) {
        if (this.posicao < this.pilha.length - 1) {
            this.pilha[++this.posicao] = valor;
        } else {
            throw new StackOverflowError("Pilha cheia");
        }
    }

    public Object pop() {
        if (this.isPilhaEmpty()) {
            throw new RuntimeException("Pilha vazia");
        }
        return this.pilha[this.posicao--];
    }

    public Object top() {
        if (this.isPilhaEmpty()) {
            throw new RuntimeException("Pilha vazia");
        } else {
            return this.pilha[this.posicao];
        }
    }
}
