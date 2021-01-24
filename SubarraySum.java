import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int size = nums.length;

        if ( size == 0 ) return -1;

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;

        map.put(0, 1);

        for (int val : nums) {
            sum += val;

            if ( map.get(sum - k) != null ) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}