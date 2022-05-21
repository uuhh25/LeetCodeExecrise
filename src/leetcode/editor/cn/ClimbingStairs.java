

package leetcode.editor.cn;
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
// Related Topics 记忆化搜索 数学 动态规划 👍 2386 👎 0

class P70_ClimbingStairs{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P70_ClimbingStairs().new Solution();
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 用背包理论来解决，相当于这个物品有两个，可以重复取，重量分别为[1,2]
    // 1.dp[j]，就表示，j重量(级台阶)下，有dp[j]种爬的方式
    // 2.递推公式，这是一个完全背包的组合问题；即dp[j]+=dp[j-weight[i]]
    // j-nums[i] <=> dp[j-nums[i]]
    // n=4,求dp[4]； 已知nums[]=[1,2]
    // nums[i]=1 <=>  dp[4-1]=dp[3]
    // nums[i]=2 <=>  dp[4-2]=dp[2]
    // dp[3] => dp[3-1]=dp[2] dp[3-2]=dp[1]
    // dp[2] => dp[2-1]=dp[1] dp[2-2]=dp[0]
    // dp[1] => dp[1-1]=dp[0]
    // => 其实 dp[j]+=dp[j-weight[i]]
    // 3.初始化dp[0]=1,到第0阶的方式只有一种，并且其他下标初始化为0
    // 4.遍历顺序，首先这是 排列 问题，所以外层要是背包容量、内层要是物体，
    // 且可以重复取元素，内层正序遍历
    // 5.举例, n=4;nums[]=[1,2]
    // 0 1 2 3 4
    // 1 1 0 0 0
    // 1 1 2 0 0
    // 1 1 2 3 0
    // 1 1 2 3 5
    public int climbStairs(int n) {
        int[] dp =new int[n+1];
        dp[0]=1;
        int[] nums=new int[]{1,2};
        //
        for (int j = 1; j <= n; j++) {
            for (int i = 0; i <nums.length; i++) {
                if (j>=nums[i]){
                    dp[j]+=dp[j-nums[i]];
                }
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
