#include <iostream>
#include <unordered_map>
#include <vector>
using namespace std;

class Solution
{
public:
    int fourSumCount(vector<int> &A, vector<int> &B, vector<int> &C, vector<int> &D)
    {
        unordered_map<int, int> m;
        int totalCount = 0;

        for (int i = 0; i < A.size(); i++)
        {
            for (int j = 0; j < B.size(); j++)
            {
                m[A[i] + B[j]]++;
            }
        }

        for (int i = 0; i < C.size(); i++)
        {
            for (int j = 0; j < D.size(); j++)
            {
                int sum = C[i] + D[j];

                if (m.find(-1 * sum) != m.end())
                {
                    totalCount += m[-1 * sum];
                }
            }
        }

        return totalCount;
    }
};