#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    int segregate(vector<int> &nums)
    {
        int start = 0;

        for (int i = 0; i < nums.size(); i++)
        {
            if (nums[i] <= 0)
            {
                swap(nums[i], nums[start]);
                start++;
            }
        }

        return start;
    }

    int find(vector<int> &nums)
    {
        int len = nums.size();

        for (int i = 0; i < len; i++)
        {
            if (abs(nums[i]) - 1 < len && nums[abs(nums[i]) - 1] > 0)
            {
                nums[abs(nums[i]) - 1] = -1 * nums[abs(nums[i]) - 1];
            }
        }

        for (int i = 0; i < len; i++)
        {
            if (nums[i] > 0)
                return i + 1;
        }

        return len + 1;
    }

    int firstMissingPositive(vector<int> &nums)
    {
        int start = segregate(nums);
        vector<int> newNums(nums.begin() + start, nums.end());

        return find(newNums);
    }
};