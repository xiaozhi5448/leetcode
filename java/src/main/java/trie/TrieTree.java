package trie;

public class TrieTree {
    TrieNode root;
    public TrieTree(){
        root = new TrieNode();
    }
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word.equals(""))
            return;
        TrieNode nodePtr = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(nodePtr.children[ch-'a'] == null)
                nodePtr.children[ch-'a'] = new TrieNode();
            nodePtr = nodePtr.children[ch-'a'];
        }
        nodePtr.word = word;
    }

    private TrieNode pathExists(String word){
        TrieNode nodePtr = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(nodePtr.children[ch-'a'] == null)
                return null;
            nodePtr = nodePtr.children[ch-'a'];
        }
        return nodePtr;
    }
    /** Returns if the word is in the trie. */
    public boolean search(String word) {

        if("".equals(word))
            return true;
        TrieNode nodePtr = pathExists(word);
        return nodePtr != null && nodePtr.word != null;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if("".equals(prefix))
            return true;
        TrieNode nodePtr = pathExists(prefix);
        return nodePtr!= null;
    }
}
