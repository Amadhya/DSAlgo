class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isEqual(Point p) {
        return p.x == this.x && p.y == this.y;
    }

    public void print() {
        System.out.print("( x: " + this.x + ", y: " + this.y + " ) ");
    }
}

class Street {
    public Point entry;
    public Point exit;

    public Street(Point entry, Point exit) {
        this.entry = entry;
        this.exit = exit;
    }

    public Point getEntryPoint(Point curr) {
        return new Point(curr.x + entry.x, curr.y + entry.y);
    }

    public Point getExitPoint(Point curr) {
        return new Point(curr.x + exit.x, curr.y + exit.y);
    }

    public boolean isEntryUsed(Point prevPoint, Point currPoint) {
        Point entryPoint = this.getEntryPoint(currPoint);

        return prevPoint.isEqual(entryPoint);
    }

    public boolean isExitUsed(Point prevPoint, Point currPoint) {
        Point exitPoint = this.getExitPoint(currPoint);

        return prevPoint.isEqual(exitPoint);
    }

    public boolean canVisitStreet(Point prevPoint, Point currPoint) {
        if ( prevPoint == null ) {
            return true;
        }

        return this.isEntryUsed(prevPoint, currPoint) || this.isExitUsed(prevPoint, currPoint);
    }

    public Point getNextStreetPoint(Point prevPoint, Point currPoint) {
        Point entryPoint = this.getEntryPoint(currPoint);
        Point exitPoint = this.getExitPoint(currPoint);

        if ( prevPoint == null ) {
            return exitPoint;
        }

        return this.isExitUsed(prevPoint, currPoint) ? entryPoint : exitPoint;
    }
}

public class ValidPathInGrid {
    static Street[] streetPaths = {
            new Street(new Point(-1, 0), new Point(1, 0)), // 1
            new Street(new Point(0, -1), new Point(0, 1)), // 2
            new Street(new Point(-1, 0), new Point(0, 1)), // 3
            new Street(new Point(0, 1), new Point(1, 0)), // 4
            new Street(new Point(-1, 0), new Point(0, -1)), // 5
            new Street(new Point(0, -1), new Point(1, 0)), // 6
    };

    public static void checkPathExist(int[][] grid, Point currPoint, Point prevPoint, boolean[][] visited) {
        int sizeY = grid.length;
        int sizeX = grid[ 0 ].length;

        if ( currPoint.x < 0 || currPoint.y < 0 || currPoint.x >= sizeX
                || currPoint.y >= sizeY || visited[ currPoint.y ][ currPoint.x ]
        ) {
            return;
        }

        int street = grid[ currPoint.y ][ currPoint.x ];
        Street streetPath = streetPaths[ street - 1 ];
        Point entryPoint = streetPath.getEntryPoint(currPoint);

        if ( !streetPath.canVisitStreet(prevPoint, currPoint) ) {
            return;
        }

        Point nextPoint = streetPath.getNextStreetPoint(prevPoint, currPoint);

        visited[ currPoint.y ][ currPoint.x ] = true;

        if ( currPoint.x == sizeX - 1 && currPoint.y == sizeY - 1 ) return;

//      For starting point i.e.. (0,0) will have to check in both the directions
        if ( prevPoint == null ) {
            checkPathExist(grid, entryPoint, currPoint, visited);
        }

        checkPathExist(grid, nextPoint, currPoint, visited);
    }

    public static void hasValidPath(int[][] grid) {
        int sizeY = grid.length;
        int sizeX = grid[ 0 ].length;

        boolean[][] visited = new boolean[ sizeY ][ sizeX ];
        checkPathExist(grid, new Point(0, 0), null, visited);

        String result_stmt = "from (0,0) to (" + (sizeX - 1) + "," + (sizeY - 1) + ")";

        if (visited[ sizeY - 1 ][ sizeX - 1 ]) {
            System.out.println("Has a valid path " + result_stmt);
        } else {
            System.out.println("No valid path " + result_stmt);
        }
    }

    public static void main(String[] args) {
        int[][] grid1 = {{2,4,3},{6,5,2}};
        int[][] grid2 = {{1,2,1},{1,2,1}};
        int[][] grid3 = {{1,1,1,1,1,1,3}};

        System.out.println("Case 1 -----------------------");

        hasValidPath(grid1);

        System.out.println("\nCase 2 -----------------------");

        hasValidPath(grid2);

        System.out.println("\nCase 3 -----------------------");

        hasValidPath(grid3);
    }
}