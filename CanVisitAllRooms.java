import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CanVisitAllRooms {
    public static void visitRooms(List<List<Integer>> rooms, Integer currRoom, HashMap<Integer, Boolean> visited) {
        if (currRoom >= rooms.size() || visited.get(currRoom) != null) {
            return;
        }

        visited.put(currRoom,true);
        List<Integer> keys = rooms.get(currRoom);

        for (Integer key : keys) {
            visitRooms(rooms, key, visited);
        }
    }

    public static void canVisitAllRooms(List<List<Integer>> rooms) {
        HashMap<Integer, Boolean> visited= new HashMap<Integer, Boolean>();

        visitRooms(rooms,0,visited);

        if (visited.size() == rooms.size()) {
            System.out.println("Visited all the rooms");
        } else {
            System.out.println("Not able to visit all the rooms");
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms1 =
                Arrays.asList(
                        Collections.singletonList(1),
                        Collections.singletonList(2),
                        Collections.singletonList(3),
                        Collections.emptyList()
                );

        List<List<Integer>> rooms2 =
                Arrays.asList(
                        Arrays.asList(1,3),
                        Arrays.asList(3,0,1),
                        Collections.singletonList(2),
                        Collections.singletonList(0)
                );

        System.out.println("Case 1 -----------------------");

        canVisitAllRooms(rooms1);

        System.out.println("\nCase 2 -----------------------");

        canVisitAllRooms(rooms2);
    }
}
