#include <iostream>
#include <vector>
using namespace std;

//  Definition for a binary tree node.
struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution
{
public:
    void help(TreeNode *root, string curr, vector<string> &res)
    {
        if (!root)
        {
            return;
        }

        curr = curr + (curr != "" ? "->" : "") + to_string(root->val);

        if (!root->left && !root->right)
        {
            res.push_back(curr);
            return;
        }

        help(root->left, curr, res);
        help(root->right, curr, res);
    }
    vector<string> binaryTreePaths(TreeNode *root)
    {
        vector<string> res;

        help(root, "", res);

        return res;
    }
};