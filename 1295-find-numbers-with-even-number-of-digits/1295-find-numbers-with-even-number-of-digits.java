class Solution {
    public int findNumbers(int[] nums) {
        int n = nums.length;
        int digit = 0;
        for(int num : nums){
            int length = String.valueOf(num).length();
            if(length % 2 == 0){
                digit++;
            }
        }
        return digit;
    }
}