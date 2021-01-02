package string;

public class RomanNum_13 {
    public int romanToInt(String s) {
        int res = 0;
        for(int i = 0; i< s.length(); i++){
            switch(s.charAt(i)){
                case 'I':
                    if(i+1 >= s.length()){
                        res += 1;
                    }else if(s.charAt(i+1) == 'V'){
                        res += 4;
                        i++;
                    }else if(s.charAt(i+1) == 'X'){
                        res += 9;
                        i++;
                    }else{
                        res += 1;
                    }
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'X':
                    if(i+1>=s.length()){
                        res += 10;
                    }else if(s.charAt(i+1) == 'L'){
                        res += 40;
                        i++;
                    }else if(s.charAt(i+1) == 'C'){
                        res += 90;
                        i++;
                    }else{
                        res += 10;
                    }
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'C':
                    if(i+1 >= s.length()){
                        res += 100;
                    }else if(s.charAt(i+1) == 'D'){
                        res += 400;
                        i++;
                    }else if(s.charAt(i+1) == 'M'){
                        res += 900;
                        i++;
                    }else{
                        res += 100;
                    }
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'M':
                    res += 1000;
                    break;
            }
        }
        return res;
    }
    private int getValue(char ch){
        switch(ch){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return -1;
        }
    }
    public int romanToInt2(String s){
        int res = 0;
        int[] nums = new int[s.length()];
        for(int i = 0; i< s.length(); i++){
            if(i+1 < s.length() && getValue(s.charAt(i)) < getValue(s.charAt(i+1))){
                nums[i] = -getValue(s.charAt(i));
            }else{
                nums[i] = getValue(s.charAt(i));
            }
        }
        for(Integer num:nums){
            res += num;
        }
        return res;

    }
}
