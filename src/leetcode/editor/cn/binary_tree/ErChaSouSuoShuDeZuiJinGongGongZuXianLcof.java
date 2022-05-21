

package leetcode.editor.cn.binary_tree;
////给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。 
////
//// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能
//大（
////一个节点也可以是它自己的祖先）。” 
////
//// 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5] 
////
//// 
////
//// 
////
//// 示例 1: 
////
//// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
////输出: 6 
////解释: 节点 2 和节点 8 的最近公共祖先是 6。
//// 
////
//// 示例 2: 
////
//// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
////输出: 2
////解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。 
////
//// 
////
//// 说明: 
////
//// 
//// 所有节点的值都是唯一的。 
//// p、q 为不同节点且均存在于给定的二叉搜索树中。 
//// 
////
//// 注意：本题与主站 235 题相同：https://leetcode-cn.com/problems/lowest-common-ancestor-
//of-
////a-binary-search-tree/ 
//// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 204 👎 0
//

class ErChaSouSuoShuDeZuiJinGongGongZuXianLcof{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new ErChaSouSuoShuDeZuiJinGongGongZuXianLcof().new Solution();
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
        // 在二叉搜素树中找公共祖先，肯定要用到二叉搜索树的性质啦
        // 左子树< 中间节点 <右子树
        // 如果p、q值都大于root。val，则都在右子树；反之，都在左子树；如果一大一小，则当前节点是公共节点

        // 依旧是用递归中序遍历
        // 输入三个节点，返回一个节点
        // 终止条件，节点为空
        // 单层逻辑，根据节点值，进行左右的遍历；左中右
        if (root == null) {
            return root;
        }
        int pV=p.val;
        int qV=q.val;
        int rV= root.val;
        if (pV<rV && qV<rV){
            // 左
            TreeNode left=lowestCommonAncestor(root.left,p,q);
            return left;
        }else if ((pV>rV && qV<rV) || (pV<rV && qV>rV)){
            // 中
            return root;
        } else if (pV > rV && qV > rV) {
            TreeNode right=lowestCommonAncestor(root.right,p,q);
            return right;
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
