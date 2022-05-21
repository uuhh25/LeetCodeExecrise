

package leetcode.editor.cn.binary_tree.LevelOrder;
//给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。 
//
// 
//
// 示例 1： 
//
// 输入：
//    3
//   / \
//  9  20
//    /  \
//   15   7
//输出：[3, 14.5, 11]
//解释：
//第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
// 
//
// 
//
// 提示： 
//
// 
// 节点值的范围在32位有符号整数范围内。 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 306 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class P637_AverageOfLevelsInBinaryTree{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P637_AverageOfLevelsInBinaryTree().new Solution();
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
    // 直接用队列做层序遍历，然后计算每一行的元素和，进行平均值计算
    public List<Double> averageOfLevels(TreeNode root) {
        //
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>(); // 用linkedlist实现queue
        if (root!=null){
            queue.offer(root);
            // 排除树为空的情况
        }
        // 层序遍历 + 队列；首先是根节点先进，然后pop，让该根节点对应的左孩子先进，右孩子再进
        while (!queue.isEmpty()){
            double sum = 0.0; // 用于求和，用double类型 而不是int，就能够避免除的时候的问题了
            int len=queue.size();   // 当前层的节点个数
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                sum+=node.val;
                // 左右孩子入队
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
            //
            list.add(sum/len);
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
