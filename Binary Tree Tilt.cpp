#include <iostream>
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
    int help(TreeNode *root, int &tilt)
    {
        if (!root)
            return 0;

        int leftTilt = help(root->left, tilt);
        int rightTilt = help(root->right, tilt);

        tilt += abs(leftTilt - rightTilt);

        return root->val + leftTilt + rightTilt;
    }

    int findTilt(TreeNode *root)
    {
        int tilt = 0;
        help(root, tilt);

        return tilt;
    }
};