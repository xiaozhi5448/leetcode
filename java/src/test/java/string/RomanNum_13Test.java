package string;

import org.junit.Test;

import static org.junit.Assert.*;

public class RomanNum_13Test {

    @Test
    public void romanToInt() {
        RomanNum_13 obj = new RomanNum_13();
        String[] tests = {"III", "IV", "IX", "LVIII", "MCMXCIV"};
        for(String str:tests){
            System.out.printf("%s: %d\n", str, obj.romanToInt2(str));
        }
    }
}