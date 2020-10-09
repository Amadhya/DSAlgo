#include<iostream> 
#include<unordered_map>
using namespace std; 

class Solution {
public:
    bool buddyStrings(string A, string B) {
        if(A.size() != B.size() || A.size() == 1)
            return false;

        int i = 0;
        int index = -1;
        bool swapped = false;
        bool repeat = false;
        unordered_map<char,int> m;
        
        while(i < A.size()) {
            if(!repeat){
                repeat = m[A[i]];
                m[A[i]]++;                
            }

            if (A[i] != B[i]){
                if(index == -1) {
                    index = i;
                } else if(!swapped && A[index] == B[i] && B[index] == A[i]){
                    swapped = true;
                } else {
                    return false;
                }
            }

            i++;
        }
        
        return swapped || (index == -1 && repeat);
    }
};