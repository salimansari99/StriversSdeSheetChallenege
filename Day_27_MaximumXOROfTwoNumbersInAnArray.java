class Node{
                // size of node array is 2 because we store 0 / 1
    Node[] links = new Node[2];
    boolean flag = false;
    public Node(){};
    
    boolean containsKey(int ind){
        return (links[ind] != null);
    }
    
    void put(int ind, Node node){
        links[ind] = node;
    }
    Node get(int ind){
        return links[ind];
    }
}
class Trie{
    private Node root;
    public Trie(){
        root = new Node();
    }
    
    public void insert(int num){
        Node node = root;
        for(int i = 31; i >= 0; i--){
            int bit = (num>>i)&1;
            if(!node.containsKey(bit)){
                node.put(bit,new Node());
            }
            node = node.get(bit);
        }
    } 
    
    public int getMax(int num){
        Node node = root;
        int maxSum = 0;
        for(int i = 31; i >= 0; i--){
            int bit = (num>>i)&1;
            if(node.containsKey(1-bit)){
                maxSum = maxSum | (1<<i);
                node = node.get(1-bit);
            }
           else node = node.get(bit);
        }
        return maxSum;
    }
}
public class Solution {

    public static int maximumXor(int[] A) {
        
        Trie trie = new Trie();
        for(int i = 0; i < A.length; i++){
            trie.insert(A[i]);
        }
        
        int max = 0;
        for(int i = 0; i < A.length; i++){
            max = Math.max(max,trie.getMax(A[i]));
        }
        return max;
    }
}