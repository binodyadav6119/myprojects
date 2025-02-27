public class CacheManager {

    private static CacheManager instance;
    private final Cache<Integer, String> cache;

    private CacheManager(int capacity) {
        this.cache = CacheFactory.createLRUCache(capacity);
    }

    public static CacheManager getInstance(int capacity) {
        if (instance == null) {
            synchronized (CacheManager.class) {
                if (instance == null) {
                    instance = new CacheManager(capacity);
                }
            }
        }
        return instance;
    }

    public Cache<Integer, String> getCache() {
        return cache;
    }
}
