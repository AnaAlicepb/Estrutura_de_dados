package fifo;

public class FifoLinear {

	private int[] fila;
	private int primeiro;
	private int ultimo;
	private int tamanho;
	private int capacidade;

	public FifoLinear(int capacidade) {
		this.capacidade = capacidade;
		this.fila = new int[capacidade];
		this.primeiro = 0;
		this.ultimo = -1;
		this.tamanho = 0;
	}

	public int tamanho() {
		return this.tamanho;
	}

	public boolean isFull() {
		return this.tamanho == this.capacidade;
	}

	public boolean isEmpty() {
		return this.tamanho == 0;
	}

	public int primeiro() {
		if (isEmpty()) {
			throw new IllegalStateException("Fila vazia.");
		}
		return this.fila[primeiro];
	}

	public int ultimo() {
		if (isEmpty()) {
			throw new IllegalStateException("Fila vazia.");
		}
		return this.fila[ultimo];
	}

	public int getUltimo() {
		return this.ultimo;
	}
	public int getPrimeiro() {
		return this.primeiro;
	}
	
	 public void enqueue(int numero) {
	        if(isFull()) {
	            throw new IllegalStateException("Fila cheia.");
	        } else {
	            ultimo++;
	            fila[ultimo] = numero;
	            tamanho++;
	        }
	    }
	 
	 public int dequeue() {
		  if(isEmpty()) {
	            throw new IllegalStateException("Fila vazia.");
	        }
		  int numRetirado = fila[primeiro];
		  primeiro++;
		  tamanho--;
		  return numRetirado;
	 }
	 
	 public void imprimirTodaFila() {
	        if(isEmpty()) {
	            System.out.println("Fila vazia.");
	            return;
	        }
	        for(int i = primeiro; i <= ultimo; i++) {
	            System.out.println(fila[i]);
	        }
	    }
	
	

}
