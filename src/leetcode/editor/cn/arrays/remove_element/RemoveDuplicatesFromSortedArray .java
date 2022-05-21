package leetcode.editor.cn.arrays.remove_element;

//给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。 
//
// 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。 
//
// 
//
// 说明: 
//
// 为什么返回数值是整数，但输出的答案是数组呢? 
//
// 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。 
//
// 你可以想象内部操作如下: 
//
// 
//// nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：2, nums = [1,2]
//解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,1,1,1,2,2,3,3,4]
//输出：5, nums = [0,1,2,3,4]
//解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3 * 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 已按升序排列 
// 
//
// 
// Related Topics 数组 双指针 👍 2369 👎 0

// 思路：因为数组中元素在内存地址上是连续的，不能单独删除数组中的某个元素，只能覆盖！
// 同时数组是有序数组,则重复的元素肯定是相邻的；
// 用双指针标记，快慢指针：慢指针和慢指针共同找重复的元素，然后快指针去遍历元素，查找不重复的元素来覆盖前面的元素；最后慢指针的位置就是删除重复元素之后的长度
//

class RemoveDuplicatesFromSortedArray{
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedArray().new Solution();
        int[] arr = new int[]{1,1,2};
        System.out.println(solution.removeDuplicates(arr));
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeDuplicates(int[] nums) {
        // 双指针
        int slow =0,fast=1;
        // boundary constrain
        while(fast < nums.length){
            // s 和 f处元素是否相等？相等则f+1；不相等则把fast位置的元素给slow位置，且slow+1,；
            if (nums[slow] != nums[fast]){
                nums[slow+1] = nums[fast];
                slow++;
            }
            fast++;
        }
        // 返回的是数组长度，所以要+1
        return slow+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}