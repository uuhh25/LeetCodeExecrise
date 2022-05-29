

package leetcode.editor.cn;
//给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。 
//
// 如果树中有不止一个众数，可以按 任意顺序 返回。 
//
// 假定 BST 满足如下定义： 
//
// 
// 结点左子树中所含节点的值 小于等于 当前节点的值 
// 结点右子树中所含节点的值 大于等于 当前节点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 464 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class P501_FindModeInBinarySearchTree{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P501_FindModeInBinarySearchTree().new Solution();
        Integer[] tree=new Integer[]{2,1};
        TreeNode root=new createTreeNode().create(tree);
        System.out.println(solution.findMode(root));
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
    // 二叉搜索树的性质，使得中序遍历的结果是一个递增的数组，那么重复的元素就会连在一块
    // 那么我们就能够求得每个数字出现次数，并且判断是不是众数；
    // 并且说树中可能不止一个众数；则存众数结果的应该用一个list；
    // 用两组全局变量，用来记录众数和寻找众数
    int maxCount=Integer.MIN_VALUE,count=0;
    TreeNode pre=null;
    List<Integer> res=new ArrayList<>();
    public int[] findMode(TreeNode root) {
        if(root==null) {
            return new int[]{};
        }
        if(root.left==null&&root.right==null) {
            return new int[]{root.val};
        }
        inorder(root);
        System.out.println(res);
        Integer[] arr = res.toArray(new Integer[res.size()]);
        return Arrays.stream(arr).mapToInt(Integer::valueOf).toArray();
    }

    // 中序遍历
    public void inorder(TreeNode root){
        // 结束条件
        if(root==null) {
            return;
        }
        // 左
        inorder(root.left);
        // 中
        if(pre!=null){
            // 判断是不是跟前一个节点值相同
            if(pre.val==root.val){
                count++;
            }else{
                count=0;
                count++;
            }
            // 保存众数，
            if(count==maxCount){
                if(res.get(res.size()-1)!=root.val){
                    res.add(root.val);
                }
            }
            if(count>maxCount){
                maxCount=count;
                res.clear();    //说明之前的不是众数
                res.add(root.val);
            }
        }else {
            res.add(root.val);
            count++;
            maxCount=count;
        }
        pre=root;
        // 右
        inorder(root.right);
        return;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
