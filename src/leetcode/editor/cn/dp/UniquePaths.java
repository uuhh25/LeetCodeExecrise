

package leetcode.editor.cn.dp;
//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 示例 1： 
//
// 
//输入：m = 3, n = 7
//输出：28 
//
// 示例 2： 
//
// 
//输入：m = 3, n = 2
//输出：3
//解释：
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向下
// 
//
// 示例 3： 
//
// 
//输入：m = 7, n = 3
//输出：28
// 
//
// 示例 4： 
//
// 
//输入：m = 3, n = 3
//输出：6 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 10⁹ 
// 
// Related Topics 数学 动态规划 组合数学 👍 1367 👎 0

class P62_UniquePaths{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P62_UniquePaths().new Solution();
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 当前是路径问题，所以dp数组肯定跟路径相关；
    // 同时题目是到达m，n的路径有多少条
    // => dp[i][j]就应该是到达i,j的路径有多少条，才能得到dp[m-1][n-1]这个题目的要求
    // 1. dp数组 和 下标的含义都明了
    // 2. 递推公式，因为每次只能向右或者向下移动一步，则dp[i][j]=dp[i-1][j]+dp[i][j-1]
    // 3. 初始化dp，dp[i][0] 和 dp[0][j]这两边，要到达只有一种路径（不考虑拐弯的情况）
    // 所以给数组的两边都赋1，表示到达该点只有一条路径
    // 4. 遍历顺序：从左上往右下； 根据递推公式，从上到下、从左到右
    // 5. 举例
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // 初始化
        for (int i = 0; i < m; i++) {
            dp[i][0]=1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i]=1;
        }
        // 遍历
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
