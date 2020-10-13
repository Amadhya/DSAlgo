#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    int numIdenticalPairs(vector<int> &nums)
    {
        int countArr[101];
        int sum = 0;

        for (int i = 0; i < 101; i++)
            countArr[i] = 0;

        for (int i = 0; i < nums.size(); i++)
        {
            countArr[nums[i]]++;
        }

        for (int i : countArr)
        {
            sum += i * (i - 1) / 2;
        }

        return sum;
    }
};