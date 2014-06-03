package leetcode;

import java.util.HashMap;

public class LRUCache {  
   	HashMap<Integer, MapNode> map;
    int capacity;
    
    MapNode head, tail;// doubly linked list
    
    public LRUCache(int capacity) {
    	this.capacity = capacity;
    	map = new HashMap<Integer, MapNode>(capacity);
    	head = null;
    	tail = null;
    }

    public void addNode(MapNode newNode) {
    	if (head == null) { // it's empty
    		newNode.setPrev(null);
    		newNode.setNext(null);
    		head = newNode;
    		tail = head;
    	} else {
    		newNode.setPrev(tail);
    		newNode.setNext(null);
    		tail.setNext(newNode);
    		tail = newNode;
    	}
    }
    
    public void moveNode(MapNode newNode) {
    	if (newNode == tail) {
    		return;
    	} else {
	    	if (newNode == head) {
	    		head = newNode.next;
	    		head.setPrev(null);
	    	} else {
	    		newNode.prev.setNext(newNode.next);
	    		newNode.next.setPrev(newNode.prev);
	    	}
	    	newNode.setPrev(tail);
			newNode.setNext(null);
			tail.setNext(newNode);
			tail = newNode;
    	}
    }
    
    public void removeLRUNode() {
    	if (head == tail) {
    		head = null;
    		tail = null;
    		return;
    	}
    	if (head != null) {
    		head = head.next;
    		head.prev.setNext(null);
    		head.setPrev(null);
    	}
    }
    
    public int get(int key) {
    	if (map.containsKey(key)) {
    		MapNode node = map.get(key);
    		moveNode(node);
    		return node.getValue();
    	}
        return -1;
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)) {
        	MapNode node = map.get(key);
        	node.setValue(value);
        	map.put(key, node);
        	moveNode(node);
        } else {
        	if (map.size() >= capacity) {
        		map.remove(head.getKey());
        		removeLRUNode();
        	} 
        	MapNode newNode = new MapNode(key, value);
        	map.put(key, newNode);
    		addNode(newNode);
        }
    }
    
    public static void main(String args[]) {
    	LRUCache cache = new LRUCache(1);
    	cache.set(2, 1);
    	System.out.println(cache.get(2));
    	cache.set(3, 2);
    	System.out.println(cache.get(2));
    	System.out.println(cache.get(3));
    }
    
    private class MapNode {
    	int key, val;
    	MapNode prev, next;
    	
    	MapNode(int k, int v) {
    		key = k;
    		val = v;
    		prev = null;
    		next = null;
    	}
    	
    	int getKey() {
    		return this.key;
    	}
    	
    	int getValue() {
    		return this.val;
    	}
    	
    	void setValue(int v) {
    		this.val = v;
    	}
    	
    	void setNext(MapNode next) {
    		this.next = next;
    	}
    	
    	void setPrev(MapNode prev) {
    		this.prev = prev;
    	}
    }
   
}