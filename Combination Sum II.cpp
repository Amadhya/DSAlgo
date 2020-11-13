#include <iostream>
#include <vector>
#include <algorithm>
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

        help(candidates, target - currEle, start + 1, curr, res);

        curr.pop_back();

        while (start < candidates.size() && candidates[start] == currEle)
            start++;

        help(candidates, target, start, curr, res);
    }

    vector<vector<int>> combinationSum2(vector<int> &candidates, int target)
    {
        vector<int> curr;
        vector<vector<int>> res;

        sort(candidates.begin(), candidates.end());

        help(candidates, target, 0, curr, res);

        return res;
    }
};