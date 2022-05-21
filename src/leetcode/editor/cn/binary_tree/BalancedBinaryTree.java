

package leetcode.editor.cn.binary_tree;
//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 878 👎 0

class P110_BalancedBinaryTree{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P110_BalancedBinaryTree().new Solution();
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
    public boolean isBalanced(TreeNode root) {
        // 平衡二叉树的特点：任意左右子树高度差不超过1
        // 应该是用递归做吧，要递归到每个根节点下的左右子树

        // 单层逻辑，对该结点下的左右孩子 求高度 ，并且判断高度差，如果差<1，则继续递归到该对应结点的左右孩子？
        // 二叉树节点的深度：指从根节点到该节点的最长简单路径边的条数。   从上到下  前序遍历
        // 二叉树节点的高度：指从该节点到叶子节点的最长简单路径边的条数。  从下到上  后序遍历
        // 高度用什么方法获得？ 用后序遍历，同时要判断该节点下是不是平衡二叉树
        int h = getHeight(root);
        return h==-1?false:true;
    }
    // 即我们递归地对左右孩子求高度，然后在主函数判断是否为平衡二叉树
    // 求高度，返回为int，返回值为任意值 或 -1（表示不是平衡二叉树，不然会浪费后面的计算）；参数为根节点 TreeNode root
    // 终止条件，节点为空，则该根节点的高度为0；
    // 单层逻辑，求当前根节点的左、右子树高度，然后判断差值，最后返回高度或-1； 并且求高度是后序遍历，左右中
    public int getHeight(TreeNode root){
        // 终止条件
        if (root == null) {
            return 0;   //
        }
        // 单层逻辑
        int leftD = getHeight(root.left);   // 左
        int rightD = getHeight(root.right); // 右
        // 如果已经不符合平衡二叉树条件，则直接返回-1，不计算后面的了
        if (leftD==-1 || rightD == -1) {
            return -1;
        }

        // 中
        // 接下来判断高度差,绝对值不超过1
        if (Math.abs(leftD - rightD) > 1) {
            return -1;
        }
        else {
            // 返回高度
            return 1 + Math.max(leftD,rightD);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
