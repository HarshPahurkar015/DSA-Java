class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> res = new HashSet<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0; i<n-2; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int l = i+1, r = n-1;
            while(l<r){
                long sum = (long) nums[i] + nums[l] + nums[r];
                if(sum == 0){
                    List<Integer> temp = Arrays.asList(nums[i] , nums[l], nums[r]);
                    res.add(temp);
                    l++;
                    r--;

                    while(l<r && nums[l] == nums[l-1]){
                        l++;
                    }

                    while(l<r && nums[r] == nums[r+1]){
                        r--;
                    }
                }else if(sum < 0){
                    l++;
                }else{
                    r--;
                }
            }
        }

        return new ArrayList<>(res);
    }
}