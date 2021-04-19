package trie;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrieTreeTest {

    @Test
    public void insert() {
        TrieTree trie = new TrieTree();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}