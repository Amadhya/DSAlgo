import java.util.PriorityQueue;

public class ConnectSticks {
  public static int findMinimumCost(int[] arr) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int cost = 0;

    for (int len : arr) {
      pq.add(len);
    }

    while (pq.size() > 1) {
      int first = pq.peek();
      pq.poll();

      int second = pq.peek() != null ? pq.peek() : 0;
      pq.poll();

      cost += first + second;
      pq.add(first + second);
    }

    return cost;
  }

  public static void main(String[] args) {
    int[] arr1 = {2, 4, 3};
    int[] arr2 = {1, 8, 3, 5};
    int[] arr3 = {5};

    System.out.println("Cost 1: " + findMinimumCost(arr1));
    System.out.println("Cost 2: " + findMinimumCost(arr2));
    System.out.println("Cost 3: " + findMinimumCost(arr3));
  }
}
