#include<iostream> 
#include<vector>
using namespace std; 

class Solution {
public:
    bool check(vector<vector<char>>& board, string word, int y, int x, int start, int sizeY, int sizeX){
        if(start == word.size())
            return true;
        
        if(x < 0 || x >= sizeX || y < 0 || y >= sizeY)
            return false;
        
        if(board[y][x] == '.' || word[start] != board[y][x])
            return false;
        
        board[y][x]='.';
        
        if(check(board,word,y,x+1,start+1,sizeY,sizeX))
            return true;
        
        if(check(board,word,y,x-1,start+1,sizeY,sizeX))
            return true;
        
        if(check(board,word,y+1,x,start+1,sizeY,sizeX))
            return true;
        
        if(check(board,word,y-1,x,start+1,sizeY,sizeX))
            return true;
        
        board[y][x]=word[start];
        
        return false;
    }
    bool exist(vector<vector<char>>& board, string word) {
        vector<string> strSet;
        int n = board.size();

        for(int i=0;i<board.size();i++){
            int m = board[i].size();

            for(int j = 0;j < m;j++){
                if(check(board,word,i,j,0,n,m))
                    return true;
            }
        }
        
        return false;
    }
};