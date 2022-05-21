

package leetcode.editor.cn.dp;
//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。 
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？ 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//输出：2
//解释：3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
// 
//
// 示例 2： 
//
// 
//输入：obstacleGrid = [[0,1],[0,0]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == obstacleGrid.length 
// n == obstacleGrid[i].length 
// 1 <= m, n <= 100 
// obstacleGrid[i][j] 为 0 或 1 
// 
// Related Topics 数组 动态规划 矩阵 👍 769 👎 0

class P63_UniquePathsIi{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P63_UniquePathsIi().new Solution();
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 在上一题的基础上，添加了障碍位置
    // 1. dp数组的初始，dp下标的含义；依然是找每个点的路径数目，dp[i][j]表示到该点的路径数目
    // 2. 递推公式，依旧是只能向下、向右走一步；但是如果到障碍点的话，直接把dp[i][j]设为0
    // 3. 初始化，依旧是两边界，只有一条到达的路径，给两个边界都赋1;
    // 要考虑边界上的障碍，如果有障碍，则后面全部都不能到达
    // 4. 遍历顺序，从左上到右下，从上到下、从左到右
    // 5. 举例：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
    // dp[][]=1 1 1
    //        1 0 1
    //        1 1 2
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length,n=obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        // 初始化
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0]==1){
                break;
            }
            dp[i][0]=1;
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i]==1){
                break;
            }
            dp[0][i]=1;
        }
        // 遍历
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //
                if (obstacleGrid[i][j]==1){
                    // dp[i][j]=0;
                    continue;
                }else {
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
