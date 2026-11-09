class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Count frequency of every number
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Put unique numbers into an array
        int[] unique = new int[map.size()];
        int index = 0;

        for (int num : map.keySet()) {
            unique[index++] = num;
        }

        // Step 3: Sort based on frequency
        Integer[] arr = new Integer[unique.length];

        for (int i = 0; i < unique.length; i++) {
            arr[i] = unique[i];
        }

        Arrays.sort(arr, (a, b) -> map.get(b) - map.get(a));

        // Step 4: Take first k elements
        int[] answer = new int[k];

        for (int i = 0; i < k; i++) {
            answer[i] = arr[i];
        }

        return answer;
    }
}