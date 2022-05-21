

package leetcode.editor.cn.binary_tree;
//给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [2,1,3]
//输出：[2,3,1]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1149 👎 0


class P226_InvertBinaryTree{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P226_InvertBinaryTree().new Solution();
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
    public TreeNode invertTree(TreeNode root) {
        // 这题的反转二叉树，相当于把每层的节点进行一个倒序；
        // 迭代法
            // 用层序遍历，用队列实现，让left指向 右孩子、right指向左孩子
            // 用深度遍历，前序遍历和后序遍历，用栈实现，先让left指向右，再让right指向左孩子，然后让右（左）孩子先进、左（右）孩子再进；出的时候就右孩子先出、左孩子后出了
        // 递归法：
            // 前序遍历：中左右, 先对根节点进行左右孩子互换，再进行递归？
            // 后序遍历：左右中
        // 可是怎么获得反转后的二叉树呢？ 直接对每个节点的左右指针进行修改

        // 1. 广度优先遍历 - 层序遍历
//        Queue<TreeNode> queue = new LinkedList<>();
//        if (root != null) {
//            queue.offer(root);
//        }
//        while (!queue.isEmpty()){
//            //
//            int len = queue.size();
//            for (int i = 0; i < len; i++) {
//                TreeNode node = queue.poll();
//                swap(node);
//                if (node.left != null) {
//                    queue.offer(node.left);
//                }
//                if (node.right != null) {
//                    queue.offer(node.right);
//                }
//            }
//        }
//        return root;    // 返回反转后的树

        // 2. 深度优先遍历，用栈 + 标记法实现
//        Stack<TreeNode> stk = new Stack<>();
//        // stack一般用 双端队列来实现; 好像有点问题，还是直接用stack接口吧
//        if (root != null) {
//            stk.push(root);
//        }
//        while (!stk.isEmpty()) {
//            // 用null进行标记，如果遍历到中间节点，则紧跟着添加一个null
//            // 标记法，即把遍历 和 处理给隔离开，并且对需要处理的结点进行标记
//            TreeNode node = stk.pop();  // 出栈，免得结点重复
//            if (node != null) {
//                // 结点遍历代码
//                // 不为null， 表明要入栈，前序遍历 用栈实现 则入栈顺序 中左右 -> 右左中
//                if (node.right != null) {
//                    stk.push(node.right);
//                }
//                if (node.left != null) {
//                    stk.push(node.left);
//                }
//                stk.push(node);
//                stk.push(null); // 进行标记
//            }
//            else {
//                // 结点处理代码
//                // 为null，表明下一个为中间节点，我们对该节点进行处理， 左右孩子互换
//                node = stk.pop();   // 刚才的node是null，现在直接对标记的结点进行处理
//                swap(node);
//            }
//        }
//        return root;
//    }
        // 3. 递归的方法，前序遍历 中左右-> 遍历的时候，左右孩子位置调换，所以应该是中右左
        // 递归三要素：函数的返回类型及参数，终止的条件，递归逻辑
        if (root == null) {
            return root;
            // 终止条件,当结点为空，就终止
        }

        // 前序遍历，
        swap(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;

    }
    public void swap(TreeNode node){
        TreeNode tmp = node.left;
        node.left= node.right;
        node.right=tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
