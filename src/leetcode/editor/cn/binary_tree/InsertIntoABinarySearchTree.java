

package leetcode.editor.cn.binary_tree;
//给定二叉搜索树（BST）的根节点 root 和要插入树中的值 value ，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原
//始二叉搜索树中的任意节点值都不同。 
//
// 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [4,2,7,1,3], val = 5
//输出：[4,2,7,1,3,5]
//解释：另一个满足题目要求可以通过的树是：
//
// 
//
// 示例 2： 
//
// 
//输入：root = [40,20,60,10,30,50,70], val = 25
//输出：[40,20,60,10,30,50,70,null,null,25]
// 
//
// 示例 3： 
//
// 
//输入：root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
//输出：[4,2,7,1,3,5]
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数将在 [0, 10⁴]的范围内。 
// -10⁸ <= Node.val <= 10⁸ 
// 所有值 Node.val 是 独一无二 的。 
// -10⁸ <= val <= 10⁸ 
// 保证 val 在原始BST中不存在。 
// 
// Related Topics 树 二叉搜索树 二叉树 👍 260 👎 0

class P701_InsertIntoABinarySearchTree{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P701_InsertIntoABinarySearchTree().new Solution();
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 对二叉搜索树插入节点，同样可以根据二叉搜索树的性质来完成，左子树<中间节点<右子树
        // 通过比较值的大小，找到一个null的位置，把节点插进去
        // 最后返回root，所以需要用一个新的指针，改变root
//        TreeNode cur=root;
//        TreeNode inNode=new TreeNode(val);
//        if (root == null) {
//            return inNode;
//        }
//
//        while (true){
//            // 一直遍历二叉树，直到遍历完或者插入节点
//            if (val>cur.val){
//                // 找到一个null的位置插入,否则继续遍历
//                if (cur.right == null) {
//                    cur.right=inNode;
//                    return root;
//                }else {
//                    cur=cur.right;
//                }
//            }
//            else if (val<cur.val){
//                // 找到一个null的位置插入,否则继续遍历
//                if (cur.left == null) {
//                    cur.left=inNode;
//                    return root;
//                }else {
//                    cur=cur.left;
//                }
//            }else {
//                // 如果存在相等，直接break
//                break;
//            }
//        }
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode cur=root;
        insert(cur,val);
        return root;
    }
    // 递归法，相当于不停的找左右子树中 符合条件的空位置
    // 输入参数，节点和值，不用返回吧;直接更新二叉树结构
    // 终止，节点为空
    // 单层逻辑，如果当前值比val大，则说明去左子树找位置；反之，去右子树找位置
    // 值的判断，val>root.val 或 val<root.val，则插入到对应的root.right，root.left
    public TreeNode insert(TreeNode root,int val){
        //
        if (root == null) {
            root=new TreeNode(val);
            return root;
        }
        //
        if (root.val > val) {
            root.left=insert(root.left,val);
        }
        if (root.val < val) {
            root.right=insert(root.right,val);
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
