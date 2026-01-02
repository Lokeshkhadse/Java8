package Stack_Queue.Parenthesis_code;

import java.util.Stack;

public class Parenthesis_code {
    public static void main(String[] args) {
        String s = "()[]{}";
        boolean ans = isValid(s);
        System.out.println(ans);
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch:s.toCharArray()){
            if(ch =='(' || ch =='{' || ch =='['){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    return false;
                }


                char prev = stack.pop();

                if(ch == ')' && prev == '(' || ch == '}' && prev == '{' || ch == ']' && prev == '['){
                    continue;
                }else{
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
