package omar.algorithms.trie;

public class TrieMain {
    public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("air");
    trie.insert("aio");
    trie.insert("omar");
        System.out.println(trie.search("air"));
        System.out.println(trie.search("airline"));
        System.out.println(trie.search("a"));
        System.out.println(trie.search("omar"));
        System.out.println(trie.search("aio"));
    }
}
