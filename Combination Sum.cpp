#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    void help(vector<int> &candidates, int target, int start, vector<int> curr, vector<vector<int>> &res)
    {
        if (!target)
        {
            res.push_back(curr);
            return;
        }

        if (start == candidates.size() || target < 0)
            return;

        int currEle = candidates[start];

        curr.push_back(currEle);

        help(candidates, target - currEle, start, curr, res);

        curr.pop_back();

        help(candidates, target, start + 1, curr, res);
    }

    vector<vector<int>> combinationSum(vector<int> &candidates, int target)
    {
        vector<int> curr;
        vector<vector<int>> res;

        help(candidates, target, 0, curr, res);

        return res;
    }
};