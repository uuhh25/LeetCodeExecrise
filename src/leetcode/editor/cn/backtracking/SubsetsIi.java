

package leetcode.editor.cn.backtracking;
//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
// 
// 
// Related Topics 位运算 数组 回溯 👍 768 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class P90_SubsetsIi{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P90_SubsetsIi().new Solution();
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int startidx=0;
    public List<List<Integer>> subsetsWithDup(int[] nums){
        // 要先排序,才能够合理的判断是否有重复元素在横向遍历中
        Arrays.sort(nums);
        backtracing(nums,0);
        return result;

    }
    // 跟组合2一样,需要判断横向遍历是否出现了重复的元素,以免出现重复是path
    // 1. 参数, 开始凑子集的下班 startidx  数组nums
    // 2. 终止条件:到达数组的最后
    // 3. 单层逻辑:
    //   a. 因为是找子集, 所以每一次纵向遍历都需要存入到result中
    //   b. 在进行遍历的过程中,要判断在横向遍历是,当前元素是否在前面出现过(使用过)
    public void backtracing(int[] nums,int startidx){
        // 终止条件
        if (startidx>nums.length){
            return;
        }
        // 每次都要存到result中
        result.add(new ArrayList<>(path));
        // 回溯模板,for循环暴力遍历
        for (int i = startidx; i < nums.length; i++) {
            // 首先要判断是不是横向遍历
            if (i>startidx && nums[i]==nums[i-1]){
                continue;
            }
            // 单层逻辑
            path.add(nums[i]);
            backtracing(nums,i+1);
            path.remove(path.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
