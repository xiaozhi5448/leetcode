package stack;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class EvalExpression_227Test {

    EvalExpression_227 util = new EvalExpression_227();



    @Test
    public void testParseItem(){
        String exp = "3 * 5 / (2 + 2) - 5 ^ 2";
        String[] items = util.parseItem(exp);
        System.out.println(Arrays.toString(items));
        LinkedList<String> suffix = util.inToSuffix(items);
        System.out.println(suffix);
        System.out.println(util.calculate(exp));
        Pattern pattern = Pattern.compile("(?=\\d+)|(?<=\\d)|(?=[\\+\\-\\*/\\^\\(\\)])|(?<=[\\+\\-\\*/\\^\\(\\)])" );
        System.out.println(Arrays.toString(pattern.split(exp)));
        System.out.println(exp.replaceAll("\\s+", ""));
    }
}