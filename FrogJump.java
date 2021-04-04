import java.util.HashMap;
import java.util.Map;

class Solution {
  static int[] jumps = {1, 0, -1};

  public boolean check(
      int start, int end, Map<Integer, Boolean> map, int k, Map<String, Boolean> visited) {
    if (start == end) {
      return true;
    }

    String key = start + "/" + k;

    if (visited.containsKey(key)) {
      return false;
    }

    visited.put(key, true);

    if (!map.containsKey(start)) {
      return false;
    }

    for (int jump : jumps) {
      if (k + jump > 0 && check(start + k, end, map, k + jump, visited)) {
        return true;
      }
    }

    return false;
  }

  public boolean canCross(int[] stones) {
    Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();

    for (int stone : stones) {
      map.put(stone, true);
    }

    return check(0, stones[stones.length - 1], map, 1, new HashMap<>());
  }
}
