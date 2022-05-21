

package leetcode.editor.cn;
//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
// Related Topics 广度优先搜索 数组 动态规划 👍 1894 👎 0

import java.util.Arrays;

class P322_CoinChange{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P322_CoinChange().new Solution();
        System.out.println(solution.coinChange(new int[]{1,2,5},11));
        System.out.println(solution.coinChange(new int[]{2},1));
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 相当于这是 比较 最小组合？
    // 1.dp[j],当和为j时 凑成j的 最少硬币个数为dp[j]
    // 2.递推公式，因为是求凑成j的最小硬币个数，所以相当于找 凑j的 每个元素，其凑成的最少硬币各户
    // dp[j]=min(dp[j],dp[j-nums[i]]+dp[nums[i]]) => dp[j]=min(dp[j],dp[j-nums[i]]+1)
    // 3.初始化，因为要能够求出min，所以所有下标初始化为nums.length为int最大值
    // 4.遍历顺序，要先遍历物品，再遍历重量，因为这是组合，排列的话，影响不大但是效率更低？
    // 5.举例 target=11,nums[]=[1,2,5],dp[]初始化全为3+1，dp[0]=0,如果最后dp[target]=n+1,则返回-1
    // 0 1 2 3 4 5 6 7 8 9 10 11
    // 0 1 2 3 4 4 4 4 4 4 4  4
    // 0 1 2 2 2 3 4 4 4 4 4  4
    // 0 1 2 2 2 1 2 2 3 3 2  3
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[] dp=new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        //
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <=amount; j++) {
                //只有dp[j-coins[i]]不是初始最大值时，该位才有选择的必要
                if (dp[j-coins[i]]!=Integer.MAX_VALUE){
                    dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);
                }
            }
        }
        if (dp[amount]==Integer.MAX_VALUE){
            return -1;
        }
        return dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
