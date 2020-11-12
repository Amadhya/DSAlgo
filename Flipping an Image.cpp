#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    void flip(vector<int> &v)
    {
        int end = v.size() - 1;
        int start = 0;

        while (start < end)
        {
            int t = v[start];
            v[start] = v[end];
            v[end] = t;

            start++;
            end--;
        }

        return;
    }

    void invert(vector<int> &v)
    {
        int size = v.size();
        int start = 0;

        while (start < size)
        {
            v[start] = !v[start];

            start++;
        }

        return;
    }

    vector<vector<int>> flipAndInvertImage(vector<vector<int>> &A)
    {
        int size = A.size();

        for (int i = 0; i < size; i++)
        {
            flip(A[i]);
            invert(A[i]);
        }

        return A;
    }
};