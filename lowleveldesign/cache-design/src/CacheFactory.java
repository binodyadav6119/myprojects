public class CacheFactory {
    public static <K, V> Cache<K, V> createLRUCache(int capacity) {
        return new LRUCache<>(capacity);
    }
}
