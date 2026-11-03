class Solution {
    public int minMoves(int[] nums) {
        int sum = 0;
        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i] > maxi){
                maxi = nums[i];
            }
            sum += nums[i];

        }
        return maxi * nums.length - sum;
    }
}