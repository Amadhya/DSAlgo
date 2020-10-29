#include <iostream>
#include <vector>
#include <queue>
using namespace std;

class Solution
{
public:
    bool isCordValid(int x, int y, int n, int m, vector<vector<int>> &grid)
    {
        return x < m && x >= 0 && y < n && y >= 0 && grid[y][x] == 1;
    }

    void updateQueue(int x, int y, int n, int m, vector<vector<int>> &grid, queue<pair<int, int>> &q, int &freshOranges)
    {
        if (isCordValid(x + 1, y, n, m, grid))
        {
            q.push(make_pair(y, x + 1));
            grid[y][x + 1] = 2;
            freshOranges--;
        }
        if (isCordValid(x - 1, y, n, m, grid))
        {
            q.push(make_pair(y, x - 1));
            grid[y][x - 1] = 2;
            freshOranges--;
        }
        if (isCordValid(x, y + 1, n, m, grid))
        {
            q.push(make_pair(y + 1, x));
            grid[y + 1][x] = 2;
            freshOranges--;
        }
        if (isCordValid(x, y - 1, n, m, grid))
        {
            q.push(make_pair(y - 1, x));
            grid[y - 1][x] = 2;
            freshOranges--;
        }
    }

    int orangesRotting(vector<vector<int>> &grid)
    {
        queue<pair<int, int>> q;
        int n = grid.size();
        int m = grid[0].size();
        int time = 0;
        int freshOranges = 0;

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (grid[i][j] == 2)
                    q.push(make_pair(i, j));

                freshOranges += grid[i][j] == 1;
            }
        }

        if (!freshOranges)
            return 0;

        q.push(make_pair(-1, -1));

        while (!q.empty())
        {
            pair<int, int> curr = q.front();
            q.pop();
            int i = curr.first;
            int j = curr.second;

            if (i == -1 && j == -1)
            {
                q.push(make_pair(-1, -1));
                time++;
                while (!q.empty() && q.front().first == -1 && q.front().second == -1)
                    q.pop();

                continue;
            }

            updateQueue(j, i, n, m, grid, q, freshOranges);
        }

        return !freshOranges ? time - 1 : -1;
    }
};