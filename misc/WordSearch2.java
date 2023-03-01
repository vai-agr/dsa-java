package misc;
//PASSED

import java.util.*;

class TrieNode{
    TrieNode[] children;
    boolean isEndOfWord, addedToList;
    TrieNode(){
        children = new TrieNode[26];
        isEndOfWord = false;
        addedToList = false;
    } 
}

class Trie {
    TrieNode root;
    
    Trie(){
        root = new TrieNode();
    }

   TrieNode root(){
        return this.root;
    }

    void addWord(String word){
        TrieNode cur = this.root;
        for (char letter : word.toCharArray()) {
            int index = letter - 'a';
            if(cur.children[index]==null){
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.isEndOfWord = true;
    }

    
    
}

class Solution {
    
    private void dfs(char[][] board, int i, int j, TrieNode cur, StringBuilder str, List<String> ans, boolean[][] visited){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || visited[i][j])
            return;
        
        int ch = board[i][j] - 'a';
        if(cur.children[ch]==null) return;
        cur = cur.children[ch];
        str.append(board[i][j]) ;
        if(cur.isEndOfWord && !cur.addedToList){
            ans.add(str.toString());
            cur.addedToList = true;
        } 
        visited[i][j] = true;
        System.out.println(str);
        dfs(board,i+1,j,cur,str,ans,visited);
        dfs(board,i-1,j,cur,str,ans,visited);
        dfs(board,i,j+1,cur,str,ans,visited);
        dfs(board,i,j-1,cur,str,ans,visited);
        visited[i][j] = false;

        str.deleteCharAt(str.length()-1);
    }
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        TrieNode root = trie.root();
        List<String> ans = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for (String word : words) {
            trie.addWord(word);
        }
        
        for(int i =0; i<m; i++){
            for(int j=0; j<n; j++){
                
                dfs(board,i,j,root,str,ans,visited);
            }
        }
        return ans;

    }
}