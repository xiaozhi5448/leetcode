package string;

import java.util.HashMap;

public class NumToRoman_12 {
// 硬编码数字
    public String intToRoman(int num) {
        int count[] = new int[4];
        int factor = 1000;
        for(int i = 0; i<3; i++){

            count[i] = num/factor;
            num = num % factor;
            factor /= 10;
        }
        count[3] = num %10;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < count[0]; i++){
            sb.append('M');
        }
        if(count[1] == 9){
            sb.append("CM");
        }else if(count[1] >= 5  ){
            sb.append("D");
            for(int i = 0; i< count[1] - 5; i++){
                sb.append("C");
            }
        }else if(count[1] == 4){
            sb.append("CD");
        }else{
            for(int i = 0; i< count[1]; i++){
                sb.append('C');
            }
        }

        if(count[2] == 9){
            sb.append("XC");
        }else if(count[2] >= 5){
            sb.append('L');
            for(int i = 0; i < count[2] - 5; i++){
                sb.append('X');
            }
        }else if(count[2] == 4){
            sb.append("XL");
        }
        else{
            for(int i = 0; i < count[2]; i++){
                sb.append('X');
            }
        }

        if(count[3] == 9){
            sb.append("IX");
        }else if(count[3] >= 5){
            sb.append("V");
            for(int i = 0; i< count[3] - 5; i++){
                sb.append('I');
            }
        }else if(count[3] == 4){
            sb.append("IV");
        }else{
            for(int i = 0; i< count[3]; i++){
                sb.append('I');
            }
        }

        return sb.toString();

    }

    public String getNumStr(int num){
        switch(num){
            case 1000: return "M";
            case 900: return "CM";
            case 500: return "D";
            case 400: return "CD";
            case 100: return "C";
            case 90: return "XC";
            case 50: return "L";
            case 40: return "XL";
            case 10: return "X";
            case 9: return "IX";
            case 5: return "V";
            case 4: return "IV";
            case 1: return "I";
            default: return "";
        }
    }
    private int findNextSmall(int[] nums, int num, int start){
        for(int i = start; i < nums.length; i++){
            if(nums[i] <= num){
                return i;
            }
        }
        return -1;
    }
    public String intToRoman2(int num){
        StringBuilder sb = new StringBuilder();
        int[] units = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int index = 0;
        while(num != 0){
            index = findNextSmall(units, num, index);
            if(index != -1){
                sb.append(getNumStr(units[index]));
            }
            num -= units[index];
        }
        return sb.toString();
    }

}
