import java.util.*;
class Solution {
    public static int operation(int a, int b, String token){
        if(token.equals("+")){
            return a+b;
        }

        if(token.equals("-")){
            return a-b;
        }

        if(token.equals("*")){
            return a*b;
        }

        if(token.equals("/")){
            return a/b;
        }
        return -1;
    }
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            if(tokens[i].equals ("+") || tokens[i].equals ("-") || tokens[i].equals ("*") || tokens[i].equals ("/")){
                int b = st.peek();
                st.pop();

                int a = st.peek();
                st.pop();

                int result = operation(a, b, tokens[i]);
                st.push(result);
            }else{
                st.push(Integer.parseInt(tokens[i]));
            }
        }

        return st.peek();
    }
}