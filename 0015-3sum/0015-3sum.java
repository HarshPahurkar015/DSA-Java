import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        HashSet<List<Integer>> res = new HashSet<>();
        Arrays.sort(arr);
        for(int i=0; i<arr.length-2; i++){
            int l=i+1, r=arr.length-1;
            while(l<r) {
                long sum = (long) arr[i]+arr[l]+arr[r];
                if(sum==0) {
                    List<Integer> temp = Arrays.asList(arr[i], arr[l], arr[r]);
                    res.add(temp);
                    l++;
                    r--;
                }
                else if(sum<0) l++;
                else if(sum>0) r--;
            }
        }

        return new ArrayList<>(res);
    }
}