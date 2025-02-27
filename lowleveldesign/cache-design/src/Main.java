public class Main {
    public static void main(String[] args) {

        Cache<Integer, String> cache = CacheManager.getInstance(3).getCache();

        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        ((LRUCache<Integer, String>) cache).display(); // 3 -> 2 -> 1 -> NULL

        cache.get(1); // Move 1 to MRU
        ((LRUCache<Integer, String>) cache).display(); // 1 -> 3 -> 2 -> NULL

        cache.put(4, "D"); // Evicts 2 (LRU)
        ((LRUCache<Integer, String>) cache).display(); // 4 -> 1 -> 3 -> NULL


        System.out.println("Hello world!");
    }
}