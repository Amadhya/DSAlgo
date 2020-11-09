#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    int uniquePathsWithObstacles(vector<vector<int>> &obstacleGrid)
    {
        int n = obstacleGrid.size();
        int m = obstacleGrid[0].size();

        vector<vector<int>> path(n, vector<int>(m, 0));

        path[0][0] = !obstacleGrid[0][0];

        for (int i = 1; i < n; i++)
        {
            path[i][0] = !obstacleGrid[i][0] && path[i - 1][0];
        }

        for (int i = 1; i < m; i++)
        {
            path[0][i] = !obstacleGrid[0][i] && path[0][i - 1];
        }

        for (int i = 1; i < n; i++)
        {
            for (int j = 1; j < m; j++)
            {
                if (!obstacleGrid[i][j])
                    path[i][j] = path[i - 1][j] + path[i][j - 1];
            }
        }

        return path[n - 1][m - 1];
    }
};