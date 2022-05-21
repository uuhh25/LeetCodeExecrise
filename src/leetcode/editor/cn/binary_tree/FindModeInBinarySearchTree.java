

package leetcode.editor.cn.binary_tree;
//给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。 
//
// 如果树中有不止一个众数，可以按 任意顺序 返回。 
//
// 假定 BST 满足如下定义： 
//
// 
// 结点左子树中所含节点的值 小于等于 当前节点的值 
// 结点右子树中所含节点的值 大于等于 当前节点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 412 👎 0

import java.util.ArrayList;
import java.util.List;
class P501_FindModeInBinarySearchTree{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P501_FindModeInBinarySearchTree().new Solution();
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
    int count=0;    // 记录当前值出现的次数
    int maxCount=0; // 记录该序列数值出现的最高频次
    List<Integer> list = new ArrayList<>(); // 用于存结果
    TreeNode pre = null;    // 记录前一节点
    public int[] findMode(TreeNode root) {
        // 找众数，如果是普通二叉树，可以用map+遍历二叉树+找最高出现频次获得结果
        // 在二叉搜索树中，鉴于它在中序遍历下呈现递增的性质，可以在遍历的过程中，计算某个值出现的频次，并且判断是否为众数
        getMode(root);
        // 把list转成array，在stream下，在mapToInt函数中 把Integet映射到intValue，然后用toArray转成数组
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    // 递归中序遍历
    // 输入参数，节点；没有返回值，依旧是对全局的遍历进行更新， 所以不用返回
    // 终止条件，节点为空
    // 单层逻辑，左中（处理代码：计算当前出现频次，判断当前是不是众数）右
    public void getMode(TreeNode root){
        // 终止条件
        if (root == null) {
            return;
        }
        // 左
        getMode(root.left);
        // 中，处理代码.1-计算出现频次
        if (pre==null){
            // 对于第一个节点
            count=1;
        } else if (pre.val == root.val) {
            // 前后值相同
            count++;
        }else {
            // 前后值不同
            count=1;
        }
        pre=root;   // 更新节点
        // 处理代码.2-判断是不是众数
        if (maxCount == count) {
            list.add(root.val);
        }
        if (maxCount < count) {
            // 发现之前存的不是众数，所以要重新复制maxCount+清空结果集，重新存结果
            list.clear();
            maxCount=count;
            list.add(root.val);
        }
        // 右
        getMode(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
