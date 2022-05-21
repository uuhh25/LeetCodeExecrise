

package leetcode.editor.cn.binary_tree.LevelOrder;
//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
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
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 1159 👎 0
import java.util.*;

class P102_BinaryTreeLevelOrderTraversal{
	public static void main(String[] args) {
		//测试代码
		Solution solution = new P102_BinaryTreeLevelOrderTraversal().new Solution();
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
	// 逐层，从左到右访问
	// 返回的结果是list套list，即每一层都放在同一个list中
    public List<List<Integer>> levelOrder(TreeNode root) {
    	// 用 先进先出 队列实现广度优先遍历
		Queue<TreeNode> queue = new LinkedList<>();	// 用链表实现 单端队列
		List<List<Integer>> list = new ArrayList<>();
		if (root!=null) {
			queue.offer(root);
		}

		while (!queue.isEmpty()){
			List<Integer> list_in = new ArrayList<>();
			// len 表示的是当前这层有几个节点
			int len = queue.size();

			while (len > 0) {
				TreeNode node = queue.poll();	// 获取队头，先进先出
				list_in.add(node.val);

				// 从左到右遍历，所以是先左孩子再右孩子
				if (node.left!=null){
					queue.offer(node.left);
				}
				if (node.right!=null){
					queue.offer(node.right);
				}
				len--;
			}
			list.add(list_in);
		}
		return list;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
