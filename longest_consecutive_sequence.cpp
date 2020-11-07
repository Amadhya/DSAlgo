#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

class Solution
{
public:
    int longestConsecutive(vector<int> &nums)
    {
        unordered_map<int, int> m;
        int len = nums.size();
        int maxCount = 0;

        for (int i = 0; i < len; i++)
        {
            m[nums[i]]++;
        }

        for (int i = 0; i < len; i++)
        {
            if (!m[nums[i] + 1])
            {
                int n = nums[i];
                int count = 0;

                while (m[n])
                {
                    count++;
                    n--;
                }

                maxCount = max(maxCount, count);
            }
        }

        return maxCount;
    }
};