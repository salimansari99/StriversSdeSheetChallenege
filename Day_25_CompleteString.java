class Node{
    Node links[];
    boolean flag = false;
    public Node(){
        this.links = new Node[26];
    }
    boolean containsKey(char ch){
        return (links[ch - 'a'] != null);
    }
    Node get(char ch){
        return links[ch-'a'];
    }
    void put(char ch, Node node){
        links[ch-'a'] = node;
    }
    void setEnd(){
        flag = true;
    }
    boolean isEnd(){
        return flag;
    }
}

class Trie{
    private static Node root;
    public Trie(){
        root = new Node();
    }
    public void insert(String word){
        Node node = root;
        for(int i = 0; i < word.length(); i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i),new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }
    
    boolean checkIfPrefixExist(String word){
        Node node = root;
        boolean flag = true;
        for(int i = 0; i < word.length(); i++){
            if(node.containsKey(word.charAt(i))){
                node  = node.get(word.charAt(i));
                flag = flag && node.isEnd();
            }
            else return false;
        }
        return flag;
    }
}
class Solution {

  public static String completeString(int n, String[] a) {
    Trie trie = new Trie();
      for(int i = 0; i < n; i++){
          trie.insert(a[i]);
      }
      String longest = "";
      for(int i = 0; i < n; i++){
          if(trie.checkIfPrefixExist(a[i])){
              if(a[i].length() > longest.length()){
                  longest = a[i];
              }
              else if(a[i].length() == longest.length() && a[i].compareTo(longest) < 0){
                  longest = a[i];
              }
          }
      }
     if(longest == "") return "None";
      return longest;
  }
}