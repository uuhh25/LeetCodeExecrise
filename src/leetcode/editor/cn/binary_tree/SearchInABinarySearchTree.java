

package leetcode.editor.cn.binary_tree;
//给定二叉搜索树（BST）的根节点 root 和一个整数值 val。 
//
// 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：root = [4,2,7,1,3], val = 2
//输出：[2,1,3]
// 
//
// Example 2: 
//
// 
//输入：root = [4,2,7,1,3], val = 5
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 数中节点数在 [1, 5000] 范围内 
// 1 <= Node.val <= 10⁷ 
// root 是二叉搜索树 
// 1 <= val <= 10⁷ 
// 
// Related Topics 树 二叉搜索树 二叉树 👍 237 👎 0

import java.util.Stack;

class P700_SearchInABinarySearchTree{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P700_SearchInABinarySearchTree().new Solution();
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
    public TreeNode searchBST(TreeNode root, int val) {
        // 二叉搜索树是一个有序树，所以遍历 和 普通二叉树是不同的
        // 用普通二叉树的方法
        // 迭代法 前序遍历 栈+标记法，中左右->右左中
//        if (root == null) {
//            return null;
//        }
//        Stack<TreeNode> stk = new Stack<>();
//        stk.push(root);
//        while (!stk.isEmpty()) {
//            // 标记法，给中间节点标记
//            // 看栈的出口元素，是否为空
//            TreeNode node = stk.peek();
//            if (node != null) {
//                // 遍历代码
//                stk.pop();  // 弹出栈顶元素，以免重复结点
//                if (node.right != null) {
//                    stk.push(node.right);
//                }
//                if (node.left != null) {
//                    stk.push(node.left);
//                }
//                stk.push(node);
//                stk.push(null);
//            }else {
//                // 结点操作代码
//                stk.pop();  // 弹出null
//                node=stk.pop();
//                if (node.val == val) {
//                    return node;
//                }
//            }
//        }
//        return null;

        // 二叉搜索树，左结点<中间结点<右节点，所以我们可以用递归的方式去找相同值的结点
        // 1. 返回类型为TreeNode，输入参数为结点和要找的值
        // 2. 终止条件，结点为空，或者找到相同值结点
        // 3. 单层逻辑：我们可以通过判断要找到值和根节点的值比较，确定结果是在左子树还是右子树，可以有效提升效率
        // if root.val>val  递归(root.right,val) 并且return这个返回的结点
        // if root.val<val  递归(root.left,val) 并且return这个返回的结点
        // 终止条件
        if (root == null || root.val == val) {
            return root;
        }
        // 通过值的比较，判断结果在哪个子树
        if (root.val > val) {
            return searchBST(root.left,val);
        }
        if (root.val < val) {
            return searchBST(root.right,val);
        }
        // 如果没找到，返回空
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
