#include "base_include.h"
#include "tree_node.h"

class BinaryTreeInorderTraversal {
public:
    vector<int> inorderTraversal(TreeNode *root) {
        vector<int> res;
        for (TreeNode *curr = root; curr != nullptr; ) {
            if (nullptr == curr->left) {
                res.push_back(curr->val);
                curr = curr->right;
                continue;
            }
            TreeNode *post = curr->left;
            for ( ; post->right != nullptr && post->right != curr; post = post->right) {}
            if (nullptr == post->right) {
                post->right = curr;
                curr = curr->left;
            } else {
                res.push_back(curr->val);
                post->right = nullptr;
                curr = curr->right;
            }
        }
        return res;
    }
};

int main(int argc, char *argv[]) {
    return 0;
}
