

package leetcode.editor.cn.binary_tree;
//给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建: 
//
// 
// 创建一个根节点，其值为 nums 中的最大值。 
// 递归地在最大值 左边 的 子数组前缀上 构建左子树。 
// 递归地在最大值 右边 的 子数组后缀上 构建右子树。 
// 
//
// 返回 nums 构建的 最大二叉树 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,1,6,0,5]
//输出：[6,3,5,null,2,0,null,null,1]
//解释：递归调用如下所示：
//- [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
//    - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
//        - 空数组，无子节点。
//        - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
//            - 空数组，无子节点。
//            - 只有一个元素，所以子节点是一个值为 1 的节点。
//    - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
//        - 只有一个元素，所以子节点是一个值为 0 的节点。
//        - 空数组，无子节点。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[3,null,2,null,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 1000 
// nums 中的所有整数 互不相同 
// 
// Related Topics 栈 树 数组 分治 二叉树 单调栈 👍 367 👎 0

import java.util.Arrays;

class P654_MaximumBinaryTree{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P654_MaximumBinaryTree().new Solution();
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // 相当于找数组中的最大值，作为当前的分割点
        // 分割成左数组 、右数组；然后继续找当前数组的最大值用于分割; 如果数组为空，则节点为空
        return getTree(nums);
    }
    // 递归，相当于也是一一层一层的分割；
    // 输入参数，数组，返回二叉树节点
    // 终止条件，数组长度为0，即空节点，返回null；数组长度为1，即叶子节点，直接返回当前节点
    // 单层逻辑：1.找到数组最大值的位置
    // 2.根据1的idx，分割数组，遵循左开右闭
    // 3.节点左子树 = 递归（左数组），节点右子树=递归（右数组）
    public TreeNode getTree(int[] arr){
        //  终止条件1
        if (arr.length == 0) {
            return null;
        }
        // 1.找到分割点
        int idx = 0;
        int maxValue = arr[idx];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>=maxValue){
                maxValue = arr[i];
                idx = i;
            }
        }

        // 根据获得的最大值，定义根节点
        TreeNode root = new TreeNode(maxValue);
        // 终止条件2
        if (arr.length == 1) {
            return root;
        }

        // 2.左开右闭，进行分割
        // 因为每次分割都重新定义了数组，所以时间和空间复杂度都比较高；
        // 如何优化？只用一个数组，但是每次都改变索引值，暂时还没看，
        int[] leftA = Arrays.copyOfRange(arr,0,idx);
        int[] rightA = Arrays.copyOfRange(arr,idx+1,arr.length);
        // System.out.println(Arrays.toString(leftA));
        // System.out.println(Arrays.toString(rightA));

        // 3.继续递归，获得左右子树
        root.left = getTree(leftA);
        root.right = getTree(rightA);

        //
        return root;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
