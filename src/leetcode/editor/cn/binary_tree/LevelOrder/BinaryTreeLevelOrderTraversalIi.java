

package leetcode.editor.cn.binary_tree.LevelOrder;
//给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[15,7],[9,20],[3]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 527 👎 0

import java.util.*;

class P107_BinaryTreeLevelOrderTraversalIi{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P107_BinaryTreeLevelOrderTraversalIi().new Solution();
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
    // 要完成自底向上的层序遍历 即 从下到上、从左到右
    // 不就是把 自上而下的 层序遍历结果进行反转吗？
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if (root!=null){
            que.offer(root);
        }
        while (!que.isEmpty()){
            //
            List<Integer> tmpList = new ArrayList<>();
            int len = que.size();
            while (len > 0) {
                // 先进先出
                TreeNode node = que.poll(); //
                tmpList.add(node.val);
                // 从左到右
                if (node.left!=null){
                    que.offer(node.left);
                }
                if (node.right!=null){
                    que.offer(node.right);
                }
                len--;  // 该层节点数
            }
            list.add(tmpList);
        }
        // 反转list，原为从上到下，从左到右；这个题要从下到上，从左到右；
        // 用接口的 reverse方法
        Collections.reverse(list);
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
