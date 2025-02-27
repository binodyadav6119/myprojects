import java.util.HashMap;
import java.util.Map;

public abstract class BaseCache<K,V>  implements Cache<K,V> {

    protected final int capacity;
    protected final Map<K, Node<K, V>> cache;

    public BaseCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
    }

    public abstract void evictIfNeeded(); // To be implemented by eviction strategy

    @Override
    public void put(K key, V value) {
        if (cache.containsKey(key)) {
            Node<K, V> node = cache.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            if (cache.size() >= capacity) {
                evictIfNeeded();
            }
            Node<K, V> newNode = new Node<>(key, value);
            addToHead(newNode);
            cache.put(key, newNode);
        }
    }

    @Override
    public V get(K key) {
        if (!cache.containsKey(key)) return null;
        Node<K, V> node = cache.get(key);
        moveToHead(node);
        return node.value;
    }

    @Override
    public void remove(K key) {
        if (!cache.containsKey(key)) return;
        Node<K, V> node = cache.remove(key);
        removeNode(node);
    }

    @Override
    public int size() {
        return cache.size();
    }

    protected abstract void addToHead(Node<K, V> node);

    protected abstract void moveToHead(Node<K, V> node);

    protected abstract void removeNode(Node<K, V> node);
}
