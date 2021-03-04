package stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateStack_946Test {

    @Test
    public void validateStackSequences() {
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,2,1};
        ValidateStack_946 validateStack_946 = new ValidateStack_946();
        boolean res = validateStack_946.validateStackSequences(pushed, popped);
        System.out.println(res);
    }
}