package stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class EvalExpression_224Test {

    @Test
    public void calculate() {
        EvalExpression_224 util = new EvalExpression_224();
        int res = util.calculate("1-5 - (3-6) + 10");
        System.out.println(res);
    }
}