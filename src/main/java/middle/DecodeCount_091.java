package middle;

public class DecodeCount_091 {


    public int numDecodings(String s) {

        String msg = s.replaceFirst("^0*", "");
        if(msg.length() == 1){
            return 1;
        }else if(msg.length() == 0){
            return 0;
        }else{
            if(msg.contains("00")){
                return 0;
            }
            int dp[] = new int[msg.length() + 1];
            dp[0] = 1;dp[1] = 1;
            for(int i = 2; i<= msg.length(); i++){
                String neighbours ;
                if(i != msg.length()){
                    neighbours = msg.substring(i - 2, i + 1);
                }else{
                    neighbours = msg.substring(i - 2, msg.length());
                }
                if(neighbours.contains("0")){
                    dp[i] = dp[i -1];
                    continue;
                }
                if(Integer.parseInt(msg.substring(i - 2, i)) <= 26 && Integer.parseInt(msg.substring(i - 2, i)) >= 1){
                    dp[i] = dp[i -1] + dp[i -2];
                }else{
                    dp[i] = dp[i - 1];
                }
            }
            return dp[msg.length()];

        }


    }
}
