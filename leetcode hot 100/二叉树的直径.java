//题目：
//给你一棵二叉树的根节点，返回该树的 直径 。
//二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
//两节点之间路径的 长度 由它们之间边数表示。



//核心思路：
//- 定义一个全局变量maxdistance，用来记录二叉树的直径
//- 定义一个函数depth，用来计算以root为根节点的二叉树的深度
//- 首先判断root是否为空，如果为空，则返回0
//- 否则，计算左子树的深度和右子树的深度，并记录最大的深度
//- 然后返回左右子树的最大深度加1
//- 最后返回二叉树的直径，即maxdistance减1


/**
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
class Solution
{
    int maxdistance;
    public int diameterOfBinaryTree(TreeNode root)
    {
        maxdistance = 1;
        depth(root);
        return (maxdistance - 1);
    }

    public int depth(TreeNode root)
    {
        if(root == null)
        {
            return  0;
        }
        int left = depth(root.left);
        int right = depth(root.right);

        maxdistance = Math.max(maxdistance,left+right+1);

        return Math.max(left,right) + 1;
    }
}