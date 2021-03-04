package string;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumToRoman_12Test {

    @Test
    public void intToRoman() {
        NumToRoman_12 obj = new NumToRoman_12();
        int[] tests = new int[]{3, 4, 9, 58, 1994};
        for(Integer num:tests){
            System.out.printf("%d: %s\n", num, obj.intToRoman2(num));
        }
    }
}