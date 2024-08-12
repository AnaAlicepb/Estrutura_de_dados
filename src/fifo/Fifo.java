package fifo;

public class Fifo {

	private int[] fifo;
	private int front;
	private int rear;
	private int size; 
	private int capacity; 

	public Fifo(int capacity) {
		this.capacity = capacity;
		this.fifo = new int[capacity];
		this.front = 0; 
		this.rear = -1;
		this.size = 0;

	}
	
	public int positionRear() {
		return this.rear;
	}
	
	public int positionFront() {
		return this.front;
	}
	
	public int size() {
		return this.size;
	}

	public boolean isFull() {
		return this.size == this.capacity;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public int front() {
		if (isEmpty()) {
			throw new IllegalStateException("Lista vazia. \n");

		} else {
			return this.fifo[front];
		}
	}
	
	public int rear() {
		if (isEmpty()) {
			throw new IllegalStateException("Lista vazia. \n");

		} else {
			return this.fifo[rear];
		}
		
	}
	
	public void enqueue(int numero) {
	    if(isFull()) {
	        throw new IllegalStateException("Lista cheia...");
	    } else {
	        rear = (rear + 1) % capacity; 
	        fifo[rear] = numero;
	        size++;
	    }
	}
	
	public int dequeue() {
	    if(isEmpty()) {
	        throw new IllegalStateException("A fila está vazia");
	    }
	    int numRetirado = fifo[front];
	    front = (front + 1) % capacity; 
	    size--;
	    return numRetirado;
	}
	
	public void imprimirTodaFila() {
	    if (isEmpty()) {
	        System.out.println("A fila está vazia.");
	    }
	    
	    int index = front;
	    for (int i = 0; i < size; i++) {
	        System.out.println(fifo[index]);
	        index = (index + 1) % capacity;
	    }
	}
}

