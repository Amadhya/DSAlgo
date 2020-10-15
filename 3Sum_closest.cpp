#include <iostream>
#include <vector>
#include <climits>
#include <algorithm>
using namespace std;

class Solution
{
public:
    int threeSumClosest(vector<int> &nums, int target)
    {
        int diff = INT_MAX;
        int size = nums.size();
        sort(nums.begin(), nums.end());

        for (int i = 0; i < size; i++)
        {
            int start = i + 1;
            int end = size - 1;

            while (start < end)
            {
                int currSum = nums[start] + nums[end] + nums[i];
                if (abs(target - currSum) < abs(diff))
                {
                    diff = target - currSum;
                }

                if (currSum < target)
                    start++;
                else
                    end--;
            }
        }

        return target - diff;
    }
};