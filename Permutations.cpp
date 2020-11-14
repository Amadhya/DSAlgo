#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    void help(vector<int> &nums, int start, vector<int> curr, vector<vector<int>> &res)
    {
        if (start == nums.size())
        {
            res.push_back(curr);
            return;
        }

        for (int i = start; i < nums.size(); i++)
        {
            swap(nums[i], nums[start]);
            curr.push_back(nums[start]);
            help(nums, start + 1, curr, res);
            curr.pop_back();
            swap(nums[i], nums[start]);
        }
    }
    vector<vector<int>> permute(vector<int> &nums)
    {
        vector<int> curr;
        vector<vector<int>> res;

        help(nums, 0, curr, res);

        return res;
    }
};