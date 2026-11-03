import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        HashSet<List<Integer>> res = new HashSet<>();
        Arrays.sort(arr);
        for(int i=0; i<arr.length-2; i++){
            if(i>0 && arr[i]==arr[i-1]) {
                continue;
            }
            int l=i+1, r=arr.length-1;
            while(l<r) {
                long sum = (long) arr[i]+arr[l]+arr[r];
                if(sum==0) {
                    List<Integer> temp = Arrays.asList(arr[i], arr[l], arr[r]);
                    res.add(temp);
                    l++;
                    r--;
                    while(l<r && arr[l] == arr[l-1]) l++;
                    while(l<r && arr[r] == arr[r+1]) r--;
                }
                else if(sum<0) l++;
                else if(sum>0) r--;
            }
        }

        return new ArrayList<>(res);
    }
}