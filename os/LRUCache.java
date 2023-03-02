package os;

import java.util.*;
//doubly linked list
class Node{
    
    int key, value;
    Node prev, next;

    public Node(int k, int v){
        key = k; value = v;
    }
}

class LRUCache {
    Node head, tail;
    Map<Integer, Node> cache;
    int capacity, size;

    private void update(int key){
        Node curNode = cache.get(key);
        Node prevNode = curNode.prev, nextNode = curNode.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        create(key, curNode);
    }

    private void create(int key, Node node){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        size = 0;    

        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next  = tail;    tail.prev = head;
    }

    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        int value = cache.get(key).value;
        update(key);
        return value;
        
    }
    
    public void put(int key, int value) {
        if(capacity<=0) return;
        if(cache.containsKey(key)){
            cache.get(key).value = value;
            update(key);
        }

        else if(size<capacity){
            Node node = new Node(key, value);
            cache.put(key, node);
            create(key, node);
            size++;

        }
        else{
            int deleteKey = tail.prev.key;
            tail.prev = tail.prev.prev;
            tail.prev.next = tail;
            cache.remove(deleteKey);

            Node node = new Node(key, value);
            cache.put(key, node);
            create(key, node);
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */