public class LRUCache<K,V> extends BaseCache<K,V>{

    private final DoublyLinkedList<K, V> dll;

    public LRUCache(int capacity) {
        super(capacity);
        this.dll = new DoublyLinkedList<>();
    }

    @Override
    public void evictIfNeeded() {
        K lruKey = dll.removeTail();
        if (lruKey != null) {
            cache.remove(lruKey);
        }
    }

    @Override
    protected void addToHead(Node<K, V> node) {
        dll.addToHead(node);
    }

    @Override
    protected void moveToHead(Node<K, V> node) {
        dll.moveToHead(node);
    }

    @Override
    protected void removeNode(Node<K, V> node) {
        dll.removeNode(node);
    }

    public void display() {
        dll.printList();
    }
}
