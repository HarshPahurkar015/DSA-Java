class Solution {
    public int[] dailyTemperatures(int[] temps) {
        Stack<Integer> st = new Stack<>();
        int  n = temps.length;
        int result[] = new int[n];
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && temps[st.peek()] < temps[i]){
                result[st.peek()] = i - st.pop();
            }
            st.push(i);
        }

        return result;
    }
}