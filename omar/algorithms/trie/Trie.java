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
        if(search(data)){
            return delete(root, data, 0);
        }
        return false;
    }
    private boolean delete(TrieNode root, String data, int position) {
        // CASE#1 -- Some other word's prefix is same as Prefix of this word (BCDE, BCKG)
        // CASE#2 -- We are at last character of this word and This word is a Prefix of some other word (BCDE, BCDEFG)
        // CASE#3 -- Some other word is a Prefix of this word (BCDE, BC)
        // CASE#4 -- No one is dependent on this Word (BCDE, BCDE)

        char ch = data.charAt(position);
        TrieNode current = root.map.get(ch);

        boolean canThisNodeBeDeleted;

        if (current.map.size() > 1) {
            delete(current, data, position + 1); // CASE#1
            return false;
        }

        if (position == data.length() - 1) { // CASE#2
            if (current.map.size() >= 1) {
                current.endOfWord = false;//updating endOfWord will signify that this word is not there in Trie
                return false;
            } else {
                root.map.remove(ch);
                return true;// If this word is not a prefix of some other word, and since this is last
                // character, we should
                // return true, indicating we are ok to delete this node
            }
        }

        if (current.endOfWord == true) { // CASE#3
            delete(current, data, position + 1);
            return false;
        }

        canThisNodeBeDeleted = delete(current, data, position + 1); // CASE#4
        if (canThisNodeBeDeleted == true) {
            root.map.remove(ch);
            return true; // Current node can also be deleted
        } else {
            return false; // Someone is dependent on this node, hence dont delete it
        }

    }

    /*private boolean delete(TrieNode root, String data, int position) {
        // CASE#1 -- Some other word's prefix is same as Prefix of this word (BCDE, BCKG)
        // CASE#2 -- We are at last character of this word and This word is a Prefix of some other word (BCDE, BCDEFG)
        // CASE#3 -- Some other word is a Prefix of this word (BCDE, BC)
        // CASE#4 -- No one is dependent on this Word (BCDE, BCDE)

        char ch = data.charAt(position);
        TrieNode current = root.map.get(ch);

        boolean canThisNodeBeDeleted;

        if (current.map.size() > 1) {
            delete(current, data, position + 1); // CASE#1
            return false;
        }

        if (position == data.length() - 1) { // CASE#2
            if (current.map.size() >= 1) {
                current.endOfWord = false;//updating endOfWord will signify that this word is not there in Trie
                return false;
            } else {
                root.map.remove(ch);
                return true;// If this word is not a prefix of some other word, and since this is last
                // character, we should
                // return true, indicating we are ok to delete this node
            }
        }

        if (current.endOfWord == true) { // CASE#3
            delete(current, data, position + 1);
            return false;
        }

        canThisNodeBeDeleted = delete(current, data, position + 1); // CASE#4
        if (canThisNodeBeDeleted == true) {
            root.map.remove(ch);
            return true; // Current node can also be deleted
        } else {
            return false; // Someone is dependent on this node, hence dont delete it
        }

    }*/

    private class TrieNode {
        Map<Character, TrieNode> map;
        boolean endOfWord;

        public TrieNode() {
            map = new HashMap<>();
            endOfWord = false;
        }
    }

}
