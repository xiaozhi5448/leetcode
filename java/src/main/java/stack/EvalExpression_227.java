package stack;

import java.util.*;

public class EvalExpression_227 {

    Map<Character, Integer> operators = new HashMap<>();
    int index = 0;
    public EvalExpression_227(){
        operators.put('-', 1);
        operators.put('+', 1);
        operators.put('*', 2);
        operators.put('/', 2);
    }

    private Integer parseInt(String s){
        if(index == s.length()){
            return 0;
        }
        int startIndex = index;
        int endIndex = index;
        while(endIndex < s.length() && s.charAt(endIndex) >= '0' && s.charAt(endIndex) <= '9'){
            endIndex++;
        }
        if(endIndex == startIndex){
            return 0;
        }
        index = endIndex;
        return Integer.valueOf(s.substring(startIndex, endIndex));
    }

    private void transInfixToSuffixExp(String s){
        
    }
}
