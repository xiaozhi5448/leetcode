package trie;

import java.util.List;

/**
 * 在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。
 * 例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 *
 * 现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。
 * 如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 *
 * 你需要输出替换之后的句子。
 *  输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * 输出："the cat was rat by the bat"
 */
public class ReplaceWords_648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode trie = new TrieNode();
        for(String root: dictionary){
            TrieNode cur = trie;
            for (char ch: root.toCharArray()){
                if(cur.children[ch-'a'] == null){
                    cur.children[ch-'a'] = new TrieNode();
                }
                cur = cur.children[ch-'a'];
            }
            cur.word = root;
        }
        StringBuilder sb = new StringBuilder();
        for (String word: sentence.split("\\s+")){
            if (sb.length() != 0){
                sb.append(" ");
            }
            TrieNode trieNode = trie;
            for (char ch: word.toCharArray()){
                if(trieNode.children[ch-'a'] == null || trieNode.word != null){
                    break;
                }
                trieNode = trieNode.children[ch-'a'];
            }
            sb.append(trieNode.word != null? trieNode.word: word);
        }
        return sb.toString();
    }
}
