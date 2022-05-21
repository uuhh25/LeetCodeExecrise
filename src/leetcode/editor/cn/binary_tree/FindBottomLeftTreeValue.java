

package leetcode.editor.cn.binary_tree;
//给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。 
//
// 假设二叉树中至少有一个节点。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [2,1,3]
//输出: 1
// 
//
// 示例 2: 
//
// 
//
// 
//输入: [1,2,3,4,null,5,6,null,null,7]
//输出: 7
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [1,10⁴] 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 237 👎 0

class P513_FindBottomLeftTreeValue{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P513_FindBottomLeftTreeValue().new Solution();
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
    // 顶一个两个全局变量，用于记录深度和最左节点的值
    int maxH = -1;
    int leftV = 0;
    public int findBottomLeftValue(TreeNode root) {
        // 找最低、最左的节点，不就是层序遍历的最后一层第一个节点 (一开始理解错意思了，以为是找最左的叶子节点)
        // 就在最后一层的第一个
        //
//        Queue<TreeNode> queue = new LinkedList<>();
//        if (root != null) {
//            queue.offer(root);
//        }
//        // 定义一个暂存节点
//        TreeNode tmpNode = null;
//        while (!queue.isEmpty()) {
//            // 开始层序遍历,
//            int len = queue.size();
//            for (int i = 0; i < len; i++) {
//                TreeNode node = queue.poll();
//                if (i == 0) {
//                    tmpNode=node;
//                }
//                // 左节点
//                if (node.left != null) {
//                    queue.offer(node.left);
//                }
//                // 右节点
//                if (node.right != null) {
//                    queue.offer(node.right);
//                }
//            }
//        }
//        return tmpNode.val;
        // 递归法
        leftV= root.val;
        findLeftValue(root,0);
        return leftV;
    }
    // 递归法怎么做
    // 左下角的节点 -> 最后一行，最左边的节点 -> 深度最大的叶子节点 + 前序遍历 中左右
    // 即可以转变成，我们计算节点的深度，并且只记录相同深度的第一个节点值
    // 1.递归函数返回类型 因为我们要遍历整棵树，所以不用返回void、参数 节点、当前深度
    // 2.终止条件，当找到叶子节点的时候，我们就更新深度 和 暂存的左下角节点值
    // 3.单层逻辑，我们要找最左的节点，很明显用前序或者后序遍历 中左右、左右中；
    public void findLeftValue(TreeNode root,int leftH){
        // 前序遍历，中左右
        // 终止条件
        if (root.left == null && root.right == null) {
            // 如果是叶子节点，更新深度和当前值
            if (leftH>maxH){
                // 用>，只记录同一深度的第一个叶子节点的值
                maxH = leftH;
                leftV = root.val;
            }
        }
        // 左、右
        if (root.left != null) {
            leftH++;
            findLeftValue(root.left,leftH);
            leftH--;    // 回溯，即回到当前的根节点
        }
        if (root.right != null) {
            leftH++;
            findLeftValue(root.right,leftH);
            leftH--;    // 回溯，即回到当前的根节点
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
