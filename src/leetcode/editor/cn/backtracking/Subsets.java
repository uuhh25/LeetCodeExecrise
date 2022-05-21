

package leetcode.editor.cn.backtracking;
//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
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
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯 👍 1519 👎 0

import java.util.ArrayList;
import java.util.List;

class P78_Subsets{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P78_Subsets().new Solution();
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
//        for (int i = 0; i < nums.length-1; i++) {
//            result.add(Collections.singletonList(nums[i]));
//        }
        backtracking(nums,0);
        return result;
    }
    // 找子集，这是一个组合问题；可以用回溯直接做
    // 1.参数,数组，开始坐标;
    // 2.终止条件：到数组的尾部
    // 3.单层逻辑：每次纵向遍历时都把path存入到result;将遍历到的元素放入到path中；然后进入递归，下一起点要+1；接着做回溯
    void backtracking(int[] nums,int startidx){
        // 终止条件
        result.add(new ArrayList<>(path));
        if (startidx>=nums.length){
            return;
        }
        // 单层逻辑
        for (int i = startidx; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums,i+1);
            path.remove(path.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
