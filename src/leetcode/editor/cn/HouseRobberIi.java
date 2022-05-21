

package leetcode.editor.cn;
//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的
//房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,2]
//输出：3
//解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,1]
//输出：4
//解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 数组 动态规划 👍 1026 👎 0

import java.util.Arrays;

class P213_HouseRobberIi{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P213_HouseRobberIi().new Solution();
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 从题目可知，要么是 首 - 尾-1、要么是 首+1 - 尾两种情况；那么我们就找到哪种情况能够有最大收益就好了！
    // 相当于是对两种情况分别dp，然后返回最大的
    // 1.dp[i]，在i间房子内可以取得的最大金额  dp[i]
    // 2.递推公式，因为不能偷相邻房子，所以要么不变 要么从i-2状态转过来，dp[i]=Math.max(d[i-1],dp[i-2]+nums[i])
    // 3.初始化，dp[0]=nums[0]  dp[1]=max(nums[0],nums[1])；其他都为0就好
    // 4.遍历顺序，因为i是从前到后的，所以是正向遍历

    public int rob(int[] nums) {
        int n=nums.length;
        if (n<2){
            return nums[0];
        }else if (n<3){
            return Math.max(nums[0],nums[1]);
        }
        int[] arr1 = new int[n-1];
        int[] arr2 = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            arr1[i]=nums[i];
        }
        for (int i = 1; i < n; i++) {
            arr2[i-1]=nums[i];
        }
        return Math.max(robArr(arr1),robArr(arr2));
    }
    public int robArr(int[] nums){
        //
        int n=nums.length;
        int[] dp=new int[n];
        dp[0]=nums[0];dp[1]=Math.max(nums[0],nums[1]);
        //
        for (int i = 2; i < n; i++) {
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
