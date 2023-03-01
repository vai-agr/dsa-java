package ds;

class TrieNode{
    TrieNode[] children;
    boolean isEndOfWord;
    TrieNode(){
        children = new TrieNode[26];
        isEndOfWord = false;
    } 
}
public class Trie {
    TrieNode root;
    
    public Trie(){
        root = new TrieNode();
    }

    public TrieNode root(){
        return this.root;
    }

    public void addWord(String word){
        TrieNode cur = this.root;
        for (char letter : word.toCharArray()) {
            int index = letter - 'a';
            if(cur.children[index]==null){
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.isEndOfWord = false;
    }

    public boolean containsWord(String word){
        TrieNode cur = this.root;
        for (char letter : word.toCharArray()) {
            int index = letter - 'a';
            if(cur.children[index]==null){
                return false;
            }
            cur = cur.children[index];
        }
        return cur.isEndOfWord;
    }
}
