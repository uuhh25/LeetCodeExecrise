

package leetcode.editor.cn.binary_tree.LevelOrder;
//给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。 
//
// 
//
// 示例1： 
//
// 
//
// 
//输入: root = [1,3,2,5,3,null,9]
//输出: [1,3,9]
// 
//
// 示例2： 
//
// 
//输入: root = [1,2,3]
//输出: [1,3]
// 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点个数的范围是 [0,10⁴] 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 166 👎 0

import java.util.*;

class P515_FindLargestValueInEachTreeRow{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P515_FindLargestValueInEachTreeRow().new Solution();
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
    // 找出每一层的最大值，那就先层序遍历，然后对每一层对应的数组进行一个排序？
    public List<Integer> largestValues(TreeNode root) {
        // 用于存每层的最大值
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>(); // 用LinkedList实现的队列完成广度优先遍历
        if (root!=null){
            queue.offer(root);
        }
        // 开始逐层遍历
        while (!queue.isEmpty()){
            // tmp
            List<Integer> tmpList = new ArrayList<>();
            int len = queue.size(); // 当前层的节点个数
            int max = 0;
            while (len>0){
                TreeNode node = queue.poll();   // 出队，遍历；以免有重复节点
                // 找该层最大值
                tmpList.add(node.val);
                // 先进左孩子，再进右孩子 <- 队列先进先出
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
                len--;
            }
            // 直接用Collection接口方法
            list.add(Collections.max(tmpList));
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
