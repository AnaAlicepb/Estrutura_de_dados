import java.util.LinkedLis
import java.util.LinkedList;

class Entry {
    int key;
    int value;

    Entry(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class HashMap {
    private final int SIZE = 10;
    private LinkedList<Entry>[] table;

    public HashMap() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        for (Entry entry : table[index]) {
            if (entry.key == key) {
                entry.value = value; // Atualiza o valor se a chave já existe
                return;
            }
        }
        table[index].add(new Entry(key, value));
    }

    public int get(int key) {
        int index = hash(key);
        for (Entry entry : table[index]) {
            if (entry.key == key) {
                return entry.value;
            }
        }
        return -1; // Indica que a chave não foi encontrada
    }

    public int delete(int key) {
        int index = hash(key);
        for (Entry entry : table[index]) {
            if (entry.key == key) {
                int value = entry.value;
                table[index].remove(entry);
                return value;
            }
        }
        return -1; // Indica que a chave não foi encontrada
    }

    public void clear() {
        for (int i = 0; i < SIZE; i++) {
            table[i].clear();
        }
    }

    public void printHashMap() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print("Bucket " + i + ": ");
            for (Entry entry : table[i]) {
                System.out.print("[" + entry.key + ", " + entry.value + "] -> ");
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put(1, 10);
        map.put(2, 20);
        map.put(11, 110); // Colisão com a chave 1
        map.put(12, 120); // Colisão com a chave 2
        map.printHashMap();

        System.out.println("Valor da chave 2: " + map.get(2));
        System.out.println("Valor removido da chave 11: " + map.delete(11));
        map.printHashMap();

        map.clear();
        System.out.println("Mapa após clear:");
        map.printHashMap();
    }
}
