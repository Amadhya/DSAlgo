#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    void check(int y, int x, int n, int m, vector<vector<char>> &grid, vector<vector<int>> &visited)
    {
        if (y < 0 || y >= n || x < 0 || x >= m || grid[y][x] == '0' || visited[y][x])
            return;

        visited[y][x] = 1;

        check(y + 1, x, n, m, grid, visited);
        check(y - 1, x, n, m, grid, visited);
        check(y, x + 1, n, m, grid, visited);
        check(y, x - 1, n, m, grid, visited);

        return;
    }
    int numIslands(vector<vector<char>> &grid)
    {
        int n = grid.size();
        int m = grid[0].size();
        int num = 0;

        vector<vector<int>> visited(n, vector<int>(m, 0));

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (grid[i][j] == '1' && !visited[i][j])
                {
                    check(i, j, n, m, grid, visited);
                    num++;
                }
            }
        }

        return num;
    }
};