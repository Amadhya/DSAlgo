class Solution {

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] right = new int[len];
        int[] res = new int[len];

        right[len - 1] = 1;

        for(int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        int left = 1;

        for(int i = 0; i < len; i++) {
            res[i] = left * right[i];
            left *= nums[i];
        }

        return res;
    }
}