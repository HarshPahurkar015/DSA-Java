class Solution {
    public int minMoves(int[] nums) {
        int count = 0;
        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i] > maxi){
                maxi = nums[i];
            }
        }
        for(int i=0; i<nums.length; i++){
            count += maxi-nums[i];
        }
        return count;
    }
}