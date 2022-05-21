

package leetcode.editor.cn.binary_tree;
//给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。 
//
// 差值是一个正数，其数值等于两值之差的绝对值。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [4,2,6,1,3]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：root = [1,0,48,null,null,12,49]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是 [2, 10⁴] 
// 0 <= Node.val <= 10⁵ 
// 
//
// 
//
// 注意：本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-
//nodes/ 相同 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 二叉树 👍 307 👎 0

class P530_MinimumAbsoluteDifferenceInBst{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P530_MinimumAbsoluteDifferenceInBst().new Solution();
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
    TreeNode pre=null;
    int minVal = Integer.MAX_VALUE; // 让minVal为较大的值
    public int getMinimumDifference(TreeNode root) {
        // 找二叉搜索树中的最小绝对差值
        // 可以用中序遍历来遍历二叉搜索树，因为在中序遍历下，二叉搜索树是一个递增序列
        // 可以用一个节点来记录前一节点
        getMinVal(root);
        return minVal;
    }
    // 递归中序遍历，
    // 输入参数，节点；因为我定义的是一个全局最小值变量，所以不用返回，只要在函数中更新这个变量就好
    // 终止条件，节点为空
    // 单层逻辑，左中（处理节点，判断绝对差值）右；应该是要遍历整个二叉搜索树的
    public void getMinVal(TreeNode root){
        // 终止条件
        if (root == null) {
            return;
        }
        // 左
        getMinVal(root.left);
        // 中，处理节点
        if (pre==null){
            pre=root;
        }else {
            if (Math.abs(pre.val- root.val)<minVal){
                minVal=Math.abs(pre.val- root.val);
            }
        }
        pre=root;
        // 右
        getMinVal(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
