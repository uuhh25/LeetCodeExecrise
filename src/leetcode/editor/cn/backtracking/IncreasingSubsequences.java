

package leetcode.editor.cn.backtracking;
//给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。 
//
// 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,6,7,7]
//输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,4,3,2,1]
//输出：[[4,4]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 15 
// -100 <= nums[i] <= 100 
// 
// Related Topics 位运算 数组 哈希表 回溯 👍 403 👎 0

import java.util.ArrayList;
import java.util.List;
@SuppressWarnings({"all"})
class P491_IncreasingSubsequences{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P491_IncreasingSubsequences().new Solution();
        int[] n = new int[]{4,6,7,7};
        System.out.println(solution.findSubsequences(n));
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    int startidx=0;
    public List<List<Integer>> findSubsequences(int[] nums) {
        // 首先不能对数组进行排序
        backtracking(nums,startidx);
        return result;
    }
    // 1. 参数 => 数组、每次for循环的起始位置
    // 2. 终止条件，到达数组的最后，;如果path长度>1，就把path加入到res中; 可以剪枝
    // 3. 单层逻辑：
        // a.横向的元素是不能重复的，且因为当前不是递增序列，所以不能用原来的判断方法；
    // => 因为数的范围再 -100，100  只有201个数，所以可以用一个数组来标识是否重复
        // b.path的最后一个元素 <= 要加入的元素
        // => 综合a b 如果不满足递增 或 不重复 都要跳过
        // c.回溯的for循环,
    public void backtracking(int[] nums, int startidx){
        // 本题是要遍历整棵树的
        if (path.size()>1){
            result.add(new ArrayList<>(path));
        }
        // 终止条件 可以不写，反正到末尾了会自动结束

        // 回溯的过程
        boolean[] used = new boolean[201];  // 只在同层的时候判断是否重复
        for (int i = startidx; i < nums.length; i++) {
            //
            // 如果满足递增 + 且不是重复元素，则加进去；这样判断的话，方便做回溯的操作
            // 如果不满足递增 或 有重复元素 都得跳过，所以后面的两个判断不能打括号
            if (!path.isEmpty() && nums[i]<path.get(path.size()-1) || used[100+nums[i]] ){
                continue;
            }
            used[100+nums[i]]=true; // 记录当前元素已使用
            path.add(nums[i]);
            backtracking(nums,i+1);
            path.remove(path.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
