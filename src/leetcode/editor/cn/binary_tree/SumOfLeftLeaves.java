

package leetcode.editor.cn.binary_tree;
//计算给定二叉树的所有左叶子之和。 
//
// 示例： 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
//
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 392 👎 0

class P404_SumOfLeftLeaves{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P404_SumOfLeftLeaves().new Solution();
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
    public int sumOfLeftLeaves(TreeNode root) {
        // 找 左 叶子节点，叶子节点 - 左右孩子都为空
        // 前序遍历，中左右（层序遍历）；在左节点这一步，判断是不是叶子节点
        // 先做深度遍历吧，用栈左前序遍历; 标记法 -- 迭代法超时了，得用递归法 --> 是我写错了，只需要判断当前是不是左叶子节点就好

        // 迭代法
//        if (root == null) return 0;
//        Stack<TreeNode> stack = new Stack<> ();
//        stack.add(root);
//        int result = 0;
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//            if (node.left != null && node.left.left == null && node.left.right == null) {
//                result += node.left.val;
//            }
//            if (node.right != null) stack.add(node.right);
//            if (node.left != null) stack.add(node.left);
//        }
//        return result;

        // 递归
        if (root == null) {
            return 0;
        }
        int sum =0;
        return sumLeftLeaf(root,sum,false);
    }
    // 递归 - 前序遍历，
    // 类型和输入参数，左叶子节点值的和，树节点，flag标记是否为左节点
    // 终止条件，节点为空; 或者找到左叶子节点
    // 单层逻辑 - 1.中左右，
    public int sumLeftLeaf(TreeNode root,int sum, boolean flag){
        // 终止，节点为空
        if (root == null) {
            return sum;
        }
        // 是否找到叶子节点，且为左叶子节点   -- 中
        if (root.left == null && root.right == null && flag) {
            sum+= root.val;
            return sum;
        }
        // 左
        sum = sumLeftLeaf(root.left,sum,true);
        // 右
        sum = sumLeftLeaf(root.right,sum,false);
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
