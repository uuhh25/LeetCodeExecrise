package leetcode.editor.cn.binary_tree;
//144
//二叉树的前序遍历
//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 717 👎 0

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Deque;
class BinaryTreePreorderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreePreorderTraversal().new Solution();
        
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
    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        traversal(root,list);
//        return list;

        // 迭代法，用栈先进后出的特性，让右孩子先进栈
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        if (root==null){
            return list;
        }
        stack.push(root);
        // 栈若不为空，则继续遍历；
        while (!stack.isEmpty()){
            // 从根节点开始
            TreeNode node = stack.peek();
            stack.pop();    // 弹出节点
            list.add(node.val); // 把当前节点值存入res
            // 先存右孩子入栈
            if (node.right !=null ){
                stack.push(node.right);
            }
            // 再存左孩子入栈
            if (node.left !=null ){
                stack.push(node.left);
            }
        }
        return list;
    }
    //递归三要素，确定递归函数的参数和返回值、确定终止的条件、确定单层递归的逻辑
    // 前序遍历，遍历顺序 中左右
    // 1. 参数是节点和用于存储二叉树结点的容器，不用返回  2. 终止条件，节点为空则终止 3. 中序遍历的逻辑是先中节点 然后左节点 再右节点
    public void traversal(TreeNode root, List<Integer> list){
        // 终止条件
        if (root == null){
            return;
        }
        // 递归逻辑，中左右
        list.add(root.val);
        traversal(root.left,list);
        traversal(root.right,list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}