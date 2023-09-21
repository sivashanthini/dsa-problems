package linkedlist.medium;

import java.util.HashMap;

public class LRUCache {
    HashMap<Integer, LinkedNode> map;
    int capacity;
    LinkedNode head = new LinkedNode(-1, -1);
    LinkedNode tail = new LinkedNode(-1, -1);

    public LRUCache(int capacity) {
        this.map = new HashMap<>(capacity);
        this.capacity = capacity;

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        LinkedNode getNode = map.get(key);
        int value = getNode.val;

        map.remove(key);
        deleteNode(getNode);

        addNode(getNode);
        map.put(key, head.next);
        return value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            LinkedNode getNode = map.get(key);
            map.remove(key);
            deleteNode(getNode);
        } if (map.size() == capacity) {
            map.remove(tail.prev.key);
            deleteNode(tail.prev);
        }

        addNode(new LinkedNode(key, value));
        map.put(key, head.next);
    }

    private void addNode(LinkedNode newNode) {
        LinkedNode temp = head.next;

        newNode.next = temp;
        newNode.prev = head;

        head.next = newNode;
        temp.prev = newNode;
    }

    private void deleteNode(LinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

class LinkedNode {
    int key;
    int val;
    LinkedNode prev;
    LinkedNode next;
    LinkedNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
