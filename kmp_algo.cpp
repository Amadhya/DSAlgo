#include<iostream> 
using namespace std;

class Solution {
public:
    void constructLps(int* lps, string pat, int size){
        int i=1;
        int j=0;
        
        while(i < size && j < size){
            if(pat[i] == pat[j]){
                lps[i] = j + 1;
                i++;
                j++;
            } else {
                if(j)
                    j = lps[j-1];
                else
                    i++;
            }
        }
    }
    bool isSubStr(string pat, string word){
        int n = word.size();
        int m = pat.size();
        
        int lps[m];
        
        for(int i = 0; i<m;i++ ){
            lps[i] = 0;
        }
        
        int i=0;
        int j=0;
        
        constructLps(lps,pat,m);
        
        while(i<word.size()){
            if(pat[j] == word[i]){
                i++;
                j++;
            } else {
                if(j)
                    j = lps[j-1];
                else 
                    i++;
            }
            
            if(j == m){
                return true;
            }
        }
    
        return false;
    }
};