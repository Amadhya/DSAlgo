class Solution {
  int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  public boolean detectCycle(
      char[][] grid, int x, int y, int prevX, int prevY, boolean[][] visited) {

    if (visited[y][x]) {
      return true;
    }
    
    visited[y][x] = true;

    for (int[] direction : directions) {
      int newX = x + direction[0];
      int newY = y + direction[1];

      if (newX >= 0
          && newY >= 0
          && newY < grid.length
          && newX < grid[0].length
          && grid[y][x] == grid[newY][newX]
          && !(prevX == newX && prevY == newY)) {
        if (detectCycle(grid, newX, newY, x, y, visited)) {
          return true;
        }
      }
    }

    return false;
  }

  public boolean containsCycle(char[][] grid) {
    boolean[][] visited = new boolean[grid.length][grid[0].length];

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (!visited[i][j] && detectCycle(grid, j, i, -1, -1, visited)) {
          return true;
        }
      }
    }

    return false;
  }
}
