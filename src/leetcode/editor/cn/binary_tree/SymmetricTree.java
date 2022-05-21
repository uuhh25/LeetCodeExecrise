

package leetcode.editor.cn.binary_tree;
//给你一个二叉树的根节点 root ， 检查它是否轴对称。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,null,3,null,3]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1717 👎 0

import java.util.*;

class P101_SymmetricTree{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P101_SymmetricTree().new Solution();
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
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
class Solution {
    public boolean isSymmetric(TreeNode root) {
        // 本题最关键是 思路和终止条件的判断

        // 思路：对称二叉树，其实就是根节点下的左右子树相互反转->即我们只用比较根节点的左右子树是否为相互反转字数
        // 对比规则：用左子树的左孩子 与 右子树的右孩子比较；左子树的右孩子 与 右子树的左孩子
        // 对于左子树：左右中、右子树：右左中
        // return compareTree(root.left, root.right);

        // 迭代怎么做 广度优先、深度优先； 也是去匹配两个子树
        // 我们把对应左右结点的 左孩子和右孩子、右孩子和左孩子 当前一组数据，
        // 每次比较则从队列、栈中取出两个；根据匹配的规则进行条件判断
        Queue<TreeNode> queue=new LinkedList<>();
        // 把左右子树放入队列中
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            // 取出一组对应的结点
            TreeNode tmpLeft = queue.poll();
            TreeNode tmpRight = queue.poll();

            // 进行条件的判断
            // 结点为空、不为空
            //1.
            if (tmpLeft == null && tmpRight == null) {
                continue;
                // 都为空，肯match
            }

            //
            if (tmpLeft==null || tmpRight==null || tmpRight.val!=tmpLeft.val){
                return false;
                // 左为空 右不为空； 左不为空 右为空； 左右都不为空 但是值不相同
            }
            // 按照一组一组，将结点入队
            queue.offer(tmpLeft.left);
            queue.offer(tmpRight.right);

            queue.offer(tmpLeft.right);
            queue.offer(tmpRight.left);
        }
        // 如果遍历完了，还没有return false
        return true;
    }


    // 递归方法，1. 函数的返回值是boolean，表明是否对称；参数是根节点的两个子树
    // 2.终止条件：
    //  (1)为空的情况 左为空、右不为空，返回false；左不为空、右为空，返回false；左右都为空，返回true
    //  (2)不为空的情况，则用结点的值进行判断，
    // 3.单层逻辑，对于左子树：左右中、右子树：右左中
    public boolean compareTree(TreeNode left,TreeNode right){
        // 终止条件
        // 首先排除空节点的情况
        if (left == null && right != null) {
            return false;
        } else if (left != null && right == null) {
            return false;
        } else if (left == null && right == null) {
            return true;
        }// 然后排除不为空，值不同的情况
        else if (left.val != right.val) {
            return false;
        }
        // 此时就是：左右节点都不为空，且数值相同的情况
        // 此时才做递归，做下一层的判断
        // 左子树 左右中 右子树 右左中
        boolean outside = compareTree(left.left,right.right);
        boolean inside = compareTree(left.right, right.left);

        // 内外侧都匹配的情况下，才为true
        boolean flag=outside&&inside;
        return flag;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
