

package leetcode.editor.cn.dp;
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：2
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 45 
// 
// Related Topics 记忆化搜索 数学 动态规划 👍 2347 👎 0

class P70_ClimbingStairs{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P70_ClimbingStairs().new Solution();
        System.out.println(solution.climbStairs(4));
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // dp五部曲，dp是状态的转移，由前面状态推导出后面状态
    // 1. 确定dp数组和下标的定义，
    // 第一层只有1个方法（1步）、到第二层有2种方法（1+1、2）
    // 第三层是方法可以通过第一层、第二层的楼梯状态推导出来
    // => 可以用动态规划，dp[i]表示到第i层的方法数量
    // 2. 确定递推公式、从1、2、3级台阶来看，dp[3]=dp[2] + dp[1]
    // dp[i]就是dp[i-1]跨多一步，dp[i]也是dp[i-2] 跨多两步； dp[i]=dp[i-1]+dp[i-2]
    // 3. dp 初始化， dp[1]=1,dp[2]=2;
    // 4. 遍历顺序，从下往上走楼梯，从前到后
    // 5. dp举例； n=4  dp[] = {0,1,2,3,5}
    public int climbStairs(int n) {
        // 返回初始化值
        if (n<=2){
            return n;
        }
        int[] dp = new int[n+1];
        dp[1]=1;dp[2]=2;
        for (int i = 3; i < dp.length; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
