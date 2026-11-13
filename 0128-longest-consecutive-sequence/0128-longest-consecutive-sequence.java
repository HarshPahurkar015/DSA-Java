import java.util.*;
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }

        int best = 0;
        for(int x : set){
            if(!set.contains(x-1)){
                int y = x+1;

                while(set.contains(y)){
                    y++;
                }

                best = Math.max(best, y-x);
            }
        }

        return best;
    }
}