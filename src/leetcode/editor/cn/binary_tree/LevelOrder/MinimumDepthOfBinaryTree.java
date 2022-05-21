

package leetcode.editor.cn.binary_tree.LevelOrder;
//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 10⁵] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 656 👎 0


import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

class P111_MinimumDepthOfBinaryTree{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P111_MinimumDepthOfBinaryTree().new Solution();
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
    public int minDepth(TreeNode root) {
        // 依然是层序遍历，如何判断处在最低点？ 即当该节点的左右孩子都为空的时候，它就是最小深度，返回当前depth
        // 1.层序遍历是简单的方法
//        int Depth = 0;// 记录深度
//        Queue<TreeNode> queue = new LinkedList<>(); // 用linkedlist实现队列
//        if (root!=null){
//            queue.offer(root);
//        }
//        while (!queue.isEmpty()){
//            int len=queue.size();// 记录当前层节点个数
//            Depth++;    // 在这里进行+1，记录最小深度
//            while(len>0){
//                TreeNode node = queue.poll();   // 队头出队，
//                // 只用记录深度，所以下一步是添加左右孩子
//                if (node.left != null) {
//                    queue.offer(node.left);
//                }
//                if (node.right != null) {
//                    queue.offer(node.right);
//                }
//                // 判断当前是不是最小深度
//                if (node.left == null && node.right == null) {
//                    return Depth;
//                }
//                len--;
//            }
//        }
//        return Depth;
        return getMinDepth(root);
    }
    // 递归：
    // (1  因为要得到的是深度，即返回int类型； 输入参数就是二叉树的树 TreeNode public int getMinDepth(TreeNode node)
    // (2  终止条件： 后序没有其他结点； if (!node.left && !node.right) return depth
    // (3  单层逻辑：找根节点的两个子树最小深度，然后+1；即加上根节点的深度;
    // 没有考虑到的情况： 如果左、右子树直接为空，可能会直接返回空子树那一边；
    //
    public int getMinDepth(TreeNode node){
        int depth=0;
        // 终止条件
        if (node == null) {
            return depth;
        }
        //
        int leftD = getMinDepth(node.left); // 遍历左子树
        int rightD = getMinDepth(node.right);   // 遍历右子树

        // 如果有一边子树是空的情况, 深度是到最后一个叶子节点，
        if (node.left == null && node.right != null) {
            depth = 1+rightD;
            return depth;
        }
        if (node.right == null && node.left != null) {
            depth = 1+leftD;
            return depth;
        }
        // 两边子树都不为空
        depth = 1+Math.min(leftD,rightD);
        return depth;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
