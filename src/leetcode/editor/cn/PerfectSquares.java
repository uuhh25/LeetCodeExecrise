

package leetcode.editor.cn;
//给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。 
//
// 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：3 
//解释：12 = 4 + 4 + 4 
//
// 示例 2： 
//
// 
//输入：n = 13
//输出：2
//解释：13 = 4 + 9 
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁴ 
// 
// Related Topics 广度优先搜索 数学 动态规划 👍 1344 👎 0

import java.util.Arrays;

class P279_PerfectSquares{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P279_PerfectSquares().new Solution();
        System.out.println(solution.numSquares(13));
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 1. dp[j]-> 和为 j 的完全平方数的最少数量 为 dp[j]，每个重量都是可以重复取的
    // 2. 递推公式,算是组合问题吧，然后是要最少的组合数，dp[j]=min(dp[j],dp[j-weight[i]]+1)
    // 3. 初始话，dp[0]=0，因为要最小数量，所以其他的初始化为 Integer.MAX_VALUE
    // 4. 遍历顺序，因为本题是找少的组合数数目，所以排列和组合都可以，但是为了节省时间使用组合
    // => 外层物品，内层正向遍历背包容量 (因为是可以重复取的)
    // 5. 举例，n=13, len=3 => weight[]={1,4,9}
    // 0 1 2 3 4 5 6 7 8 9 10 11 12 13
    // 0 1 2 3 4 5 6 7 8 9 10 11 12 13
    // 0 1 2 3 1 2 3 4 2 3 4  5  3  4
    // 0 1 2 3 1 2 3 4 2 1 2  3  3  2  => dp[n]
    public int numSquares(int n) {
        // 首先要从n得到 weight[] 即在n范围内的所有完全平方数
        int len=(int) Math.pow(n,0.5);
        // 获得 weight[]
        int[] square= new int[len];
        for (int i = 0; i < len; i++) {
            square[i]=(int) Math.pow(i+1,2);
        }
        //
        int[] dp=new int[n+1];  // dp数组 完全背包
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        // 开始遍历完全背包
        for(int i=0;i<len;i++){
            for(int j=square[i];j<=n;j++){
                dp[j]=Math.min(dp[j],dp[j-square[i]]+1);
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
