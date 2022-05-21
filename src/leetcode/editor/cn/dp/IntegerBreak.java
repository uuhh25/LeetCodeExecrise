

package leetcode.editor.cn.dp;
//给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。 
//
// 返回 你可以获得的最大乘积 。
//
// 
//
// 示例 1: 
//
// 
//输入: n = 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。 
//
// 示例 2: 
//
// 
//输入: n = 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。 
//
// 
//
// 提示: 
//
// 
// 2 <= n <= 58 
// 
// Related Topics 数学 动态规划 👍 787 👎 0

class P343_IntegerBreak{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P343_IntegerBreak().new Solution();
        System.out.println(solution.integerBreak(10));
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 题目要求返回最大的乘积，则说明dp数组应该是跟乘积相关的，k个整数和，k是没有固定的
    // => dp[i] 竟然是 表示 分拆i这个数 的最大乘积
    // 2.递推公式，找每个分拆数 最大乘积 之间的 关系；我们可以把i 分拆成 j 和 (i-j),j从1开始遍历，到i/2
    // 那么乘积就是 j * (i-j) 或者 j*dp[i-j]
    // 这一步是验证j和分拆的 i-j 相乘大、还是跟不分拆的i-j相乘更大=> dp[i]=math(dp[j],max(j*dp[i-j],i*(i-j)))
    // 3.初始化，dp[0]=0,dp[1]=1,dp[2]=1,然后从3开始
    // 4.遍历顺序，j是从1 -> i的，并且dp[i] 由 dp[i-j]得来，所以是从前到后
    // 5.dp[]={0,1,1,2,4,6,9,12,18}，取dp[8]
    //   n=8   0,1,2,3,4,5,6,7 ,8
    public int integerBreak(int n) {
        //
        int[] dp = new int[n+1];
        dp[2]=1;
        // 相当于把dp[3] -> dp[n]的值算出来
        for (int i = 3; i <= n; i++) {
            // 这个i表示的是dp[i]，要先由dp[i]之前的值，才能得到dp[i]
            for (int j = 1; j < i-1; j++) {
                // 从3开始，根据递推公式，计算i在拆分之后的最大乘积
                dp[i]=Math.max(dp[i],Math.max(dp[i-j]*j,(i-j)*j));
            }
        }
        // 取最后一个数
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
