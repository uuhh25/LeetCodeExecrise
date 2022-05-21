

package leetcode.editor.cn.binary_tree;
//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的
//根节点的引用。 
//
// 一般来说，删除节点可分为两个步骤： 
//
// 
// 首先找到需要删除的节点； 
// 如果找到了，删除它。 
// 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：root = [5,3,6,2,4,null,7], key = 3
//输出：[5,4,6,2,null,null,7]
//解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//另一个正确答案是 [5,2,6,null,4,null,7]。
//
//
// 
//
// 示例 2: 
//
// 
//输入: root = [5,3,6,2,4,null,7], key = 0
//输出: [5,3,6,2,4,null,7]
//解释: 二叉树不包含值为 0 的节点
// 
//
// 示例 3: 
//
// 
//输入: root = [], key = 0
//输出: [] 
//
// 
//
// 提示: 
//
// 
// 节点数的范围 [0, 10⁴]. 
// -10⁵ <= Node.val <= 10⁵ 
// 节点值唯一 
// root 是合法的二叉搜索树 
// -10⁵ <= key <= 10⁵ 
// 
//
// 
//
// 进阶： 要求算法时间复杂度为 O(h)，h 为树的高度。 
// Related Topics 树 二叉搜索树 二叉树 👍 641 👎 0

class P450_DeleteNodeInABst{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P450_DeleteNodeInABst().new Solution();
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
    public TreeNode deleteNode(TreeNode root, int key) {
        // 删除二叉搜索树的节点，即要搞清楚删除后的结构应该怎么处理
        // 具体有5种情况，
        // 1.找不到要删除的节点
        // 2.删除的是叶子节点 ，之前把pre.left/pre.right=null
        // 3.删除的节点左子树空 直接把右子树填到该节点的位置 pre.left/pre.right=root.right
        // 4.删除的节点右子树空 直接把左子树填到该节点的位置 pre.left/pre.right=root.left
        // 5.删除的节点，左右子树都不为空；则删除该节点，然后将原左子树，放到右子树最左边点的left；（后序遍历第一个点）
        // 终止条件
        // 1.
        if (root == null) {
            return null;
        }
        // 中
        if (root.val == key) {
            //2.
            if (root.left == null && root.right == null) {
                return null;
            }
            //3.
            else if (root.right == null) {
                return root.left;
            }
            //4.
            else if (root.left == null) {
                return root.right;
            }
            //5.
            else {
                // 找右子树中，最左边的点
                TreeNode cur=root.right;
                while (cur.left != null) {
                    // System.out.println(cur.val);
                    cur=cur.left;
                }
                // 将原左子树，放到右子树最左边点的left
                cur.left= root.left;
                // 右子树已更新，返回root.right
                root=root.right;
                return root;
            }

        }
        // 根据二叉搜索树性质，判断值的大小，以确定更新的是哪个子树
        if (root.val>key){
            root.left=deleteNode(root.left,key);
        }
        if (root.val < key) {
            root.right=deleteNode(root.right,key);
        }

        //
        return root;
    }
    // 用递归前序遍历，中左右
    // 输入节点+key；返回对应条件节点，我们的递归函数作用就是判断该节点下面的结构是否有待删除节点，更新上一层的左右子树
    // 终止条件，节点空
    // 单层逻辑，中（处理代码）左右，
    // 具体有5种情况，
    // 1.找不到要删除的节点
    // 2.删除的是叶子节点 ，之前把pre.left/pre.right=null
    // 3.删除的节点左子树空 直接把右子树填到该节点的位置 pre.left/pre.right=root.right
    // 4.删除的节点右子树空 直接把左子树填到该节点的位置 pre.left/pre.right=root.left
    // 5.删除的节点，左右子树都不为空；则删除该节点，然后将原左子树，放到右子树最左边点的left；（后序遍历第一个点）
}
//leetcode submit region end(Prohibit modification and deletion)

}
