import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KAdjacentSwaps {
    public String swapSmallest(String num, int k, int currIndex) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        Map<Integer, Integer> eleIndexMap = new HashMap<>();

        for (int i = 0; i < num.length(); i++) {
            eleIndexMap.put(num.charAt(i) - '0', i);
        }

        for (int i = currIndex + 1; i < num.length() && i < k; i++) {
            pq.add(num.charAt(i) - '0');
        }

        Integer minEle = pq.peek();
        pq.poll();

        System.out.println("Min Ele: " + minEle);

        if (minEle != null) {
            char temp = num.charAt(currIndex);
            Integer oldIndex = eleIndexMap.get(minEle);
            Integer stepsUsed = oldIndex - currIndex;
            StringBuilder sb = new StringBuilder(num);

            sb.setCharAt(currIndex, (char)(minEle + '0'));
            sb.setCharAt(oldIndex, temp);

            System.out.println("String: " + sb.toString());

            return sb.toString();
        }

        return num;
    }

    public String minInteger(String num, int k) {
        for (int i = 0; i < num.length(); i++) {
            num = swapSmallest(num, k, i);
        }

        return num;
    }
}
