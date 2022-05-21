package leetcode.editor.cn.arrays.binary_methods;

//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 请必须使用时间复杂度为 O(log n) 的算法。 二分
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,3,5,6], target = 5
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,3,5,6], target = 2
//输出: 1
// 
//
// 示例 3: 
//
// 
//输入: nums = [1,3,5,6], target = 7
//输出: 4
// 
//
// 示例 4: 
//
// 
//输入: nums = [1,3,5,6], target = 0
//输出: 0
// 
//
// 示例 5: 
//
// 
//输入: nums = [1], target = 0
//输出: 0
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 为无重复元素的升序排列数组 
// -10⁴ <= target <= 10⁴ 
// 
// Related Topics 数组 二分查找 👍 1233 👎 0

class SearchInsertPosition{
    public static void main(String[] args) {
        Solution solution = new SearchInsertPosition().new Solution();
        int[] nums = new int[]{1, 3, 5, 6};
        int t = 2;
        System.out.println(solution.searchInsert(nums,t));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {
        // 需要判断是否有目标值
        // 一共四种情况
        /*
        目标值在数组所有元素之前
        目标值等于数组中某一个元素
        目标值插入数组中的位置
        目标值在数组所有元素之后
        * */

        // 保持不变量

        // 1. 4.
//        if (target < nums[0] ) {
//            return 0;
//        }
//        else if (target > nums[nums.length - 1]){
//            return nums.length;
//        }

        // 跟普通二分查找不同的是最后一步;右区间是有意义的，
        //
//        int l=0,r = nums.length-1;
//        while (l<=r){
//            // int mid = (l+r)/2;
//            int mid = l + (r-l)/2;  // 防止溢出
//
//            //2.
//            if (nums[mid] == target){
//                return mid;
//            }
//            else if (nums[mid]>target){
//                r = mid-1;
//            }
//            else {
//                l = mid+1;
//            }
//        }
//        //
//		    // 此时的情况应该是，没有目标值，获取的是插入的位置
//        // 2.目标值在数组所有元素之前 3.目标值插入数组中 4.目标值在数组所有元素之后 return right + 1;
//        return r+1;

		    // 这里 右边界r 为 nums.length
		    int l=0,r = nums.length;
		    while (l<r){
				    // int mid = (l+r)/2;
				    int mid = l + (r-l)/2;  // 防止溢出

				    //2.
				    if (nums[mid] == target){
						    return mid;
				    }
				    else if (nums[mid]>target){
						    r = mid;
				    }
				    else {
						    l = mid+1;
				    }
		    }
		    //
		    // 此时的情况应该是，没有目标值，获取的是插入的位置，l<r
		    //  2.目标值在数组所有元素之前 3.目标值插入数组中 4.目标值在数组所有元素之后 return right + 1;
		    return r;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}