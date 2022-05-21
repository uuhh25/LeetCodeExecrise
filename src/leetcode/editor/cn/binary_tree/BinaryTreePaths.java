

package leetcode.editor.cn.binary_tree;
//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。 
//
// 叶子节点 是指没有子节点的节点。 
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：["1"]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 100] 内 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 字符串 回溯 二叉树 👍 641 👎 0
import java.util.ArrayList;
import java.util.List;

class P257_BinaryTreePaths{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P257_BinaryTreePaths().new Solution();
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
    public List<String> binaryTreePaths(TreeNode root) {
        // 获取所有路径，即我们做前序遍历，并且用一个List，来保存经过的路径
        // 标记法做前序遍历,stack;两个栈，一个装结点，一个装当前路径
        // 前序遍历 中左右 -> 入栈 右左中
//        Stack<TreeNode> NodeStk = new Stack<>();
//        Stack<String> PathStk = new Stack<>();
        // java可以用一个stack完成
//        Stack<Object> stk = new Stack<>();
//        List<String> list = new ArrayList<>();
//        if (root != null) {
//            //
//            stk.push(root);
//            stk.push(String.valueOf(root.val)+"");
//        }
//        while (!stk.isEmpty()) {
//            // 找根节点到叶子节点的路径
//            // 根据不同object，取值
//            TreeNode node = (TreeNode) stk.pop();
//            String path = (String) stk.pop();
//            if (node.left == null && node.right == null) {
//                // 如果是叶子节点,则当前路径结束
//                list.add(path);
//            }
//            if (node.right != null) {   //右
//                stk.push(node.right);
//                // 保留前面的路径
//                stk.push(path+"->"+String.valueOf(node.right.val));
//            }
//            if (node.left != null) {   //左
//                stk.push(node.left);
//                // 保留前面的路径
//                stk.push(path+"->"+String.valueOf(node.left.val));
//            }
//        }
//        return list;
        List<Integer> paths = new ArrayList<>();
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        getPaths(root,paths,res);
        return res;
    }
    // 递归做法怎么做？
    // 1.不需要返回，只需要把res 这个list填完，同时我们再用一个list存经过的节点值，输入参数还有节点
    // 2.终止条件，当遇到叶子节点，则当前路径结束，将当前路径处理完，放入res这个list
    // 3.单层逻辑，如果遇到叶子节点，则记录当前路径；否则不停地递归遍历左右孩子，并且做回溯(因为递归到叶子节点后，要把它pop)
    public void getPaths(TreeNode root,List<Integer> paths, List<String>res){
        // 要先把当前节点给加入到paths
        paths.add(root.val);
        // 终止条件
        if (root.left == null && root.right == null) {
            // 叶子节点
            StringBuilder path = new StringBuilder();
            for (int i = 0; i < paths.size(); i++) {
                if (i==paths.size()-1){
                    // 最后一个节点不需要加 ->
                    path.append(paths.get(i));
                }else {
                    path.append(paths.get(i)).append("->");
                }
            }
            res.add(new String(path));
            return; //结束当前递归
        }

        // 单层逻辑
        if (root.left != null) {
            getPaths(root.left,paths,res);
            // 回溯，去掉当前叶子节点，返回到当前叶子节点的根节点
            paths.remove(paths.size()-1);
        }
        if (root.right != null) {
            getPaths(root.right,paths,res);
            // 回溯，去掉当前叶子节点，返回到当前叶子节点的根节点
            paths.remove(paths.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
