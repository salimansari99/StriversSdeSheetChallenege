import java.util.*;
class Node{
    Node[] links = new Node[2];
    boolean flag = false;
    public Node(){};
    
    boolean containsKey(int ind){
        return (links[ind] != null);
    }
    
    void put(int ind,Node node){
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
        int max = 0;
        for(int i = 31; i >= 0; i--){
            int bit = (num>>i)&1;
            if(node.containsKey(1-bit)){
                max = max | (1<<i);
                node = node.get(1-bit);
            }
            else node = node.get(bit);
        }
        return max;
    }
}
public class Solution {
    public static ArrayList<Integer> maxXorQueries(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> queries) {
        Collections.sort(arr);
        ArrayList<ArrayList<Integer>> q = new ArrayList<>();
        
        int m = queries.size();
        for(int i = 0; i < m; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(queries.get(i).get(0)); // xi
            temp.add(queries.get(i).get(1)); //ai
            temp.add(i);
            q.add(temp);
        }
        Collections.sort(q,new Comparator<ArrayList<Integer>>(){
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b){
                return a.get(1).compareTo(b.get(1));
            }
        });
        
        int ind = 0;
        int n = arr.size();
        Trie trie = new Trie();
        ArrayList<Integer> res = new ArrayList<>(m);
        
        for(int i = 0; i < m; i++) res.add(-1);
        
        for(int i = 0; i < m; i++){
            while(ind<n && arr.get(ind) <= q.get(i).get(1)){
                trie.insert(arr.get(ind));
                ind++;
            }
            int qInd = q.get(i).get(2);
            if(ind!=0) res.set(qInd, trie.getMax(q.get(i).get(0)));
            else res.set(qInd,-1);
        }
        return res;
        
    }
}