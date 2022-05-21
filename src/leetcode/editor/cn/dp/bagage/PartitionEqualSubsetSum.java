

package leetcode.editor.cn.dp.bagage;
//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 动态规划 👍 1265 👎 0

class P416_PartitionEqualSubsetSum{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P416_PartitionEqualSubsetSum().new Solution();
        System.out.println(solution.canPartition(new int[]{1,1,1,1}));
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 要找两个 等和 的子集，相当于我们要找到一个子集的和 为 sum/2
    // 那么我们就可以把重点转移到，用dp找出和为sum/2的子集啦！
    // 1. dp，dp[i]表示当前的重量（和）下，能凑到的最大子集和，并且dp的长度是 sum/2
    // 2. 递推公式：我们把该问题直接当作是01背包问题，dp[i]表示当前重量（和），重量是nums[i]，价值也是nums[i]
    // 那么我们的dp[i]就有两种情况，放入新物品后的重量小于等于当前重量，或者是 放入新物品会大于当前重量，即不放入
    // dp[j] = Math.max(dp[j],dp[j-nums[i]]+nums[i])
    // 3. 初始化，首先dp[0]=0，题目给的都是正整数，所以非0下标都初始化为0；如果有负数，那非0下标改为-无穷，因为我们是求和，要保证能够把初始化的值给覆盖
    // 4. 遍历顺序，根据01背包我们得到的结论，外层遍历物体，内层倒序遍历重量;当dp[i]==target的时候，说明找到了和为 sum/2 的子集
    // 5. dp[]={0, 1, 1, 1, 1, 5, 6, 6, 6, 6, 10, 11} => dp[11]=11,true
    //   nums = [1,5,11,5],sum=22,target=11
    public boolean canPartition(int[] nums) {
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        // 如果sum/2不为整数，那肯定找不到;即和为奇数
        if (sum%2 != 0) {
            return false;
        }
        int target=sum/2;
        int[] dp = new int[target+1];   // dp数组长度为 target+1
        // int[] dp = new int[10001];   // 保证dp数组足够长~
        // 开始遍历，外层物体，内层倒序重量
        for (int i = 0; i < nums.length; i++) {
            // j >= nums[i] 剪枝？
            for (int j = target; j >= nums[i]; j--) {
                dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }
        if (dp[target]==target){
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
