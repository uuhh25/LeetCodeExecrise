

package leetcode.editor.cn;
//给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。 
//
// 题目数据保证答案符合 32 位整数范围。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3], target = 4
//输出：7
//解释：
//所有可能的组合为：
//(1, 1, 1, 1)
//(1, 1, 2)
//(1, 2, 1)
//(1, 3)
//(2, 1, 1)
//(2, 2)
//(3, 1)
//请注意，顺序不同的序列被视作不同的组合。
// 
//
// 示例 2： 
//
// 
//输入：nums = [9], target = 3
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 1000 
// nums 中的所有元素 互不相同 
// 1 <= target <= 1000 
// 
//
// 
//
// 进阶：如果给定的数组中含有负数会发生什么？问题会产生何种变化？如果允许负数出现，需要向题目中添加哪些限制条件？ 
// Related Topics 数组 动态规划 👍 622 👎 0

class P377_CombinationSumIv{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P377_CombinationSumIv().new Solution();
        System.out.println(solution.combinationSum4(new int[]{3,1,2,4}, 4));
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 首先这是一个排列问题
    // 1.dp[j],表示为： 在重量为j的情况下，有dp[j]中排列方式，且weights[i]可以重复取
    // 2.递推公式，这是一个排列问题，即每种情况都是在前面状态的直接转移，dp[j]+=dp[j-weight[i]]
    // 3.初始化，已知所有的重量都是正数，所以只需要初始化dp[0]=1，其他都为0
    // 4.遍历顺序，已知当前是 排列，所以在同一个重量下，是可以有不同顺序的组合的，即以重量为固定，去遍历所有物品：target=6, {1,5} {5,1}
    // 所以是把背包容量放在外层，物品放在内层
    // 5.举例：nums = [1,2,3], target = 4
    // 0 1 2 3 4  dp[4+1]
    // 1 1 0 0 0  j=1
    // 1 1 2 0 0  j=2
    // 1 1 2 4 0  j=3
    // 1 1 2 4 7  j=4   => dp[target]
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        // 初始化
        dp[0]=1;
        // 遍历，先重量，再物品
        for (int j = 1; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j>=nums[i]){
                    dp[j]+=dp[j-nums[i]];
                }
            }
        }
        return dp[target];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
