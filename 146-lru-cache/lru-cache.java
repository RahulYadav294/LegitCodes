class LRUCache {

    int capacity;
    HashMap<Integer, Node> map = new HashMap<>();

    Node head;
    Node tail;

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    // Remove a node from the list
    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Add node just before tail (MRU position)
    public void addNode(Node node) {
        Node prev = tail.prev;

        node.prev = prev;
        node.next = tail;

        prev.next = node;
        tail.prev = node;
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        // It was just used, so make it MRU
        removeNode(node);
        addNode(node);

        return node.value;
    }

    public void put(int key, int value) {

        // Key already exists
        if (map.containsKey(key)) {

            Node node = map.get(key);

            node.value = value;

            // Make it MRU
            removeNode(node);
            addNode(node);

            return;
        }

        // Create new node
        Node node = new Node(key, value);

        map.put(key, node);
        addNode(node);

        // Capacity exceeded
        if (map.size() > capacity) {

            Node lru = head.next;

            removeNode(lru);
            map.remove(lru.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */