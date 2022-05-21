

package leetcode.editor.cn;
//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 
//输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics 数组 动态规划 👍 2093 👎 0

class P198_HouseRobber{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P198_HouseRobber().new Solution();
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 怎么偷，才能够偷窃到最高金额
    // 1. dp[i] 表示，在经过前i个屋子能够盗窃的最大金额为 dp[i]
    // 2. 递推公式，因为不能盗窃相邻的房屋，且要得到最大金额,dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1])
    // 3. 初始化，由递归公式可看出，dp[0]和dp[1]是必须要的，dp[0]=nums[0]，dp[1]=Max(nums[0],nums[1])
    // 4. 遍历顺序，由递推公式可以得出，i是上升的，所以是从前到后
    // 5. 举例：  [1,2,3,1] ，n=4
    // 0 1 2 3  (因为是索引，相当于是 - 1)
    // 1 2 4 4  => dp[n]
    public int rob(int[] nums) {
        //
        int n=nums.length;
        // 只有一位的情况下
        if (n<2){
            return nums[n-1];
        }
        int[] dp=new int[n];
        dp[0]=nums[0];dp[1]=Math.max(nums[0],nums[1]);
        // 遍历
        for (int i = 2; i < n; i++) {
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
