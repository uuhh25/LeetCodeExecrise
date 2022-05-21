

package leetcode.editor.cn.tanxin;
//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 子数组 是数组中的一个连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [5,4,-1,7,8]
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
// Related Topics 数组 分治 动态规划 👍 4670 👎 0

class P53_MaximumSubarray{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P53_MaximumSubarray().new Solution();
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 贪心算法 时间 O(n) 空间 O(n)
//    public int maxSubArray(int[] nums) {
//        // 贪心解法  ->  本题是计算最大子数组和，则就要尽量避免在相加过程中出现负数的情况
//        // -> 局部最优：当前“连续和”为负数的时候立刻放弃，从下一个元素重新计算“连续和”
//        // -> 相当于暴力解法中不断调整最大子序和区间的起始位置，并且要不断地记录最大和
//        int result=Integer.MIN_VALUE;
//        int count=0;    // 用于记录每次起始为正数的位置
//        for (int i = 0; i < nums.length; i++) {
//            // 求和
//            count += nums[i];
//            if (count>result){
//                // 记录最大值
//                result=count;
//            }
//            if (count<0){
//                count=0;
//                // 相当于重置子数组和，重新开始计算
//            }
//        }
//        return result;
//
//    }

    // 动态规划怎么做的？
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        // 以第一个数 ...
        dp[0] = nums[0];
        ans = dp[0];

        for (int i = 1; i < nums.length; i++){
            // 判断是求和之后大，还是不求和大，保存大的那个策略，
            // 也可以说是，继续求和 / 重新求和
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            // 然后保存在i的时候的最大序列和
            ans = Math.max(dp[i], ans);
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
