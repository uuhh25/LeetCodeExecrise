

package leetcode.editor.cn.binary_tree;
//给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和
// targetSum 。如果存在，返回 true ；否则，返回 false 。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
//输出：true
//解释：等于目标和的根节点到叶节点路径如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,3], targetSum = 5
//输出：false
//解释：树中存在两条根节点到叶子节点的路径：
//(1 --> 2): 和为 3
//(1 --> 3): 和为 4
//不存在 sum = 5 的根节点到叶子节点的路径。 
//
// 示例 3： 
//
// 
//输入：root = [], targetSum = 0
//输出：false
//解释：由于树是空的，所以不存在根节点到叶子节点的路径。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 774 👎 0

import java.util.Stack;

class P112_PathSum{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P112_PathSum().new Solution();
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // 即遍历每个叶子节点，再判断条件；可选择用前序遍历，中左右
        // 难的做法： 怎么判断该路径是否满足 和 为targetSum呢？ 做减法（需要回溯），当最终targetSum为0则返回true；否则返回false
        // 简单的做法：直接迭代法，做深度遍历求和；在遍历的时候，还要计算路径和
        Stack<TreeNode> stk = new Stack<>();  //
        Stack<Integer> stk2 = new Stack<>();
        if (root == null) {
            return false;
        }
        stk.push(root);
        stk2.push(root.val);
        while (!stk.isEmpty()) {
            // 如果为叶子节点，则判断和正不正确
            TreeNode node = stk.pop();
            int sum = stk2.pop();

            if (node.left == null && node.right == null && sum == targetSum) {
                return true;
            }
            // 右 左
            if (node.right != null) {
                stk.push(node.right);
                stk2.push(node.right.val+sum);
            }
            if (node.left != null) {
                stk.push(node.left);
                stk2.push(node.left.val+sum);
            }

        }
        return false;

        // 迭代 - 标记法前序遍历，到叶子节点则判断当前路径和是否合理
//        if (root == null) {
//            return false;
//        }
//        return isSum(root,targetSum- root.val);
    }
    // 递归,用前序遍历做，因为没有中间节点的处理，所以三种遍历都可以
    // 1. 如果有一条路径符合，直接结束返回true，即类型为 boolean；参数节点、当前targetSum的值
    // 2. 终止条件，当遇到叶子节点，则当前路径结束，判断targetSum；中左右，应该是要回溯
    // 3. 单层逻辑，我们的递归函数是返回true 和 false，可以根据返回的结果来进行return
    public boolean isSum(TreeNode root,int targetSum){
        // 终止条件
        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                return true;
            }else {
                return false;
            }
        }
        // 单层逻辑，左、右
//        if (root.left != null) {
//            // 这里包含了回溯的过程
//            boolean res = isSum(root.left,targetSum- root.left.val);
//            if (res) {
//                return true;
//            }
//        }
//        if (root.right != null) {
//            // 这里包含了回溯的过程
//            boolean res = isSum(root.right,targetSum- root.right.val);
//            if (res) {
//                return true;
//            }
//        }
        if (root.left != null) {
            // 回溯的全程,即如果该路径不满足，则换一个路径
            targetSum-= root.left.val;
            boolean res = isSum(root.left,targetSum);
            targetSum+= root.left.val;
            if (res) {
                return true;
            }
        }
        if (root.right != null) {
            // 回溯的全程
            targetSum-= root.right.val;
            boolean res = isSum(root.right,targetSum);
            targetSum+= root.right.val;
            if (res) {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
