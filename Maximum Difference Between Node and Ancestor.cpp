#include <iostream>
#include <climits>
using namespace std;

//  Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};
 
class Solution {
public:
    void help(TreeNode* root,int minEle,int maxEle,int& res){
        if(!root)
            return;
        
        if(minEle != INT_MAX)
            res = max(res,abs(root->val - minEle));
        if(maxEle != INT_MIN)
            res = max(res,abs(root->val - maxEle));
        
        maxEle = max(maxEle,root->val);
        minEle = min(minEle,root->val);
        
        help(root->left,minEle,maxEle,res);
        help(root->right,minEle,maxEle,res);
    }

    int maxAncestorDiff(TreeNode* root) {
        int res = INT_MIN, minEle = INT_MAX, maxEle = INT_MIN;
        
        help(root,minEle,maxEle,res);
        
        return res;
    }
};