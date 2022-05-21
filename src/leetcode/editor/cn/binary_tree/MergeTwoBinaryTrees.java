

package leetcode.editor.cn;
//给你两棵二叉树： root1 和 root2 。 
//
// 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠
//，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。 
//
// 返回合并后的二叉树。 
//
// 注意: 合并过程必须从两个树的根节点开始。 
//
// 
//
// 示例 1： 
//
// 
//输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
//输出：[3,4,5,5,4,null,7]
// 
//
// 示例 2： 
//
// 
//输入：root1 = [1], root2 = [1,2]
//输出：[2,2]
// 
//
// 
//
// 提示： 
//
// 
// 两棵树中的节点数目在范围 [0, 2000] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 870 👎 0

import java.util.LinkedList;
import java.util.Queue;

class P617_MergeTwoBinaryTrees{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P617_MergeTwoBinaryTrees().new Solution();
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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // 迭代法中，一般一起操作两个树都是使用队列模拟类似层序遍历，同时处理两个树的节点，
        // 同时对两棵树进行遍历，然后判断两个节点：
        // 如果都为null，则返回null；其中一个为null，则返回有值的节点；都有值则求和
        // return mergeNodes(root1,root2);

        // 迭代法，用层序遍历好做一点；直接在第一棵树上进行修改
        // 如果有一个为空，则直接不用运行了
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        // 两个节点放一起
        q1.offer(root1);
        q1.offer(root2);
        while (!q1.isEmpty()) {
            // 此时的两个节点肯定不为空，
            TreeNode n1 = q1.poll();
            TreeNode n2 = q1.poll();
            n1.val +=n2.val;    // 直接在第一个节点上进行修改

            // 存左、右节点
            if (n1.left != null && n2.left != null) {
                q1.offer(n1.left);
                q1.offer(n2.left);
            }
            if (n1.right != null && n2.right != null) {
                q1.offer(n1.right);
                q1.offer(n2.right);
            }
            // 因为我们是在第一个二叉树上修改的，所以如果第一个节点的左右孩子为空时，把第二个节点的左右孩子赋予第一个节点的左右孩子
            //
            if (n1.left == null && n2.left != null) {
                n1.left=n2.left;
            }
            if (n1.right == null && n2.right != null) {
                n1.right = n2.right;
            }
        }
        return root1;

    }
    // 递归： 用前序遍历，中左右
    // 1.返回一个节点，TreeNode，输入参数是两棵树的两个节点
    // 2.终止条件，返回不空的节点，如果都空，则返回第一个
    // 3.单层逻辑：判断两个节点，如果都为null，则返回null；其中一个为null，则返回有值的节点；都有值则求和
    // 然后对新的节点，用递归求该节点的左右子树递归 node.left=（root1.left,root2.left) node.right=(root1.right,root2.right)
    public TreeNode mergeNodes(TreeNode root1,TreeNode root2){
        // 终止条件，并且计算当前节点
        // 中，

        // 返回不空的节点，如果都空，则返回第一个
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        // System.out.println("root val:" + root1.val+" "+root2.val);
        // 新定义一个树，优化的话可以不定义新的树，直接在第一棵树上继续赋值
        TreeNode root = new TreeNode(root1.val+ root2.val);
        // System.out.println(root.val);
        // 递归求左右子树,左\右
        root.left = mergeNodes(root1.left, root2.left);
        root.right = mergeNodes(root1.right, root2.right);

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
