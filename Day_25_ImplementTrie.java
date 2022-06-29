class TrieNode{
    char data;
    boolean isTerminal;
    TrieNode[] children;
    int childcount;
    public TrieNode(char data){
        this.data = data;
        this.isTerminal = false;
        this.children = new TrieNode[26];
        this.childcount = 0;
    }
}
public class Trie {

     static TrieNode root;
     static int numwords;
    Trie() {
        root = new TrieNode('\0');
        numwords = 0;
    }


    //Inserts a word into the trie

    public static void insert(String word) {
        if(addHelper(root,word)){
            numwords++;
        }
    }
    
    public static boolean addHelper(TrieNode root, String word){
        if(word.length() == 0){
            if(root.isTerminal) return false;
            else{
                root.isTerminal = true;
                return true;
            }
        }
        int childIndex = word.charAt(0) -'a';
        TrieNode child = root.children[childIndex];
        if(child == null){
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.childcount++;
        }
        return addHelper(child,word.substring(1));
    }


    //Returns if the word is in the trie

    public static boolean search(String word) {
        return searchHelper(root,word);
    }
    
    public static boolean searchHelper(TrieNode root, String word){
        if(word.length() == 0) return root.isTerminal;
        
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        
        if(child == null) return false;
        
        return searchHelper(child, word.substring(1));
    }

    
    //Returns if there is any word in the trie that starts with the given prefix

    public static boolean startsWith(String prefix) {
      return prefix(root, prefix);
    }
    public static boolean prefix(TrieNode root, String word){
        if(word.length() == 0){
          if(root.isTerminal) return true;
           if(root.childcount == 0) return false;
          return true;
            
        }
        
        int childIndex = word.charAt(0)-'a';
        TrieNode child = root.children[childIndex];
        if(child == null) return false;
        
        return prefix(child, word.substring(1));
    }   
}