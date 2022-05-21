

package leetcode.editor.cn.backtracking;
// 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的
// 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。 
//
// candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
//
// 对于给定的输入，保证和为 target 的不同组合数少于 150 个。 
//
// 示例 1： 
//
//输入：candidates = [2,3,6,7], target = 7
//输出：[[2,2,3],[7]]
//解释：
//2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
//7 也是一个候选， 7 = 7 。
//仅有这两种组合。 
//
// 示例 2： 
//
// 
//输入: candidates = [2,3,5], target = 8
//输出: [[2,2,2,2],[2,3,3],[3,5]] 
//
// 示例 3： 
//
// 
//输入: candidates = [2], target = 1
//输出: []
// 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都 互不相同 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯 👍 1770 👎 0

import java.util.ArrayList;
import java.util.List;

class P39_CombinationSum{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P39_CombinationSum().new Solution();
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 用于存每一次的路径和最终的结果
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int sum=0;
        backtracking(candidates,target,sum,0);
        return res;
    }
    // 组合问题，用回溯来做；此题：path长度无限制、数组数字可以重复
    // 1.函数及输入参数（），因为要遍历数组，且对比target，所以要输入 candidates、target；sum是表示当前总和，可以用于回溯
    // 2.sum  和==target 或者 和>target；
    // 3.单层逻辑：横向是for循环，纵向起点从横向遍历的下标开始，即下标startidx，
    public void backtracking(int[] candidates,int target, int sum,int startidx){
        // 2.终止条件
        if (sum==target){
            res.add(new ArrayList<>(path));
            return;
        }else if (sum>target){
            return;
        }
        // 单层逻辑
        for (int i = startidx; i < candidates.length; i++) {
            path.add(candidates[i]);
            sum+=candidates[i];
            backtracking(candidates,target,sum,i);    // 进入递归，模拟for循环
            // 回溯，把sum和path还原
            sum-=candidates[i];
            path.remove(path.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
