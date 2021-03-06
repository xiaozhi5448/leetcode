package trie;

import java.util.LinkedList;
import java.util.List;

/**
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 *
 * 实现词典类 WordDictionary ：
 *
 *     WordDictionary() 初始化词典对象
 *     void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 *     bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；
 *     否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 *
 */
class WordDictionary {

    /** Initialize your data structure here. */
    TrieNode root = new TrieNode();
    public WordDictionary() {

    }

    private void addWord(TrieNode node, String word, int index){
        if(node == null)
            return;
        if(index == word.length()){
            node.word = word;
            return;
        }

        if(node.children[word.charAt(index)-'a'] ==null ){
            node.children[word.charAt(index)-'a'] = new TrieNode();
        }
        addWord(node.children[word.charAt(index)-'a'], word, index+1);
    }
    public void addWord(String word) {
        addWord(root, word, 0);
    }

    private boolean search(TrieNode node, String word, int index){
        if(node == null)
            return false;
        if(index == word.length()){
            if(node.word != null){
                return true;
            }else{
                return false;
            }
        }
        if(word.charAt(index) != '.'){
            return search(node.children[word.charAt(index) - 'a'], word



                    , index+1);
        }else{
            List<Boolean> res = new LinkedList<>();
            for(int i = 0; i < 26; i++){
                if(node.children[i] != null){
                    res.add(search(node.children[i], word, index+1));
                }
            }
            return res.stream().anyMatch((item)-> item);
        }
    }

    public boolean search(String word) {
        return search(root, word, 0);
    }
}
