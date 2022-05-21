

package leetcode.editor.cn.binary_tree;
//给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。 
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。 
//
// 
//
// 示例 1： 
//
// 
//输入：p = [1,2,3], q = [1,2,3]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：p = [1,2], q = [1,null,2]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：p = [1,2,1], q = [1,1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 两棵树上的节点数目都在范围 [0, 100] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 759 👎 0

class P100_SameTree{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P100_SameTree().new Solution();
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 判断两棵二叉树是否相同，1. 迭代法，中左右，同时判断 2. 同时层序遍历，然后比较每一次遍历的节点
        return compareTree(p,q);
        // 迭代法，两个queue，同时遍历两棵树; 好像不行

    }
    // 迭代法，中左右；
    // 1. 返回boolean，参数 两个节点，
    // 2. 终止条件： 1.有空节点，如果都为空则返回true，否则false；2.没有空节点，则判断值
    // 3. 递归左右节点，然后得到两个boolean，如果都为true，则返回true
    public boolean compareTree(TreeNode p,TreeNode q){
        // 终止条件, 空节点 + 没有空节点
        if (p == null && q == null) {
            return true;
        } else if (p == null && q != null) {
            return false;
        } else if (p != null && q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }
        boolean leftF = compareTree(p.left,q.left);
        boolean rightF = compareTree(p.right,q.right);
        boolean result = leftF&&rightF;
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
