import java.util.*;

class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;
        // Sort queries by l ascending
        Arrays.sort(queries, Comparator.comparingInt(a -> a[0]));

        // available: max-heap of r for queries with l <= i
        PriorityQueue<Integer> available = new PriorityQueue<>(Collections.reverseOrder());
        // running: min-heap of r for queries we picked to apply
        PriorityQueue<Integer> running = new PriorityQueue<>();

        int iq = 0; // pointer into queries
        for (int i = 0; i < n; ++i) {
            // add all queries that start at or before i to available
            while (iq < queries.length && queries[iq][0] <= i) {
                available.offer(queries[iq][1]);
                iq++;
            }

            // remove expired running queries (their r < i)
            while (!running.isEmpty() && running.peek() < i) {
                running.poll();
            }

            // ensure we have at least nums[i] running queries covering i
            while (nums[i] > running.size()) {
                // if no available query or the best available ends before i -> impossible
                if (available.isEmpty() || available.peek() < i) {
                    return -1;
                }
                // take the available query with largest r (so it can be used longer)
                running.offer(available.poll());
            }
        }

        // remaining queries in `available` can be removed
        return available.size();
    }
}
