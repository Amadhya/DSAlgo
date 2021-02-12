public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        if (nums.length == 0)   return -1;

        Boolean[] visited = new Boolean[nums.length];

        int maxLen = 0;

        for(int num: nums) {
            int len = 0;
            int curr = num;

            while(visited[curr] == null) {
                visited[curr] = true;
                curr = nums[curr];
                len++;
            }

            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}
