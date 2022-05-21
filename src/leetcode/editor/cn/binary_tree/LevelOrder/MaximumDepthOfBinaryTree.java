

package leetcode.editor.cn.binary_tree.LevelOrder;
//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1095 👎 0

import java.util.LinkedList;
import java.util.Queue;

class P104_MaximumDepthOfBinaryTree{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P104_MaximumDepthOfBinaryTree().new Solution();
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
    public int maxDepth(TreeNode root) {
        // 1. 层序遍历
        // 求深度，其实就是层序遍历的一个过程；
//        int Depth = 0;
//        Queue<TreeNode> queue = new LinkedList<>(); // 层序遍历，用队列实现
//        if (root != null) {
//            queue.offer(root);
//        }
//        // 开始遍历
//        while (!queue.isEmpty()){
//            int len = queue.size();
//            // 遍历当前层
//            while (len>0){
//                TreeNode node = queue.poll();
//                // 不需要记录值什么的，直接加入左右孩子
//                if (node.left != null) {
//                    queue.offer(node.left);
//                }
//                if (node.right != null) {
//                    queue.offer(node.right);
//                }
//                if(len==1){
//                    // 遍历到该层最后一个元素，表明结束该行遍历
//                    Depth++;
//                }
//                len--;
//            }
//        }
//        return Depth;
        return getDepth(root);
    }
    // 2.递归的方法：
    // （1 函数的返回深度，int；输入参数，因为是遍历二叉树找深度，Treenode node; public int getDepth(Treenode node)
    // (2 当左右子树都为空了，则终止  if(node.left == null && node.right==null) return depth
    // (3 单层逻辑：遍历根节点的左右子树,找出最大的depth
    public int getDepth(TreeNode node){
        //
        int depth=0;
        // 终止条件
        if (node == null) { // 中
            return depth;
        }
        // 遍历左右子树，找最大的depth
        int d1 = getDepth(node.left);   // 遍历左子树
        int d2 = getDepth(node.right);  // 遍历右子树
        depth = 1+Math.max(d1,d2);  //  先判断左子树更深还是右子树，再+1 （加1是因为算上当前中间节点）

        return depth;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
