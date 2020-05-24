/* Construct Binary Search Tree from Preorder Traversal
Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.
 */

/*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    private void insert(TreeNode root, int x){
        if(x < root.val){
            if(root.left==null){
                root.left = new TreeNode(x);
            } else
            insert(root.left,x);
        } else {
            if(root.right==null){
                root.right = new TreeNode(x);
            } else
            insert(root.right,x);
        }
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for(int i=1; i < preorder.length; i++){
            insert(root, preorder[i]);
        }
        return root;
    }
}

