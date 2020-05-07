/* Cousins in Binary Tree

In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.
Note:

  1. The number of nodes in the tree will be between 2 and 100.
  2. Each node has a unique integer value from 1 to 100.

 */

/*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean same_parent = false;
            boolean same_level = false;
            for(int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if(temp == null) {
                    same_parent = false;
                } else {
                    if(temp.val == x || temp.val == y) {
                        if(!same_level) {
                            same_level = true;
                            same_parent = true;
                        } else {
                            return !same_parent;
                        }
                    }
                    if(temp.left != null) queue.offer(temp.left);
                    if(temp.right != null) queue.offer(temp.right);
                    queue.offer(null);
                }
            }
            if(same_level) return false;
        }
        return false;
    }
}
