package bit;

/**
 * 二进制加法，不使用+-* /
    a^b 当前位， (a&b)<<1 进位
 */
public class Add_offer65 {
    public int add(int a, int b){
        if(b == 0){
            return a;
        }else{
            return add(a^b, (a&b)<<1);
        }
    }
}
