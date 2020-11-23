package data;

class TrieNode {

    // R links to node children
    private TrieNode[] links;

    private final int R = 26;

    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch -'a'] != null;
    }
    public TrieNode get(char ch) {
        return links[ch -'a'];
    }
    public void put(char ch, TrieNode node) {
        links[ch -'a'] = node;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}

public class PrefixTree {
    private TrieNode root;
    public PrefixTree(){
        root = new TrieNode();
    }
    public void insert(String word){
        TrieNode node = root;
        for(int i = 0; i<word.length(); i++){
            char pos = word.charAt(i);
            if(!node.containsKey(pos)){
                node.put(pos, new TrieNode());
            }
            node = node.get(pos);
        }
        node.setEnd();
    }

    private TrieNode searchPrefix(String word){
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char pos = word.charAt(i);
            if(node.containsKey(pos)){
                node = node.get(pos);
            }else{
                return null;
            }
        }
        return node;
    }

    public boolean search(String word){
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }
    public boolean startswith(String prefix){
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}
