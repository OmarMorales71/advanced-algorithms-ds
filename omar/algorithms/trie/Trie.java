package omar.algorithms.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    TrieNode root;

    public Trie() {
        root=new TrieNode();
    }

    public void insert(String data){
        inserting(data,0,root);
    }

    private void inserting(String data,int position, TrieNode node){
        if(position>=data.length()){
            node.endOfWord=true;
            return;
        }
        char letter = data.charAt(position);
        TrieNode child=null;
        if(node.map.containsKey(letter)){
            child=node.map.get(letter);
        }else{
            child= new TrieNode();
            node.map.put(letter, child);
        }
        inserting(data, position+1, child);
    }

    public boolean search(String data){
        TrieNode current = root;
        for(int i = 0; i<data.length();i++){
            TrieNode node = current.map.get(data.charAt(i));
            if(node==null)
                return false;
            current=node;
        }

        if(current.endOfWord)
            return true;
        else
            return false;
    }

    public boolean delete(String data){
        return false;
    }

    private class TrieNode {
        Map<Character, TrieNode> map;
        boolean endOfWord;

        public TrieNode() {
            map = new HashMap<>();
            endOfWord = false;
        }
    }

}
