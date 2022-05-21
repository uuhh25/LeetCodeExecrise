

package leetcode.editor.cn.binary_tree;
//
// 
// 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则
//，返回 false 。 
//
// 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,4,5,1,2], subRoot = [4,1,2]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// root 树上的节点数量范围是 [1, 2000] 
// subRoot 树上的节点数量范围是 [1, 1000] 
// -10⁴ <= root.val <= 10⁴ 
// -10⁴ <= subRoot.val <= 10⁴ 
// 
// 
// 
// Related Topics 树 深度优先搜索 二叉树 字符串匹配 哈希函数 👍 637 👎 0


import java.util.LinkedList;
import java.util.Queue;

class P572_SubtreeOfAnotherTree{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P572_SubtreeOfAnotherTree().new Solution();
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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //
        Queue<TreeNode> que = new LinkedList<>();
        // 都为空时，直接返回true
        if (root == null && subRoot==null) {
            return true;
        }
        // root不为空，则入队
        if (root != null) {
            que.offer(root);
        }
        // 用层序遍历，找到大树中与子树根节点相同的点
        while (!que.isEmpty()) {
            int len = que.size();
            for (int i = 0; i < len; i++) {
                TreeNode tmp = que.poll();
                boolean res;
                res = compareTree(tmp,subRoot);
                if (res) {
                    return res;
                }
                if (tmp.left != null) {
                    que.offer(tmp.left);
                }
                if (tmp.right != null) {
                    que.offer(tmp.right);
                }
            }
        }
        return false;
    }
    // 写一个函数，用于判断两个子树是否相同
    public boolean compareTree(TreeNode p, TreeNode q){
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
