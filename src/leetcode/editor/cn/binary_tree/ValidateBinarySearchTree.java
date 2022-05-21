

package leetcode.editor.cn.binary_tree;
//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。 
//
// 有效 二叉搜索树定义如下： 
//
// 
// 节点的左子树只包含 小于 当前节点的数。 
// 节点的右子树只包含 大于 当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,1,3]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [5,1,4,null,null,3,6]
//输出：false
//解释：根节点的值是 5 ，但是右子节点的值是 4 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在[1, 10⁴] 内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 1406 👎 0

import java.util.LinkedList;
import java.util.Queue;

class P98_ValidateBinarySearchTree{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P98_ValidateBinarySearchTree().new Solution();
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
    TreeNode pre = null;
    public boolean isValidBST(TreeNode root) {
        // 验证是不是二叉搜索树
        // 左节点（包括其子树）<中间结点<右节点（包括其子树）
        // 左子树所有节点小于中间节点，右子树所有节点大于中间节点
        // 这题相当于判断中序遍历二叉树的结果，是不是一个递增序列;
        // 定义一个结点，用于记录上一递归的结点，用于判断节点的值是不是递增的

        // 1.返回true or false表示该子树是不是二叉搜索树，输入参数为节点
        // 2.终止条件，当节点为空，返回true，空的时候也是二叉搜索树
        // 3.单层逻辑：用pre保存前一节点，并且遍历顺序为左中右，同时判断值是不是呈现递增

        //
        if (root == null) {
            return true;
        }
        // 左
        boolean left = isValidBST(root.left);
        // 中,如果不符合递增，则直接返回false；否则，将当前的root传给pre，进行下一递归
        if (pre != null && pre.val >= root.val) {
            return false;
        }
        pre=root;
        // 右
        boolean right = isValidBST(root.right);

        return left&&right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
