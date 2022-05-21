

package leetcode.editor.cn.binary_tree;
//给定一个二叉搜索树 root (BST)，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。 
//
// 提醒一下， 二叉搜索树 满足下列约束条件： 
//
// 
// 节点的左子树仅包含键 小于 节点键的节点。 
// 节点的右子树仅包含键 大于 节点键的节点。 
// 左右子树也必须是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
//输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
// 
//
// 示例 2： 
//
// 
//输入：root = [0,null,1]
//输出：[1,null,1]
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在 [1, 100] 范围内。 
// 0 <= Node.val <= 100 
// 树中的所有值均 不重复 。 
// 
//
// 
//
// 注意：该题目与 538: https://leetcode-cn.com/problems/convert-bst-to-greater-tree/ 相同
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 150 👎 0

import java.util.Stack;

class P1038_BinarySearchTreeToGreaterSumTree{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1038_BinarySearchTreeToGreaterSumTree().new Solution();
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
    int sum=0;
    TreeNode pre;
    public TreeNode bstToGst(TreeNode root) {
        // 从二叉搜索树变成累加树
        // 1.要遍历每个点的值吧，然后在不同取值下找到对应的子结构；这太麻烦了
        // 二叉搜索树在中序遍历下就是一个递增序列，而我们要构的累加树就是 反中序遍历下的累加
        // 因此我们可以通过做 反中序遍历，并且进行对上一节点值的累加赋予给新的节点
//        getTInorderSum(root);
//        return root;

        // 迭代法，就是做一次反中序遍历
        Stack<TreeNode> stk = new Stack<>();
        if (root == null) {
            return root;
        }
        TreeNode cur=root;

        while (cur!=null || !stk.isEmpty()) {
            if (cur != null) {
                stk.push(cur);
                cur=cur.right;  // 右
            }else {
                // 中
                cur=stk.pop();
                // 当前节点的值，等于原先累加值加上当前节点值
                cur.val += sum;
                // 更新节点的累加值
                sum = cur.val;

                cur=cur.left; // 左
            }
        }
        return root;
    }
    // 递归:1.输入节点，累加用的是全局变量sum，且需要遍历整棵树，所以不用返回值
    // 2.遇到空节点就终止当前递归
    // 3.反中序遍历，右中（处理代码，进行值的累加和赋值）左
    public void getTInorderSum(TreeNode root){
        //
        if (root == null) {
            return;
        }
        // 右
        getTInorderSum(root.right);
        // 中，处理节点
//        if (pre == null) {
//            // 最初始情况
//            pre = root;
//        }
        // 计算到该节点时的累加值，然后修改当前节点的值，并且更新pre以记录上一节点(好像不需要？）
        sum+=root.val;
        root.val=sum;
        // pre=root;
        // 左
        getTInorderSum(root.left);

        // 结束所有遍历
        return;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
