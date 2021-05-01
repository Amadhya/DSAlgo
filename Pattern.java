class Solution {
    public boolean find132pattern(int[] nums) {
        int start = 0;
        int end = 0;

        while(start < nums.length) {
            while(start + 1 < nums.length && nums[start] >= nums[start + 1]) {
                start++;
            }

            end = start + 1;

            while(end + 1 < nums.length && nums[end] <= nums[end + 1]) {
                end++;
            }

            int i = end + 1;

            while(i < nums.length) {
                if (nums[i] > nums[start] && nums[i] < nums[end]) {
                    return true;
                }
                i++;
            }
        }

        return false;
    }
}