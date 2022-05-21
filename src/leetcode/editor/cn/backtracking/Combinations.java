

package leetcode.editor.cn.backtracking;
//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics 数组 回溯 👍 868 👎 0

import java.util.ArrayList;
import java.util.List;

class P77_Combinations{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P77_Combinations().new Solution();
        int n=4,k=3;
        System.out.println(solution.combine(n,k));
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 组合问题，常用回溯算法优化暴力解法
    // 定义两个list，用于存放过程结果和最终结果
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    // 在本题中，结果只看元素本身，不看顺序；
    // 所以在横向遍历中，是没有重复的，可以用一个遍历，来不停更新横向遍历的起点

    public List<List<Integer>> combine(int n, int k) {
        res.clear();
        path.clear();
        backtracking(n,k,1);    // n的起点从1开始
        return res;
    }
    // 回溯法，参数有n、k、startidx，才能够在树结构中 横向遍历+纵向遍历
    void backtracking(int n,int k, int startidx){
        // 终止条件，当到达叶子节点，就停止递归
        // 在本题中，当得到一个符合长度为k的过程结果，就停止并输入到res列表中
        if (path.size()==k){
            // java 要重新定义一个list，不然会跟着后续的操作
            res.add(new ArrayList<>(path));
            return;
        }
        // 回溯算法，单层搜索过程,每次的起点都不同
        // 剪枝 n - (k - path.size()) + 1
        for (int i=startidx;i<=n;i++){
            path.add(i);    // 处理节点
            backtracking(n,k,i+1);  // 递归，树的纵向遍历，注意下一层搜索要从i+1开始新起点
            path.remove(path.size()-1); // 回溯，撤销处理的结点
        }
        return;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
