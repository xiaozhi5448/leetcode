package recursion;

import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

public class KthGrammar_779Test extends TestCase {

    public void testKthGrammar() {
        KthGrammar_779 obj = new KthGrammar_779();
        HashMap<Integer, Integer> tests = new HashMap<>();

        tests.put(1,1);
        tests.put(2,2);
        tests.put(2,1);
        tests.put(4,5);
        tests.put(30, 90000);
        for(Map.Entry<Integer, Integer> entry: tests.entrySet()){
            int res = obj.kthGrammar(entry.getKey(), entry.getValue());
            System.out.printf("%d,%d: %d\n", entry.getKey(), entry.getValue(), res);
        }

    }
}