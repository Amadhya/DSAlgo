import java.util.Arrays;

class Solution {
  public int getMaximumGap(int[] cuts, int len) {
    int prevCut = 0;
    int maxGap = 0;

    Arrays.sort(cuts);

    for (int cut : cuts) {
      maxGap = Math.max(maxGap, cut - prevCut);
      prevCut = cut;
    }
    return Math.max(maxGap, len - prevCut);
  }

  public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
    int horizontalMaxGap = getMaximumGap(horizontalCuts, h);
    int verticalMaxGap = getMaximumGap(verticalCuts, w);

    return (int) ((long) horizontalMaxGap * verticalMaxGap % 1000000007);
  }
}
