

package leetcode.editor.cn.dp.bagage;
//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树 👍 1696 👎 0

class P96_UniqueBinarySearchTrees{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P96_UniqueBinarySearchTrees().new Solution();
        System.out.println(solution.numTrees(1));
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // dp 大多数都是数学表达式，所以一般可以从前几项来举例子，来找一下有没有重叠子问题
    // n=1，二叉树只有1种；n=2，二叉树有2种；n=3，二叉树有5种；
    // dp[i]就可以表示，n=i时，有多少种二叉搜索树
    // 2.递推公式，dp[3] = 头节点为1的二叉树+头节点为2的二叉树+头节点为3的二叉树
    // 头节点为1 = 左子树有0个元素 * 右子树有2个元素
    // 头节点为2 = 左子树有1个元素 * 右子树有1个元素
    // 头节点为3 = 左子树有2个元素 * 右子树有0个元素
    // 元素为1个，就是n=0的情况的dp[0];
    // 元素为1个，就是n=1的情况的dp[1];
    // 元素为2个，就是n=0的情况的dp[2];
    // => dp[3]=dp[0]*dp[2]+dp[1]*dp[1]+dp[2]*dp[0]
    // => dp[3]=dp[0]*dp[3-1]+dp[1]*dp[3-2]+dp[3-1]*dp[3-3]
    // => dp[i]=dp[0]*dp[i-1]+dp[1]*dp[i-2]+...+dp[i-1]*dp[0]，一个正向遍历一个反向遍历
    // 3.初始化，dp[0]=1,dp[1]=1,dp[2]不需要初始化，因为可以通过dp[0]和dp[1]求出来
    // 4.遍历顺序，由递推公式可知，dp[i]要取决于dp[i-1],dp[i-2]...，所以要先求前面的，是从前往后遍历
    // 5.举例dp[5]={0,1,2,5,14,42}
    // dp[4]=dp[0]dp[3]+dp[1]dp[2]+dp[2]dp[1]+dp[3]dp[0]=14
    // dp[5]=dp[0]dp[4]+dp[1]dp[3]+dp[2]dp[2]+dp[3]dp[1]+dp[4]dp[0]=42
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0]=1;dp[1]=1;
        //
        if (n<2){
            return dp[n];
        }
        for (int i = 2; i <= n; i++) {
            // 计算i-1,i-2...的情况
            for (int j = 0; j < i; j++) {
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
