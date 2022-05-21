

package leetcode.editor.cn.binary_tree;
//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
//
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1408 👎 0

import java.util.Arrays;

class P105_ConstructBinaryTreeFromPreorderAndInorderTraversal{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P105_ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 这题和106，是一样的，只不过后序遍历该成前序遍历，修改一下前序数组的切割函数就好了
        return getTree(inorder,preorder);
    }
    // 用中序遍历 和 前序遍历 构造二叉树； 中序遍历 左中右， 前序遍历 中左右
    // 所以我们应利用两种遍历的规则，对数组进行多次切割；以还原树的每一层 ->
    // 递归 输入参数，中序数组+前序数组，题目要求是构造树，所以是返回一棵树的根节点；终止条件，为空、为叶子节点；
    // 单层逻辑： 切割的过程分为6步
    // 1. 判断当前 数组 是否为空、叶子节点
    // 2. 从后序遍历数组找到根节点，同时也是后序数组的分割点；即后序数组的最后一个
    // 3. 根据第2步得到的根节点，找到中序数组的分割点，
    // 4. 根据第3步结果，对中序数组进行切割，得到中序左数组、中序右数组
    // 5. 因为后序数组没有明确切割点，所以先去掉根节点，再根据第4步得到的中序左、右数组长度对后序数组进行切割
    // 6. 中序左数组、后序左数组；中序右数组、后序右数组 -> 进行遍历
    public TreeNode getTree(int[] inorder, int[] preorder){
        // 1.后序数组为空，则直接返回空
        if (preorder.length == 0) {
            return null;
        }
        // 2.获得中间节点
        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);    // 得到根节点
        // System.out.println(root);
        // 是否为叶子节点,而不是用左右子树来判断
        if (preorder.length==1) {
            return root;
        }
        // 3.获得中序数组的切割点
        int cutIdx=0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                cutIdx=i;
                break;
            }
        }
        //System.out.println(cutIdx);
        // 4.切割中序数组，遵循循环不变，本题保持左开右闭的原则
        // Arrays.copyOf(arr[], to_index) 不包含array[to_index]这个数
        int[] leftInorder = Arrays.copyOfRange(inorder,0,cutIdx);
        int[] rightInorder = Arrays.copyOfRange(inorder,cutIdx+1,inorder.length);
        //System.out.println(Arrays.toString(leftInorder));
        //System.out.println(Arrays.toString(rightInorder));

        // 5.用第4步得到的左右数组长度，来切割后序数组，保持左开右闭原则
        int leftLen = leftInorder.length;
        int[] leftPostorder = Arrays.copyOfRange(preorder,1,leftLen+1); // 不要第一个点，根节点；且右边要+1
        int[] rightPostorder = Arrays.copyOfRange(preorder,leftLen+1,preorder.length); // 因为左数组的右边界+1了，所以右数组的左边界也要+1
        //System.out.println(Arrays.toString(leftPostorder));
        //System.out.println(Arrays.toString(rightPostorder));

        // 6.将得到的左右数组，继续进行遍历，构造下层的二叉树
        TreeNode leftR = getTree(leftInorder,leftPostorder);
        TreeNode rightR = getTree(rightInorder,rightPostorder);
        root.left=leftR;
        root.right=rightR;

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
