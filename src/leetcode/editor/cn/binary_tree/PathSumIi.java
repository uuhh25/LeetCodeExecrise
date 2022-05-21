

package leetcode.editor.cn.binary_tree;
//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,3], targetSum = 5
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点总数在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
// 
// 
// Related Topics 树 深度优先搜索 回溯 二叉树 👍 665 👎 0
import java.util.ArrayList;
import java.util.List;
class P113_PathSumIi{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P113_PathSumIi().new Solution();
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
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // 这道题是要返回所有的路径，即如果用递归，函数无返回值，要遍历所有节点
        // 用前序遍历做
        if (root == null) {
            return list;
        }
        List<Integer> path = new ArrayList<>();
        // 首先要把根节点放入路径
        path.add(root.val);
        isSum(root,targetSum- root.val,path);
        return list;
    }
    // 递归，参数为输入的节点和当前的targetSum,还有用于存储当前路径的数组
    // 终止条件，遇到叶子节点，如果targetSum此时为0，则将当前路径存入list
    // 单层逻辑：前序遍历，中左右；要对count、path进行回溯
    public void isSum(TreeNode root, int count, List<Integer> path){
        // 终止条件,遇上叶子节点
        if (root.left == null && root.right == null) {
            if (count == 0) {
                // System.out.println(path);
                // 直接把path加进去会有问题，需要重新定义一个数组
                list.add(new ArrayList<>(path));
            }
            return;
        }
        // 左右
        if (root.left != null) {
            // 两个回溯过程
            count -= root.left.val;
            path.add(root.left.val);
            isSum(root.left,count,path);
            count += root.left.val;
            path.remove(path.size()-1); //去掉最后一个，即刚才加入的root.left.val
        }
        if (root.right != null) {
            // 两个回溯过程
            count -= root.right.val;
            path.add(root.right.val);
            isSum(root.right,count,path);
            count+= root.right.val;
            path.remove(path.size()-1); //去掉最后一个，即刚才加入的root.right.val
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
