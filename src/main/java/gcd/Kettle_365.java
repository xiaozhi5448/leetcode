package gcd;

public class Kettle_365 {
    public boolean canMeasureWater(int x, int y, int z) {
        int sub = Math.abs(x- y);
        int x_count;
        int y_count;
        int sub_count;
        if(x != 0)
            x_count = Math.max(1, (int)Math.ceil(z/(float)x));
        else{
            x_count = 1;
        }
        if(y != 0){
            y_count = Math.max(1, (int)Math.ceil(z / (float)y));
        }else{
            y_count = 1;
        }
        if(x != y){
            sub_count = Math.max(1, (int)Math.ceil(z / (float)sub));
        }else{
            sub_count = 1;
        }
        for(int i = 0; i<= x_count; i++){
            for(int j = 0; j <= y_count; j++){
                for(int k = 0; k <= sub_count; k++){
                    if(i*x + j * y + k * sub == z){
                        return true;
                    }
                }
            }
        }
        return false;

    }
}
