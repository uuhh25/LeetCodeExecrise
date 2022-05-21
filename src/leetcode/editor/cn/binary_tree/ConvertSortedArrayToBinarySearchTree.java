

package leetcode.editor.cn.binary_tree;
//给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。 
//
// 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-10,-3,0,5,9]
//输出：[0,-3,9,-10,null,5]
//解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
//
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,3]
//输出：[3,1]
//解释：[1,3] 和 [3,1] 都是高度平衡二叉搜索树。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 按 严格递增 顺序排列 
// 
// Related Topics 树 二叉搜索树 数组 分治 二叉树 👍 942 👎 0

class P108_ConvertSortedArrayToBinarySearchTree{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P108_ConvertSortedArrayToBinarySearchTree().new Solution();
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
    public TreeNode sortedArrayToBST(int[] nums) {
        // 高度平衡，即每次要后序遍历吧？左右中，到中的时候判断左右子树的高度差是否符合条件
        // 用数组来构造二叉树，本质上就是对数组进行分割，然后进行对应树的条件判断
        // 分割数组构造二叉树，常用用递归做
        return ArrToTree(nums,0, nums.length-1);
    }
    // 递归，1.输入参数，自然是节点，然后是用于构造二叉树的数组；但是为了节省空间，直接用坐标来优化；left、right两个指针；返回自然是节点
    // 2.终止条件，当left、right两个指针重合或者 超出范围
    // 3.单层逻辑，每次对用left、right计算中间值的左边，然后作为上层节点的子节点；然后更新left、right，为新节点确定左右子树
    public TreeNode ArrToTree(int[] nums,int left,int right){
        if (right>nums.length || left<0 || left>right){
            return null;
        }
        int mid=left+(right-left)/2;    // 为了防止值溢出,找到分割坐标
        // 如果个数是偶数个，默认选第一个 left+(right-left)/2; 默认选第二个 right-(right-left)/2
        TreeNode root=new TreeNode(nums[mid]);
        root.left=ArrToTree(nums,left,mid-1);
        root.right=ArrToTree(nums,mid+1,right);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
