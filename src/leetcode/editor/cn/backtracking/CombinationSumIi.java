

package leetcode.editor.cn.backtracking;
// 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// Related Topics 数组 回溯 👍 850 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class P40_CombinationSumIi{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P40_CombinationSumIi().new Solution();
        int[] arr = new int[]{10,1,2,7,6,1,5};
        System.out.println(solution.combinationSum2(arr,8));
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 区别就是，输入的数组，元素是没有顺序的
    // 要求是，元素不能重复;“结果不能重复”--横向遍历不遍历重复元素
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    int idx=0;
    int pre=0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 为了将重复的数字都放到一起，所以先进行排序
        Arrays.sort(candidates);

        backtracking(candidates,target,0,idx);
        return res;
    }
    // 1. 输入参数，数组、target、起点坐标、sum和boolean数组（用于判断同层是否用了重复元素）
    // 2. 终止条件，和大于target直接返回；和==target 先保存结果再返回
    // 3. 单层逻辑：先计算sum，然后调用回溯进行递归；因为元素不能重复，所以下一纵向遍历的起点为当前坐标+1；
    // 为避免相同结果，在横向遍历过程，遇到相同元素要跳过;怎么去重呀？
    public void backtracking(int[] candidates, int target, int startidx, int sum){
        // 终止条件
        if (sum==target){
            res.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) {
            return;
        }
        // 单层逻辑
        for (int i = startidx; i < candidates.length; i++) {
            // 要对同一树层使用过的元素进行跳过
            if (i > startidx && candidates[i] == candidates[i - 1]) {
                // i>startidx 表明是在横向遍历！
                // 加上后面的条件，就能够不遍历重复的元素
                continue;
            }
            path.add(candidates[i]);
            sum+=candidates[i];
            i+=1;
            backtracking(candidates,target,i,sum);  // 递归，纵向遍历求sum
            // 回溯
            i-=1;
            sum-=candidates[i];
            path.remove(path.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
