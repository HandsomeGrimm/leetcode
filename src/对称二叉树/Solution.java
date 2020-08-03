package 对称二叉树;

import java.sql.SQLOutput;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *      1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 */
public class Solution {

    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }

    //递归思想
    public static boolean isMirror(TreeNode lp,TreeNode rp){
        if (lp==null&&rp==null){
            return true;
        }

        if (lp==null||rp==null){
            return false;
        }

        if (lp.val==rp.val){
            return isMirror(lp.left,rp.right)&&isMirror(lp.right,rp.left);
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(2);
        t1.left=t2;
        t1.right=t3;
        TreeNode t4=new TreeNode(3);
        TreeNode t5=new TreeNode(4);
        TreeNode t6=new TreeNode(4);
        TreeNode t7=new TreeNode(3);
        t2.left=t4;
        t2.right=t5;
        t3.left=t6;
        t3.right=t7;

        System.out.println(isSymmetric(t1));
    }

}
