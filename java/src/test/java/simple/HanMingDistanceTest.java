package simple;

import junit.framework.TestCase;
import org.junit.Test;

public class HanMingDistanceTest extends TestCase {
    private String next(String s){
        int left = 0, right = left;
        char ch = s.charAt(left);
        StringBuilder sb = new StringBuilder();
        while(right < s.length()){
            while(right < s.length() && s.charAt(right) == s.charAt(left)){
                right++;
            }
            sb.append(right-left);
            sb.append(s.charAt(left));
            left = right;
        }
        return sb.toString();
    }
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }else{
            int time = 1;
            String res = "1";
            while(time++ < n){
                res = next(res);
            }
            return res;
        }
    }

    @Test
    public void test(){
        int x = 4, y = 1;
        HanMingDistance hanMingDistance = new HanMingDistance();
        System.out.println(hanMingDistance.hammingDistance(x, y));
        System.out.println(countAndSay(5));
    }

}