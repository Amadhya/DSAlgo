import java.util.HashSet;
import java.util.Set;

class Point {
  public int x;
  public int y;

  public Point(int x, int y) {
    this.y = y;
    this.x = x;
  }

  public Point diff(Point p) {
    return new Point(p.x - x, p.y - y);
  }

  public String toString() {
    return this.x + "" + this.y;
  }
}

public class NumberOfDistinctIslands {
  static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  public static String dfs(int[][] grid, Point curr, Point initial) {
    int currY = curr.y;
    int currX = curr.x;

    if (currY < 0
        || currX < 0
        || currY >= grid.length
        || currX >= grid[0].length
        || grid[currY][currX] != 1) {
      return "";
    }

    grid[currY][currX] = -1;

    StringBuilder relativePath = new StringBuilder(initial.diff(curr).toString());

    for (int[] direction : directions) {
      int newX = currX + direction[0];
      int newY = currY + direction[1];

      relativePath.append(dfs(grid, new Point(newX, newY), initial));
    }

    return relativePath.toString();
  }

  public static int findNumberOfDistinctIslands(int[][] grid) {
    Set<String> uniqueRelativePath = new HashSet<>();

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] != 1) {
          continue;
        }
        Point curr = new Point(j, i);

        String relativePath = dfs(grid, curr, curr);

        uniqueRelativePath.add(relativePath);
      }
    }

    return uniqueRelativePath.size();
  }

  public static void main(String[] args) {
    int[][] grid1 = {
      {1, 1, 0, 1, 1},
      {1, 0, 0, 0, 0},
      {0, 0, 0, 0, 1},
      {1, 1, 0, 1, 1}
    };
    int[][] grid2 = {
      {1, 1, 0},
      {0, 1, 1},
      {0, 0, 0},
      {1, 1, 1},
      {0, 1, 0},
    };

    System.out.println("Number of distinct islands is ");
    System.out.println("Case1 " + findNumberOfDistinctIslands(grid1));
    System.out.println("Case2 " + findNumberOfDistinctIslands(grid2));
  }
}
