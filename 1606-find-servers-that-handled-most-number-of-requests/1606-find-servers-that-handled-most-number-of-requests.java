class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

        // Stores currently available servers in sorted order
        TreeSet<Integer> available = new TreeSet<>();

        // Initially all servers are available
        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        // Min-heap: [finishTime, serverIndex]
        PriorityQueue<int[]> busy = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        // Number of requests handled by each server
        int[] count = new int[k];

        for (int i = 0; i < arrival.length; i++) {

            int currentTime = arrival[i];

            // Release all servers whose requests have finished
            while (!busy.isEmpty() && busy.peek()[0] <= currentTime) {
                int server = busy.poll()[1];
                available.add(server);
            }

            // If all servers are busy, drop this request
            if (available.isEmpty()) {
                continue;
            }

            // Preferred server
            int preferred = i % k;

            // Find first available server >= preferred
            Integer server = available.ceiling(preferred);

            // If not found, wrap around to smallest server
            if (server == null) {
                server = available.first();
            }

            // Remove server from available servers
            available.remove(server);

            // Increase request count
            count[server]++;

            // Add server to busy heap
            busy.offer(new int[]{
                currentTime + load[i],
                server
            });
        }

        // Find maximum number of requests handled
        int max = 0;

        for (int c : count) {
            max = Math.max(max, c);
        }

        // Store all servers having maximum count
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                ans.add(i);
            }
        }

        return ans;
    }
}