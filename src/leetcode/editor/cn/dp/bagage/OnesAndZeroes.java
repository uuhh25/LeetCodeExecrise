

package leetcode.editor.cn.dp.bagage;
//给你一个二进制字符串数组 strs 和两个整数 m 和 n 。 
//
// 
// 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。 
//
// 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
//输出：4
//解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
//其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 
//n 的值 3 。
// 
//
// 示例 2： 
//
// 
//输入：strs = ["10", "0", "1"], m = 1, n = 1
//输出：2
//解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 600 
// 1 <= strs[i].length <= 100 
// strs[i] 仅由 '0' 和 '1' 组成 
// 1 <= m, n <= 100 
// 
// Related Topics 数组 字符串 动态规划 👍 699 👎 0

class P474_OnesAndZeroes{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P474_OnesAndZeroes().new Solution();
        String[] strs = new String[]{"10", "0", "1"};
        int m = 1, n = 1;
        System.out.println(solution.findMaxForm(strs,m,n));
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 如果当作是一个背包问题，则是01背包；物品为 字符串数组 的每个元素、重量为m和n，即二维重量
    // 1. dp[i][j] 表示 包含 有i个0字符 和 j个1字符的 最大子集个数为 dp[i][j] 个
    // 2. 其实相当于，两个维度重量，都是一维数组；i表示 当前 字符0 的重量；j表示 当前 字符1 的重量
    // 然后m这个维度，判断当前的字符串 中 0 字符的个数加上是否超过m，不超过则从之前的状态[只有i-0num个 0字符]转移过来 dp[i-0num][j] + 1
    // 然后n这个维度，判断当前的字符串 中 1 字符的个数加上是否超过n，不超过则从之前的状态[只有j-1num个 1字符]转移过来 dp[i][j-1num] + 1
    // 超过则不变； dp[i][j]=max (dp[i][j], dp[i-0num][j-1num]+1)
    // 3. 初始化，dp[0][0]=0，其他位置都为0；
    // 4. 遍历顺序，01背包问题，先遍历物品、再遍历重量；遍历物品的时候，还要计算当前物品 0、1 的字符数
    // 5.
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp= new int[m+1][n+1];
        //
        dp[0][0]=0;
        // 物品遍历
        for (String str:strs) {
            // 计算当前字符，0、1的重量（个数0
            int ZeroNum=0,OneNum=0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i)=='0'){
                    ZeroNum++;
                }else {
                    OneNum++;
                }
            }
            // 重量遍历，两个维度的重量，用二维数组相当于每个维度都是用的一维数组，则要从后往前遍历
            for (int i = m; i >=ZeroNum ; i--) {
                for (int j = n; j >=OneNum ; j--) {
                    // 递推公式直接写，因为已经做了剪枝
                    dp[i][j]=Math.max(dp[i][j],dp[i-ZeroNum][j-OneNum]+1);
                }
            }
        }
        // 返回右下角的数，即最大子集个数
        return dp[m][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
