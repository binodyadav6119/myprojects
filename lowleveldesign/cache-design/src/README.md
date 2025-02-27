Design Pattern Usage Summary
✅ Strategy Pattern → BaseCache<K, V> allows different eviction policies (LRU, LFU, etc.).
✅ Factory Pattern → CacheFactory creates different cache instances.
✅ Singleton Pattern → CacheManager ensures only one cache instance is used.
✅ Template Method Pattern → BaseCache<K, V> defines the caching logic, while subclasses implement eviction rules.

Why This Approach?
🚀 Scalable → Easily extend to other policies like LFU.
🔥 Reusable → The BaseCache ensures reusable logic.
🔒 Thread-Safe Singleton → Ensures a single instance in multi-threaded environments.

This is now a design-pattern optimized, scalable, and maintainable in-memory LRU Cache!

Main Logic of In-Memory LRU Cache Using Doubly Linked List & HashMap
The Least Recently Used (LRU) Cache is a data structure that stores key-value pairs with a fixed capacity. When the cache is full, the least recently used item is evicted.

Core Data Structures Used
HashMap (cache)
Purpose: Provides O(1) lookup for keys.
Key: Stores the key of the cache entry.
Value: Stores a reference to a Node (from Doubly Linked List).
Doubly Linked List (dll)
Purpose: Maintains the order of cache usage, with the most recently used (MRU) at the head and least recently used (LRU) at the tail.
Nodes: Store key-value pairs and links to previous and next nodes.
Operations:
Move to Head: When a key is accessed, move it to the head.
Remove Tail: When cache is full, remove the least recently used node (tail).
Insert at Head: Insert a new node at the head when a new key is added.
Key Operations & Their Logic
1. get(K key): Retrieve a Value
   If the key is in the cache (HashMap):
   Fetch the corresponding node.
   Move it to the head (as it's now the most recently used).
   Return the value.
   If the key is not found, return null.
   Time Complexity: O(1) (HashMap lookup + DLL operations)

2. put(K key, V value): Insert a Key-Value Pair
   If the key is already in the cache:
   Update its value.
   Move it to the head.
   If the key is not in the cache:
   If the cache is full, remove the tail node (LRU item) and delete it from the HashMap.
   Insert the new key-value pair at the head of the DLL.
   Add it to the HashMap.
   Time Complexity: O(1) (HashMap insert/update + DLL operations)

3. evictIfNeeded(): Remove LRU Entry
   If the cache reaches its capacity, remove the tail node.
   Delete the key from HashMap.
   Time Complexity: O(1) (Removing from tail + HashMap delete)

