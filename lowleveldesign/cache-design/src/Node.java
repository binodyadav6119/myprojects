public class Node<K,V> {
    K key;
    V value;

    Node<K,V> next, prev;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
