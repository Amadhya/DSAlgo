#include<iostream>
#include<vector>
using namespace std;

class Solution {
public:
    int maxArea(vector<int>& height) {
        int start = 0, end = height.size() - 1, currMax = 0;
        
        while(start < end) {
            currMax = max(currMax, (end - start) * min(height[start],height[end]));
            
            if(height[start] < height[end])
                start++;
            else
                end--;
        }
        
        return currMax;
    }
};