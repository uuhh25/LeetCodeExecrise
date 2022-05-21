

package leetcode.editor.cn.binary_tree;
////////// 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。 
//////////
////////// 
//////////
////////// 示例 1： 
//////////
////////// 
//////////输入：root = [1,null,2,3]
//////////输出：[3,2,1]
////////// 
//////////
////////// 示例 2： 
//////////
////////// 
//////////输入：root = []
//////////输出：[]
////////// 
//////////
////////// 示例 3： 
//////////
////////// 
//////////输入：root = [1]
//////////输出：[1]
////////// 
//////////
////////// 
//////////
////////// 提示： 
//////////
////////// 
////////// 树中节点的数目在范围 [0, 100] 内 
////////// -100 <= Node.val <= 100 
////////// 
//////////
////////// 
//////////
////////// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
////////// Related Topics 栈 树 深度优先搜索 二叉树 👍 744 👎 0

import java.util.*;

class P145_BinaryTreePostorderTraversal{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P145_BinaryTreePostorderTraversal().new Solution();

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
	public List<Integer> postorderTraversal(TreeNode root) {

		// 用迭代的方法，则直接修改前序遍历的迭代方法，前序遍历是 中左右，则先改成 中右左，再反转数组，左右中
		List<Integer> list = new ArrayList<>();
		Deque<TreeNode> stk = new ArrayDeque<>();
		TreeNode cur = root;
		// 树为空
		if (root==null){
			return list;
		}

		stk.push(root);
		while (!stk.isEmpty()){
			// 即栈内始终有节点时，继续遍历
			cur = stk.pop();   // 栈的头
			list.add(cur.val);
			// 在前序遍历中，先让右孩子进栈，再让左孩子进栈；中左右
//            if (cur.right!=null){
//                stk.push(cur.right);
//            }
//            if (cur.left!=null){
//                stk.push(cur.left);
//            }
			// 而在后序遍历的 左右中，我们要获得 中右左，所以调换顺序
			if (cur.left!=null){
				stk.push(cur.left);
			}
			if (cur.right!=null){
				stk.push(cur.right);
			}
		}
		// 调转list，从中右左，变成左右中
		Collections.reverse(list);

		return list;

	}

	//递归三要素，确定递归函数的参数和返回值、确定终止的条件、确定单层递归的逻辑
	// 后序遍历，遍历顺序 左右中
	// 1. 参数是节点和用于存储二叉树结点的容器，不用返回  2. 终止条件，节点为空则终止 3. 中序遍历的逻辑是先中节点 然后左节点 再右节点
	public void traversal(TreeNode root, List<Integer> list){
		// 终止条件
		if (root == null){
			return;
		}
		// 递归逻辑，左右中
		traversal(root.left,list);
		traversal(root.right,list);
		list.add(root.val);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
