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
        Stack<Integer> st = new Stack<>();
        int n = tokens.length;
        for(int i=0; i<n; i++){
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
                int b = st.pop();
                int a = st.pop();

                int result = operation(a, b, tokens[i]);
                st.push(result);
            }else{
                st.push(Integer.parseInt(tokens[i]));
            }
        }

        return st.peek();
    }
}