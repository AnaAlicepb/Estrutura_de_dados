package programaTestes;

import fifo.Fifo;
import fifo.FifoLinear;
import listaEncadeada.ListaEncadeada;
import pilha.Pilha;

public class Program {

    public static void main(String[] args) {
        System.out.println("----------Testes Lista encadeada----------------");

        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.adiciona(1); // 0
        lista.adiciona(2); // 1
        lista.adiciona(3); // 2
        lista.adiciona(4); // 3

        lista.insertWithPosition(2, 10);
        System.out.println(lista.printList());
        System.out.println(lista.busca(10));
        System.out.println(lista.busca(4));
        lista.pop();
        System.out.println(lista.printList());
        lista.remove(2);
        System.out.println(lista.printList());
    }
}
