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
    TreeNode *help(TreeNode *root, int &sum)
    {
        if (!root)
            return root;

        help(root->right, sum);
        sum += root->val;
        root->val = sum;
        help(root->left, sum);

        return root;
    }

    TreeNode *bstToGst(TreeNode *root)
    {
        int sum = 0;
        return help(root, sum);
    }
};