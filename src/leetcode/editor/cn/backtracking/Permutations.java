

package leetcode.editor.cn.backtracking;
//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 👍 1860 👎 0

import java.util.ArrayList;
import java.util.List;

class P46_Permutations{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P46_Permutations().new Solution();
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    int startidx = 0;
    public List<List<Integer>> permute(int[] nums) {
        boolean[] usd = new boolean[nums.length];
        backtracning(nums,usd);
        return result;
    }
    // 1.参数: 数组,标记数组
    // 2.终止条件,这道题是找排列顺序,所以要到数组末才结束,并且加入到res中
    // 3.单层逻辑:
    // 要完成的就是很多次for循环 => for循环是要判断坐标不得有重复的出现,那么我们就用一个数组,标识是否被使用
    // 开始坐标怎么确定? 直接默认从0开始就好,通过使用数组来判定这个坐标是否用过
    void backtracning(int[] nums,boolean[] usd){
        // 到数组末才结束,并且加入到res中
        if (path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        // 每次都从0开始
        for (int i = 0; i < nums.length; i++) {
            // 如果是使用过的,则continue
            if (usd[i]){
                continue;
            }
            usd[i]=true;
            path.add(nums[i]);
            backtracning(nums,usd);
            // 回溯
            path.remove(path.size()-1);
            usd[i]=false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
