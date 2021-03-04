package bit;

import java.util.LinkedList;
import java.util.List;

public class AddUtil_17 {
    public int add(int a, int b) {
        StringBuilder bits = new StringBuilder();
        int current = 0, current1 = 0;
        int carrier = 0, carrier1 = 0;
        int bita = 0;
        int bitb = 0;
        for(int i = 0; i<32; i++){
            bita = (a >> i) & 1;
            bitb = b >>i & 1;
            current1 = bita ^ bitb;
            carrier1 = bita & bitb;
            current = current1 ^ carrier;
            carrier = carrier1 | (current1 & carrier);
            if(current == 1){
                bits.insert(0,'1');
            }else{
                bits.insert(0, '0');
            }
        }
        String bin = bits.toString();

        return Integer.parseInt(bin, 2);
    }
}
