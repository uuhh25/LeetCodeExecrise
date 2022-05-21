

package leetcode.editor.cn.binary_tree;
//给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。 
//
// 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层
//为第 h 层，则该层包含 1~ 2ʰ 个节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,4,5,6]
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是[0, 5 * 10⁴] 
// 0 <= Node.val <= 5 * 10⁴ 
// 题目数据保证输入的树是 完全二叉树 
// 
//
// 
//
// 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？ 
// Related Topics 树 深度优先搜索 二分查找 二叉树 👍 609 👎 0

class P222_CountCompleteTreeNodes{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P222_CountCompleteTreeNodes().new Solution();
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
    public int countNodes(TreeNode root) {
        // 这个题应该有两个方法 1. 直接遍历，计算总数 2.根据完全二叉树的特征求总数
        //1. 用层序遍历
//        Queue<TreeNode> queue = new LinkedList<>();
//        int sum=0;
//        if (root != null) {
//            queue.offer(root);
//        }
//        while (!queue.isEmpty()) {
//            // 层序遍历
//            int len= queue.size();
//            sum+=len;
//            for (int i = 0; i < len; i++) {
//                TreeNode node = queue.poll();
//                if (node.left != null) {
//                    queue.offer(node.left);
//                }
//                if (node.right != null) {
//                    queue.offer(node.right);
//                }
//            }
//        }
//        return sum;

        // 2. 用完全二叉树的特征，
        // 什么是完全二叉树：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值（度为0或2），
        // 并且最下面一层的节点都集中在该层 最左边的 若干位置
        // 完全二叉树有两种情况：1.整棵树都是满二叉树  2.最后一层叶子节点没有满
        // 第一种情况就是直接2^n -1；
        // 第二种情况：因为完全二叉树中总有 满二叉树 ，所以可以用递归去左右孩子找满二叉树，相当于是从最底层开始求和了
        /**
         完全二叉树的高度可以直接通过不断地访问左子树就可以获取
         判断左右子树的高度:
         如果相等说明左子树是满二叉树, 然后进一步判断右子树的节点数(最后一层最后出现的节点必然在右子树中)
         如果不等说明右子树是深度小于左子树的满二叉树, 然后进一步判断左子树的节点数(最后一层最后出现的节点必然在左子树中)
         **/
            if(root == null) {
                return 0;
            }
            // 相当于只遍历了 左结点 -> O(log2n)
            // 先分别求左右子树的深度
            int leftDepth = getDepth(root.left);
            int rightDepth = getDepth(root.right);
            // 判读这个根节点下的哪个孩子是满二叉树
            if (leftDepth == rightDepth) {// 左子树是满二叉树
                // 如果相等说明左子树是满二叉树, 然后进一步判断右子树的节点数(最后一层最后出现的节点必然在右子树中)
                // 2^leftDepth其实是 （2^leftDepth - 1） + 1 ，左子树 + 根结点
                return (1 << leftDepth) + countNodes(root.right);
            }else {// 右子树是满二叉树
                // 如果不等说明右子树是深度小于左子树的满二叉树, 然后进一步判断左子树的节点数(最后一层最后出现的节点必然在左子树中)
                return (1 << rightDepth) + countNodes(root.left);
            }
        }
    private int getDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            root = root.left;
            depth++;
        }
        return depth;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
