public class DoublyLinkedList <K,V>{

    private Node<K, V> head, tail;

    public DoublyLinkedList() {
        head = new Node<>(null, null);
        tail = new Node<>(null, null);
        head.next = tail;
        tail.prev = head;
    }

    public void addToHead(Node<K, V> node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public void moveToHead(Node<K, V> node) {
        removeNode(node);
        addToHead(node);
    }

    public K removeTail() {
        if (tail.prev == head) return null;
        Node<K, V> lruNode = tail.prev;
        removeNode(lruNode);
        return lruNode.key;
    }

    public void removeNode(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void printList() {
        Node<K, V> temp = head.next;
        while (temp != tail) {
            System.out.print(temp.key + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

}
