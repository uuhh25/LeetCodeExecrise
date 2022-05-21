

package leetcode.editor.cn.binary_tree;
//给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。修剪树 不
//应该 改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在 唯一的答案 。 
//
// 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,0,2], low = 1, high = 2
//输出：[1,null,2]
// 
//
// 示例 2： 
//
// 
//输入：root = [3,0,4,null,2,null,null,1], low = 1, high = 3
//输出：[3,2,null,1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数在范围 [1, 10⁴] 内 
// 0 <= Node.val <= 10⁴ 
// 树中每个节点的值都是 唯一 的 
// 题目数据保证输入是一棵有效的二叉搜索树 
// 0 <= low <= high <= 10⁴ 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 472 👎 0

class P669_TrimABinarySearchTree{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P669_TrimABinarySearchTree().new Solution();
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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        // 首先，因为要修剪二叉搜索树，所以是要遍历所有的节点的；同时，还对需要修剪的节点进行处理，所以用递归的话，是要返回节点的
        // 其次，应该还是用前序遍历进行递归，方便返回上层进行更新；
        // 单层逻辑，判断当前节点值是否在范围内，如果在，则左右；不在范围内，则判断是留下哪一边子树；
        // 1.叶子节点，则直接返回null
        // 2.两边都不为空，则判断是不符合哪个边界条件，返回相反方向的子树
        // 3.先判断不符合哪个边界条件，然后返回相反方向子树
        // 2.3. 似乎是同样的判断逻辑
        // 4.
        // 递归1.输入节点，两个边界值
        // 终止条件，节点为空，返回null
        // 单层逻辑，中（处理代码）左右（不用根据值大小判断去哪一侧吧

        //
        if (root == null) {
            return null;
        }
        // 中，如果不在范围内
        if (!(root.val<=high && root.val>=low)){
            // 1.表明删除的是一个叶子节点，直接给上层返回null
            if (root.left == null && root.right == null) {
                return null;
            }
            // 2.表明这个值，包括右子树都不符合范围；那么如何判断左子树符合范围呢？
            else if (root.val>high){
                // 只剩下左子树可以符合，所以对左子树进行修剪,并且返回修建后的左子树作为新的节点
                return trimBST(root.left,low,high);
            }
            // 3.表明这个值，包括左子树都不符合范围；那么如何判断右子树符合范围呢？
            else if (root.val<low) {
                // 只剩下右子树可以符合，所以对右子树进行修剪,并且返回修建后的右子树作为新的节点
                return trimBST(root.right,low,high);
            }
        }
        // 左右
        root.left=trimBST(root.left,low,high);
        root.right=trimBST(root.right,low,high);
        //
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
