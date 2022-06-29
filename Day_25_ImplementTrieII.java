class TrieNode{
    char data;
    boolean isTerminal;
    TrieNode[] children;
    int childcount;
    int[] freq;
    int occur;
    public TrieNode(char data){
        this.data = data;
        this.isTerminal = false;
        this.children = new TrieNode[26];
        this.childcount = 0;
        this.freq = new int[26];
        this.occur = 0;
    }
}
public class Trie {
    private TrieNode root;
    private int numwords;
    public Trie() {
        root = new TrieNode('\0');
        numwords = 0;
    }

    public void insert(String word) {
       if(addHelper(root,word))
           numwords++;
    }
    
    public boolean addHelper(TrieNode root, String word){
        if(word.length() == 0){
            root.occur++;
            if(root.isTerminal) return false;
            else{
                root.isTerminal = true;
                
                return true;
            }
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        root.freq[childIndex]++;
        
        if(child == null){
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.childcount++;
        }
        return addHelper(child, word.substring(1));
    }

    public int countWordsEqualTo(String word) {
        return countHelper(root,word);
    }
    
    public int countHelper(TrieNode root, String word){
        if(word.length() == 0){
              if(!root.isTerminal) return 0;
            return root.occur;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null) return 0;
        return countHelper(child, word.substring(1));
    } 
    public int countWordsStartingWith(String word) {
        return prefix(root, word);
    }
    
    public int prefix(TrieNode root, String word){
        if(word.length() == 0){
            return 0; 
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null) return 0;
        if(word.length() == 1) return root.freq[childIndex];
        return prefix(child, word.substring(1));
    }

    public void erase(String word) {
        if(eraseHelper(root,word)){
            numwords--;
        }
    }
    public boolean eraseHelper(TrieNode root, String word){
        if(word.length() == 0){
            if(root.isTerminal){
                root.isTerminal = false;
                root.occur--;
                return true;
            }
            else return false;
        }
        
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null) return false;
        boolean ans = eraseHelper(child, word.substring(1));
        if(ans == true){
           root.freq[childIndex]--;    
         }
       return ans;
    }
}
