package stack;

import junit.framework.TestCase;
import org.junit.Assert;

public class ValidatePairTest extends TestCase {
    public void testPair(){
        ValidatePair validatePair = new ValidatePair();
        boolean valid = validatePair.isValid("([])");
        Assert.assertTrue(valid);
    }

}