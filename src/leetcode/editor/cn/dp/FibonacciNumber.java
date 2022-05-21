

package leetcode.editor.cn.dp;
//斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是： 
//
// 
//F(0) = 0，F(1) = 1
//F(n) = F(n - 1) + F(n - 2)，其中 n > 1
// 
//
// 给定 n ，请计算 F(n) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：1
//解释：F(2) = F(1) + F(0) = 1 + 0 = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：2
//解释：F(3) = F(2) + F(1) = 1 + 1 = 2
// 
//
// 示例 3： 
//
// 
//输入：n = 4
//输出：3
//解释：F(4) = F(3) + F(2) = 2 + 1 = 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 30 
// 
// Related Topics 递归 记忆化搜索 数学 动态规划 👍 439 👎 0
@SuppressWarnings({"all"})

class P509_FibonacciNumber{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P509_FibonacciNumber().new Solution();
        System.out.println(solution.fib(30));
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // n<=30，我先直接获取这个数组，不就解决了...
    public int fib(int n) {
        if (n<=1) {
            return n;
        }
        int[] dp = new int[n+1];
        dp[0]=0;dp[1]=1;
//        for (int i = 2; i < dp.length; i++) {
//            dp[i]=dp[i-1]+dp[i-2];
//        }
//        return dp[n];
        for (int i = 2; i <= n; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];

        // 1. 确定dp数组，和下标的含义：dp[i]定义，第i个数的斐波那契数值是dp[i]
        // 2. 确定递推公式：F(n)=F(n-1)+F(n-2)
        // 3. dp数组的初始化，dp[0]=1 dp[1]=1 [题目已经给出]
        // 4. 遍历顺序，后面的是通过前面的数来得出，所以是从前到后
        // 5. 举例推导dp，自己举例 和 代码输出对比
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
