import java.util.*;
public class LFUCache {

    final int capacity;
    int cursize;
    int minfreq;
    HashMap<Integer,Node> map = new HashMap<>();
    HashMap<Integer,DoublyLinkedList> freqMap = new HashMap<>();
    
	LFUCache(int capacity) {
		this.capacity = capacity;
        this.cursize = 0;
        this.minfreq = 0;
	}

	int get(int key) {
		if(map.containsKey(key)){
            updateNode(map.get(key)); // update
            return map.get(key).value;
        }
        else return -1;
	}

	void put(int key, int value) {
		if(capacity == 0) return;
        
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            updateNode(node);
        }
        else{
            cursize++;
            if(cursize > capacity){
                DoublyLinkedList list = freqMap.get(minfreq);
                map.remove(list.tail.prev.key);
                list.remove(list.tail.prev);
                cursize--;
            }
            minfreq = 1;
            Node node = new Node(key, value);
            
            DoublyLinkedList list = freqMap.getOrDefault(1,new DoublyLinkedList());
            list.add(node);
            freqMap.put(1,list);
            map.put(key,node);   
         }
       }
    
    public void updateNode(Node node){
        int freq = node.freq;
        DoublyLinkedList list = freqMap.get(freq);
        list.remove(node);
        
        if(freq == minfreq && list.listsize == 0){
            minfreq++;
        }
        
        node.freq++;
        DoublyLinkedList newlist = freqMap.getOrDefault(node.freq, new DoublyLinkedList());
        newlist.add(node);
        freqMap.put(node.freq, newlist);
    }
}
class Node{
    int key, value;
    int freq;
    Node next, prev;
    public Node(int key, int value){
        this.key = key;
        this.value = value;
        this.freq = 1;
    }
}
class DoublyLinkedList{
    int listsize;
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    public DoublyLinkedList(){
        this.head.next = tail;
        this.tail.prev = head;
        this.listsize = 0;
    }
    
    public void add(Node node){
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
        listsize++;
    }
    
    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        listsize--;
    }
}
