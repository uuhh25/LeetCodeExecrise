

package leetcode.editor.cn.dp;
//给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。 
//
// 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。 
//
// 请你计算并返回达到楼梯顶部的  最低花费
//
// 
//
// 示例 1： 
//
// 
//输入：cost = [10,15,20]
//输出：15
//解释：你将从下标为 1 的台阶开始。
//- 支付 15 ，向上爬两个台阶，到达楼梯顶部。
//总花费为 15 。
// 
//
// 示例 2： 
//
// 
//输入：cost = [1,100,1,1,1,100,1,1,100,1]
//输出：6
//解释：你将从下标为 0 的台阶开始。
//- 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
//- 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
//- 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
//- 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
//- 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
//- 支付 1 ，向上爬一个台阶，到达楼梯顶部。
//总花费为 6 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= cost.length <= 1000 
// 0 <= cost[i] <= 999 
// 
// Related Topics 数组 动态规划 👍 871 👎 0

class P746_MinCostClimbingStairs{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P746_MinCostClimbingStairs().new Solution();
        int[] n = new int[]{1,100,1,1,1,100,1,1,100,1};
        System.out.println(solution.minCostClimbingStairs(n));
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // cost[i] 表示从第i个台阶，向上爬的费用
    // 1. dp数组，到达第i级台阶的最少花费，dp[i]; 第一步只能去0、1台阶，即dp[0] dp[1]...
    // dp[0]=cost[0] ，第一步到第1个台阶的入场费; dp[1]=cost[1],第一步到第2个台阶的入场费；
    // 2. 递推公式，dp[2] = Math.min(dp[0],dp[1])+cost[i]; 到第三个台阶的两种方式，以及到这级台阶的入场费；
    // + cost[i] 的意思是，先预付费，因为从这一级开始爬，需要付费cost[i]
    // dp[n]=Math.min(dp[n-2],dp[n-1])+cost[n]
    // 3. 初始化，dp[0]=cost[0],dp[1]=cost[1]; 即第一步，可以到的目的地，及所需的入场费
    // 4. 遍历顺序，上台阶，肯定是从前往后
    // 5. 举例;
    // cost = [1,100,1,1,1,100,1,1,100,1],dp[0]=1,dp[1]=100
    // dp[2]=min(dp[0],dp[1])+cost[2]=1+1=2; dp[3]=min(dp[2]+dp[1])+cost[3]=2+1=3
    // 最后的返回值，从dp 的倒数1、2中选最小的花费
    public int minCostClimbingStairs(int[] cost) {
        //
        int[] dp= new int[cost.length];
        dp[0]=cost[0];
        dp[1]=cost[1];
        for (int i = 2; i < dp.length; i++) {
            // 从第三级开始算
            dp[i]=Math.min(dp[i-1],dp[i-2])+cost[i]; //前两个出发点的历史入场费，及当前的入场费

        }
        return Math.min(dp[dp.length-1],dp[dp.length-2]);   // 最后两级中选最少花费的
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
