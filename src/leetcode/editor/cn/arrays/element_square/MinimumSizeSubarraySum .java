package leetcode.editor.cn.arrays.element_square;

//给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
//度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 10⁹ 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 860 👎 0

// 1. 暴力解法，
// 2. 双指针

class MinimumSizeSubarraySum{
    public static void main(String[] args) {
        Solution solution = new MinimumSizeSubarraySum().new Solution();
        int[] arr = new int[]{2,3,1,2,4,3};
        int t = 7;
        System.out.println(solution.minSubArrayLen(t,arr));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // 1/暴力解法：思路：两层循环，遍历每一个子数组
//        int sum=0,len = nums.length;
//        int sumall = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sumall+=nums[i];
//            // 第一层循环表示的是，每个子数组的开头
//            for (int j = i; j < nums.length; j++) {
//                // 找子数组
//                sum += nums[j];
//                if (sum>=target){
//                    if (len>=j-i+1){
//                        len=j-i+1;
//                    }
//                    break;
//                }
//            }
//            // 和重置为0
//            sum=0;
//        }
//        // 如果找不到，返回0
//        if (sumall<target) {
//            return 0;
//        }

        // 2. 双指针方法，可伸缩的滑动窗？第二层不用重新遍历，只需要减去前一段
        int slow =0,fast=0;
        int size = nums.length;
        int sum=0,len=size,all=0;
        // 如果总和都小于target，则直接返回0; O(n)
        for (int i = 0; i < size; i++) {
            all+=nums[i];
        }
        if (all<target){
            return 0;
        }
        // 边界超过则暂停
        //
        while (fast < size){

            // 先求和、循环
            sum+=nums[fast];

            // 再进行判断
            // 如果该窗口和大于 target，则左边界向右移动，总和减去移动前的位置
            if (sum>=target){
                // 记录最短长度
                if (len>=fast-slow+1){
                    len = fast-slow+1;
                }
                sum -= nums[slow++];
                sum -= nums[fast];
                continue;
            }
            fast++;
        }

        return len;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}