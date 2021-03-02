package hashtable;

import java.security.KeyStore;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 字谜的迷面 puzzle 按字符串形式给出，如果一个单词 word 符合下面两个条件，那么它就可以算作谜底：
 *
 * 单词 word 中包含谜面 puzzle 的第一个字母。
 * 单词 word 中的每一个字母都可以在谜面 puzzle 中找到。
 * 例如，如果字谜的谜面是 "abcdefg"，那么可以作为谜底的单词有 "faced", "cabbage", 和 "baggage"；
 * 而 "beefed"（不含字母 "a"）以及 "based"（其中的 "s" 没有出现在谜面中）。
 * 返回一个答案数组 answer，数组中的每个元素 answer[i] 是在给出的单词列表 words 中可以作为字谜迷面 puzzles[i] 
 * 所对应的谜底的单词数目。
 *
 */
public class Puzzle_1178 {

    private HashMap<String, char[]> getMap(String[] words){
        HashMap<String ,char[]> wordsDict = new HashMap<>();
        for(String word:words){
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            wordsDict.put(word, arr);
        }
        return wordsDict;
    }

    private boolean checkContain(char[] puzzle, char[] word){
        int index1=0,index2=0;
        for(int index = 0; index < word.length;index++){
            while( index1 < puzzle.length && word[index] != puzzle[index1]){
                index1++;
            }
            if(index1 == puzzle.length){
                return false;
            }
        }
        return true;
    }

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        HashMap<String, char[]> puzzlesDict = getMap(puzzles);
        HashMap<String, char[]> wordsDict = getMap(words);
        int count = 0;
        List<Integer> res = new LinkedList<>();
        for(String puzzle: puzzles){
            count = 0;
            for(String word: words){
                if(word.contains(puzzle.substring(0,1))){
                    if(checkContain(puzzlesDict.get(puzzle), wordsDict.get(word))){
                        count+=1;
                    }
                }
            }
            res.add(count);
        }
        return res;
    }
}
