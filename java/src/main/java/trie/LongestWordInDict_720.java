package trie;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。
 * 若其中有多个可行的答案，则返回答案中字典序最小的单词。
 *
 * 若无答案，则返回空字符串。
 *
 */
public class LongestWordInDict_720 {
    private boolean addWord(char[] arr, TrieNode node, int index){
        if(index == arr.length){
            if(node.word == null){
                node.word = new String(arr);
                return true;
            }
            return false;
        }
        if(node.children[arr[index]-'a'] == null){
            node.children[arr[index]-'a'] = new TrieNode();
        }
        return addWord(arr, node.children[arr[index]-'a'], index+1);
    }

    private void dfs(List<String> strs, TrieNode node){
        if(node.word != null){
            boolean hasChild = false;
            for(int i = 0; i< 26; i++){
                if(node.children[i] != null){
                    if(node.children[i].word != null){
                        hasChild = true;
                        dfs(strs, node.children[i]);
                    }
                }
            }
            if(!hasChild){
                strs.add(node.word);
            }
        }
    }

    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        for(String word: words){
            if(word.length() >0)
            addWord(word.toCharArray(), root, 0);
        }
        List<String> strs = new LinkedList<>();
        for(int i = 0; i< 26; i++){
            if(root.children[i] != null){
                dfs(strs, root.children[i]);
            }
        }
        strs.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() != o2.length()){
                    return o2.length() - o1.length();
                }else{
                    return o2.compareTo(o1);
                }
            }
        });
        if(strs.size() >0)
            return strs.get(0);
        else{
            return "";
        }
    }
}
