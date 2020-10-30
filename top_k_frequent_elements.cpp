#include <iostream>
#include <vector>
#include <queue>
#include <unordered_map>
using namespace std;

class Solution
{
public:
    vector<int> topKFrequent(vector<int> &nums, int k)
    {
        unordered_map<int, int> m;
        vector<int> res;

        for (auto num : nums)
        {
            m[num]++;
        }

        priority_queue<pair<int, int>> pq;

        for (auto &it : m)
        {
            pq.push(make_pair(it.second, it.first));
        }

        while (!pq.empty() && k)
        {
            res.push_back(pq.top().second);
            pq.pop();
            k--;
        }

        return res;
    }
};