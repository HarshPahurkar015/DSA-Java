import java.util.*;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        int unique[] = new int[map.size()];
        int index = 0;

        for(int num : map.keySet()){
            unique[index++] = num;
        }

        Integer arr []= new Integer[unique.length];

        for(int i=0; i<unique.length; i++){
            arr[i] = unique[i];
        }

        Arrays.sort(arr, (a,b) -> map.get(b) - map.get(a));
        int answer[] = new int [k];

        for(int i=0; i<k; i++){
            answer[i] = arr[i];
        }

        return answer;
    }
}