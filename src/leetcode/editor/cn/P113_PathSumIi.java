

package leetcode.editor.cn;
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
// Related Topics 树 深度优先搜索 回溯 二叉树 👍 752 👎 0

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class P113_PathSumIi{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P113_PathSumIi().new Solution();
        Integer[] tree=new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1,5,4,8,11,null,13,4,7,2,null,null,5,1};
        // 2n+1 2n+2
        int len=tree.length;
        TreeNode root=new TreeNode(tree[0]);
        Deque<TreeNode> que=new ArrayDeque<>();
        que.offer(root);
        for (int i = 0; i < tree.length/2 +1; i++) {
            //
            TreeNode node=que.poll();
            // if (node==null) {
            //     continue;
            // }
            // 左、右节点
            if(2*i+1<len && tree[2*i+1]!=null){
                node.left=new TreeNode(tree[2*i+1]);
            }
            if(2*i+2<len && tree[2*i+2]!=null){
                node.right=new TreeNode(tree[2*i+2]);
            }
            // 存左右节点
            if (node.left!=null) {
                que.offer(node.left);
            }
            if (node.right!=null) {
                que.offer(node.right);
            }
        }
        System.out.println(solution.pathSum(root,22));
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
static class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val){this.val=val;}
    TreeNode(int val,TreeNode left,TreeNode right){this.val=val;this.left=left;this.right=right;}
}

class Solution {
    List<List<Integer>> res=new ArrayList<>();
    List<Integer> path=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root==null) {
            return res;
        }
        path.add(root.val);
        getPathSum(root,targetSum);
        return res;
    }
    // 即判断每一个路径，是否达到了targetSum，如果达到了就存入到结果集中
    // 很明显这是做回溯，路径和结果集都设置成全局变量，
    // 并且这是要遍历所有的节点，且不需要处理递归的值，所以不要返回值；
    // 1. 返回类型 void；参数，节点，targetSum
    // 2. 到达叶子节点，就结束；此时还需判断一下路径和是不是满足条件
    // 3. 单层逻辑；中 求和； 左右 进行递归；并且要对path和路径和进行回溯，以返回中间节点
    int pathSum=0;  // 路径和  全局变量
    void getPathSum(TreeNode root,int targetSum){
        // 终止条件，叶子节点
        if(root.left==null && root.right==null) {
            //
            pathSum+=root.val;
            if(pathSum==targetSum){
                res.add(new ArrayList(path));
            }
            return ;
        }
        pathSum+=root.val;
        System.out.println(pathSum+" path："+path);
        // 单层逻辑
        if(root.left!=null){
            path.add(root.left.val);
            getPathSum(root.left,targetSum);
            path.remove(path.size()-1);
            pathSum-=root.left.val;
        }
        if(root.right!=null){
            path.add(root.right.val);
            getPathSum(root.right,targetSum);
            path.remove(path.size()-1);
            pathSum-=root.right.val;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
