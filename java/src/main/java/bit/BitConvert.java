package bit;

import java.util.Scanner;

public class BitConvert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int ret = 0;
        for(int i = 0; i < count; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int scale = 1;
            for(int bit = 0; bit < 32; bit++){
                int ptr = scale << bit;
                if((c & (scale<<bit)) !=  0){
                    if((a&ptr) == 0 && (b &ptr) == 0){
                        ret += 1;
                    }
                }else{
                    count += ((a&ptr) ==0? 0:1);
                    count += ((b&ptr) == 0? 0:1);
                }
            }
        }
    }
}
