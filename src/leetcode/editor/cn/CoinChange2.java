

package leetcode.editor.cn;
//给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。 
//
// 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。 
//
// 假设每一种面额的硬币有无限个。 
//
// 题目数据保证结果符合 32 位带符号整数。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：amount = 5, coins = [1, 2, 5]
//输出：4
//解释：有四种方式可以凑成总金额：
//5=5
//5=2+2+1
//5=2+1+1+1
//5=1+1+1+1+1
// 
//
// 示例 2： 
//
// 
//输入：amount = 3, coins = [2]
//输出：0
//解释：只用面额 2 的硬币不能凑成总金额 3 。
// 
//
// 示例 3： 
//
// 
//输入：amount = 10, coins = [10] 
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 300 
// 1 <= coins[i] <= 5000 
// coins 中的所有值 互不相同 
// 0 <= amount <= 5000 
// 
// Related Topics 数组 动态规划 👍 792 👎 0

class P518_CoinChange2{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P518_CoinChange2().new Solution();
        System.out.println(solution.change(5,new int[]{1,2,5}));
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 物品和价值 => 背包问题，可以多次取 -> 完全背包
    // 1.dp[j] 表示 总和为j的情况下，有多少种组合方式
    // 2.递推公式，这是一个组合问题，那么公式则为，dp[j]+=dp[j-weight[i]]
    // 3.初始化，dp[0]=1,其他都初始化为0
    // 4.由1、2知这是一个组合问题，即同样的数字、不同的顺序也视为一样
    // 所以要判断for循环的嵌套关系：
    // (1)物品在外、重量在内的话，在同样重量的情况下，不会在同重量下出现多个相同组合
    // (2)重量在外，物品在内的话，每一种重量下，相同的组合元素可能会出现多次
    // 5.举例，amount = 5, coins = [1, 2, 5]
    // 0 1 2 3 4 5  dp[j]+=dp[j-weight[i]]
    // 1 1 1 1 1 1  <= weight[i]
    // 1 1 2 2 3 3
    // 1 1 2 2 3 4(答案)
    public int change(int amount, int[] coins) {
        int[] dp=new int[amount+1];
        dp[0]=1;
        // 先物品，再重量，组合
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                // j=coins[i]是为了剪枝
                dp[j]+=dp[j-coins[i]];
            }
        }
        // 先重量，再物品，排列
//        for (int j = 1; j <= amount; j++) {
//            for (int i = 0; i < coins.length; i++) {
//                if (j>=coins[i]) {
//                    dp[j]+=dp[j-coins[i]];
//                }
//            }
//        }
        return dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
