

package leetcode.editor.cn.binary_tree;
//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
// 
//
// 示例 2: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉树中。 
// 
//
// 注意：本题与主站 236 题相同：https://leetcode-cn.com/problems/lowest-common-ancestor-of-
//a-binary-tree/ 
// Related Topics 树 深度优先搜索 二叉树 👍 375 👎 0

class ErChaShuDeZuiJinGongGongZuXianLcof{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new ErChaShuDeZuiJinGongGongZuXianLcof().new Solution();
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 找祖先，自然是后序遍历（回溯）最合适；如果判断是不是公共祖先，判断某个节点的左右子树情况，
        // 找指定节点的公共祖先，相当于找一个节点的左右子树中是否存在p、q；或者同时存在与某一子数中
        // 所以遇到节点为空、节点为p、q的情况都要返回
        // 递归，后序遍历
        // 输入参数，节点，两个指定节点；返回节点
        // 终止条件，节点为空；节点为p/q
        // 单层逻辑  左右中（处理代码，对两个左右的返回节点进行条件判断，判断哪个是公共节点
        //
        if (root == null || root == p || root == q) {
            return root;
        }
        // 左右中
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        // 对左右子树的返回进行条件判断
        if (left==null && right==null){
            return null;
        }else if (left==null && right!=null){
            return right;
        }else if (left!=null && right==null){
            return left;
        }else {
            // left!=null right!=null
            return root;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
