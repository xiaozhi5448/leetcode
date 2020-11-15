package middle;

public class DecodeCount_091 {


    public int numDecodings(String s) {

//        String msg = s.replaceFirst("^0*", "");
        String msg = s;
        if(msg.startsWith("0")){
            return 0;
        }
        if(msg.length() < 2){
            return msg.length();
        }else{
            int dp[] = new int[msg.length() + 1];
            dp[0] = 1;
            for(int i = 1; i< msg.length(); i++){
                if(msg.charAt(i) == '0'){
                    if(! "12".contains(msg.substring(i-1, i))){
                        return 0;
                    }
                }
                String neighbours ;
                if(i != msg.length() - 1){
                    neighbours = msg.substring(i - 1, i + 2);
                }else{
                    neighbours = msg.substring(i - 1, msg.length());
                }
                if(neighbours.contains("0")){
                    dp[i] = dp[i -1];
                    continue;
                }
                if(Integer.parseInt(msg.substring(i - 1, i + 1)) <= 26 && Integer.parseInt(msg.substring(i - 1, i + 1)) >= 1){
                    dp[i] = dp[i -1] + dp[i -2>= 0? i - 2:0];
                }else{
                    dp[i] = dp[i - 1];
                }
            }
            return dp[msg.length() - 1];

        }


    }
}
