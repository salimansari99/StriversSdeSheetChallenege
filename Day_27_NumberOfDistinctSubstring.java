class Node{
    Node[] links = new Node[26];
    boolean flag = false;
    
    public Node(){}
    
    boolean containsKey(char ch){
        return (links[ch-'a'] != null);
    }
    
    void put(char ch, Node node){
        links[ch-'a'] = node;
    }
    
    Node get(char ch){
        return links[ch-'a'];
    }
    
    void setEnd(){
        flag = true;
    }
    
    boolean isEnd(){
        return flag;
    }
}
    

public class Solution {
    public static int distinctSubstring(String word) {
        Node root = new Node();
        
        int cnt = 0;
        int n = word.length();
        for(int i = 0; i < n; i++){
            Node node = root;
            for(int j = i; j < n; j++){
                char ch = word.charAt(j);
                if(!node.containsKey(ch)){
                     node.put(ch, new Node());
                    cnt++;
                }
                node  = node.get(ch);
            }
            node.setEnd();
        }
        return cnt;
    }
}
