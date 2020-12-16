package data;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordPattern_290Test {

    @Test
    public void wordPattern() {
        WordPattern_290 obj = new WordPattern_290();
        boolean res = obj.wordPattern("abba", "dog cat cat dog");
        System.out.println(res);
    }
}