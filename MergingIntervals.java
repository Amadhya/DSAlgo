import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

class Intervals {
    int start;
    int end;

    Intervals(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class MergingIntervals {
    public static void printArray(Intervals[] arr) {
        for (int i = 0; i < arr.length; i++) {
            Intervals interval = arr[i];

            System.out.print("{ " + interval.start + ", " + interval.end + " }, ");
        }

        System.out.print("\n");
    }

    public static void merge(Intervals[] arr) {
        int len = arr.length;
        Stack<Intervals> stack = new Stack<>();

        if (len == 0)    return;

        Arrays.sort(arr, new Comparator<Intervals>() {
            public int compare(Intervals o1, Intervals o2) {
                return o1.start - o2.start;
            }
        });

        System.out.print("Sorted Intervals: ");

        printArray(arr);

        stack.push(arr[0]);

        for (int i = 1; i < len; i++) {
            if (stack.isEmpty() || stack.peek().end < arr[i].start) {
                stack.push(arr[i]);
            } else {
                Intervals peek = stack.peek();
                stack.pop();

                peek.end = Integer.max(arr[i].end, peek.end);
                stack.push(peek);
            }
        }

        System.out.print("Merged Intervals: ");

        while (!stack.isEmpty()) {
            Intervals peek = stack.peek();
            stack.pop();

            System.out.print("{ " + peek.start + ", " + peek.end + " }, ");
        }
    }

    public static void main(String[] args) {
        Intervals[] arr = new Intervals[5];
        arr[0] = new Intervals(4, 5);
        arr[1] = new Intervals(1, 3);
        arr[2] = new Intervals(5, 7);
        arr[3] = new Intervals(2, 6);
        arr[4] = new Intervals(10, 15);

        System.out.print("Original Intervals: ");

        printArray(arr);

        merge(arr);
    }
}
