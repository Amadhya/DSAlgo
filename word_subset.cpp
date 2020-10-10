#include<iostream> 
#include<unordered_map>
#include<vector>
using namespace std; 

class Solution {
public:
    bool isSubStr(unordered_map<char,int> m, string word, int patSize){
        int i = 0;
        
        while(i < word.size()){
            if(m[word[i]]){
                m[word[i]]--;
                patSize--;
            }
            
            i++;
        }
        
        return !patSize;
    }

    vector<string> wordSubsets(vector<string>& A, vector<string>& B) {
        unordered_map<char,int> m1;
        vector<string> res;
        int patSize = 0;
        
        for(int i = 0; i < B.size(); i++) {
            unordered_map<char, int> m2;
            string word = B[i];
            
            int j = 0;
            while(j < word.size()){
                char ch = word[j];

                m2[ch]++;

                if(m1[ch] < m2[ch]){
                    m1[ch] = m2[ch];
                    patSize++;
                }

                j++;
            }
        }
        
        for(int i = 0; i < A.size(); i++) {
            string word = A[i];
            bool isUniversal = isSubStr(m1,word,patSize);
            
            if(isUniversal){
                res.push_back(word);
            }
        }
        
        return res;
    }
};
