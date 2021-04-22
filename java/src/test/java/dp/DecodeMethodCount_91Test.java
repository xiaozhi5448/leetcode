package dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class DecodeMethodCount_91Test {

    @Test
    public void numDecodings() {
        DecodeMethodCount_91 util = new DecodeMethodCount_91();
        Map<String, Integer> tests = new HashMap<>();
        tests.put("12", 2);
        tests.put("226", 3);
        tests.put("0", 0);
        tests.put("06", 0);
        tests.put("10011", 0);
        for(String key: tests.keySet()){
            long res = util.numDecodings(key);
            Assert.assertEquals((long)tests.get(key), res);
            System.out.printf("%s: %d\n", key, res);
        }
    }
}