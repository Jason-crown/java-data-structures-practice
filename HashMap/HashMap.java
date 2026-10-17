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

    public void put(int key, int value) {
        int index = getBucketIndex(key);
        HashMapNode newNode = new HashMapNode(key, value);
        if (buckets[index] == null) {
            buckets[index] = newNode;
        } else {
            HashMapNode current = buckets[index];
            while (current != null) {
                if (current.key == key) {
                    current.value = value; // Update existing key
                    return;
                }
                if (current.next == null) {
                    current.next = newNode; // Add new node at the end
                    return;
                }
                current = current.next;
            }
        }
    }

    public Integer get(int key) {
        int index = getBucketIndex(key);
        HashMapNode current = buckets[index];
        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }
        return null; // Key not found
    }

    public void remove(int key) {
        int index = getBucketIndex(key);
        HashMapNode current = buckets[index];
        HashMapNode prev = null;

        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    buckets[index] = current.next; // Remove head
                } else {
                    prev.next = current.next; // Bypass the node to remove it
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

}
