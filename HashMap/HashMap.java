package Java.HashMap;

class HashMapNode {
    int key;
    int value;
    HashMapNode next;

    HashMapNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

public class HashMap {
    private HashMapNode[] buckets;
    private int capacity;

    public HashMap(int capacity) {
        this.capacity = capacity;
        this.buckets = new HashMapNode[capacity];
    }

    private int getBucketIndex(int key) {
        return key % capacity;
    }


}
