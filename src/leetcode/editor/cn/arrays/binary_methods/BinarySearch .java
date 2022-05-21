package leetcode.editor.cn.arrays.binary_methods;

//给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否
//则返回 -1。 
//
// 
//示例 1: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4
// 
//
// 示例 2: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 2
//输出: -1
//解释: 2 不存在 nums 中因此返回 -1
// 
//
// 
//

//
// 
// 你可以假设 nums 中的所有元素是不重复的。 
// n 将在 [1, 10000]之间。 
// nums 的每个元素都将在 [-9999, 9999]之间。 
// 
// Related Topics 数组 二分查找 👍 538 👎 0

// 提示：      前提是数组为有序数组，同时题目还强调数组中无重复元素，因为一旦有重复元素，
//        使用二分查找法返回的元素下标可能不是唯一的，这些都是使用二分法的前提条件
// 1. 左闭右闭即[left, right]，while中 left<=right,因为left==right是有意义的，所以更新right = mid-1
// 2. 左闭右开即[left, right)  while中 left<right, 因为left==right是 没有意义的，所以更新right = mid
// 注意看右区间是否有意义

class BinarySearch{
    public static void main(String[] args) {
        Solution solution = new BinarySearch().new Solution();
        int[] nums = new int[]{-1,0,3,5,9,12};
        int t = 9;
        System.out.println(solution.search(nums,t));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        // 二分查找，缩短时间复杂度；因为是升序，所以只用简单判断是在左边或者是右边
        // 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }

        int len = nums.length;
        int l =0,r=len-1;
        while(l<=r){
            int mid = (l+r)/2;
            if (nums[mid] == target){
                return mid;
            }
            else if (nums[mid]>target){
                r = mid-1;
            }
            else{
                l = mid +1;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}