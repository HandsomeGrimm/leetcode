package 二叉树深度;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *    3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 */
public class Solution {
    public  int maxDepth(TreeNode root) {
        return hasNextNode(root,1);
    }


    public static int hasNextNode(TreeNode node,int depth){
        if (node.left==null&&node.right==null){
            return depth;
        }
        if (node.left!=null&&node.right==null){
            return hasNextNode(node.left,depth+1);
        }
        if (node.left==null&&node.right!=null){
            return hasNextNode(node.right,depth+1);
        }
        return Math.max(hasNextNode(node.left,depth+1),hasNextNode(node.right,depth+1));
    }




}
