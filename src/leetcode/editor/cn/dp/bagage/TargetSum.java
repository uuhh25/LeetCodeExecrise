

package leetcode.editor.cn.dp.bagage;
//给你一个整数数组 nums 和一个整数 target 。
//
// 向数组中的'每个整数前添加 '+' 或 '- ，然后串联起所有整数，可以构造一个 表达式 ：
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
// Related Topics 数组 动态规划 回溯 👍 1168 👎 0

class P494_TargetSum{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P494_TargetSum().new Solution();
        System.out.println(solution.findTargetSumWays(new int[]{1,1,1,1,1},1));
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 首先要判断 sum>target 是否成立，不成立的话，直接返回0，因为都是正整数
    // 如果sum>target，那么其实可以把数分两堆一堆为全正号，另一堆全为负号，一堆为 sum+，另一堆为 sum-；
    // sum+ - sum- = target; sum+ + sum- = sum  => 2*sum+ = sum+target
    // => sum+ = (target+sum)/2，相当于找sum+这个和的构造数
    // 1.dp[j],还是用01背包一维数组表示，dp[j]表示当前和（重量）下，有几种构造方法，
    // 2.递推公式，dp[j] += dp[j-nums[i]]；填满容量为j - nums[i]的背包，有dp[j - nums[i]]种方法
    // 那只要有nums[i]凑dp[j]就可以 得出 dp[j-nums[i]]
    // 3.初始化，如果当前和为0，且nums[i]都为正数，那只有1种构造方法，dp[0]=1
    // 4.遍历顺序，外层物品，内层倒序重量
    // 5.[1,1,1,1,1], target = 3，sum+ = (target+sum) /2 = 4,如果不为正数，则说明target+sum为奇数，没有构造方法，返回0
    // dp[4+1]={1,1,}
    public int findTargetSumWays(int[] nums, int target) {
        // 按照我的思路试试...
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        // 特例
        if ((sum+target)%2!=0){
            return 0;
        }
        // 还有负数的情况
        int t = (sum+target) / 2;
        if (t<0){
            t=-t;
        }

        int[] dp=new int[t+1];
        // 初始化
        dp[0]=1;
        //
        for (int i = 0; i < nums.length; i++) {
            for (int j = t; j >=nums[i] ; j--) {
                dp[j]=dp[j] + dp[j-nums[i]];
            }
        }
        return dp[t];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
