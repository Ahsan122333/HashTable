import java.util.ArrayList;
import java.util.List;

class Node<K, V> {
    K key;
    V value;

    Node<K, V> next;

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setNext(Node<K, V> next) {
        this.next = next;
    }
}

class Hashtables<K, V> {
    private int size;
    private List<Node<String, String>> data;

    public Hashtables(int size) {
        this.size = size;
        data = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            data.add(null);
        }
    }

    public int hashcode(String key) {
        int sum = 0;
        for (char c : key.toCharArray()) {
            sum += (int) c;
        }
        return sum % this.size;
    }

    public void insert(String key, String value) {
        int index = hashcode(key);
        Node<String, String> newNode = new Node<>();
        newNode.setValue(value);
        newNode.setNext(null);
        newNode.setKey(key);
        if (data.get(index) == null) {
            data.set(index, newNode);
            System.out.println("added " + value);
        } else {
            Node<String, String> newNode1 = data.get(index);
            if (newNode1.next != null) {
                while (newNode1.next != null) {
                    newNode1 = newNode1.next;
                }
            }
            newNode1.next = newNode;
            System.out.println("added " + value);
        }
    }

    public void delete(String key) {
        int index = hashcode(key);
        Node<String, String> current = data.get(index);
        Node<String, String> previous = null;

        while (current != null && !current.key.equals(key)) {
            previous = current;
            current = current.next;
        }

        if (current != null) {
            if (previous == null) {
                data.set(index, current.next); // Remove the first node
            } else {
                previous.next = current.next; // Skip the current node
            }
        }
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print("Index " + i + ": ");
            Node<String, String> current = data.get(i);
            while (current != null) {
                System.out.print("(" + current.key + ", " + current.value + ")");
                current = current.next;
            }
            System.out.print("\n");
        }
        System.out.print("\n\n");
    }
}