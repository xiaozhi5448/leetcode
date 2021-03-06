package dfs;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GenerateBrackets_22Test {

    @Test
    public void generateParenthesis() {
        GenerateBrackets_22 util = new GenerateBrackets_22();
        List<String> res =  util.generateParenthesis(3);
        System.out.println(res.toString());
    }
}