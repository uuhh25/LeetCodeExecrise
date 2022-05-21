package leetcode.editor.cn.hash_table.arrays;

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
//
//
// 示例 1：
//
//
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//
//
// 示例 2：
//
//
//输入：nums = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：nums = [0]
//输出：[]
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 3000
// -10⁵ <= nums[i] <= 10⁵
//
// Related Topics 数组 双指针 排序 👍 4160 👎 0
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
class ThreeSum{
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 怎么判断元组是否重复？ 用3个指针，第一个指针的位置就是元组的类别，第二、第三个指针做左右边界，主遍历作用，判断左右边界移动的条件是：三个指针对应的值总和 > < = target
    // 初步思路：先存前两个数的和，然后重新遍历数组，判断是否存在 0-a-b；不好做....

    // 提供思路：首先是对数组进行排序；然后用三个指针，一个对应类别，其余两个用于遍历寻找元素，左右边界移动条件为 三个指针对应值总和与target的关系
    // 去重：第一个坐标指针为i且i>0，若nums[i]==nums[i-1]表明会生成重复的元组
    public List<List<Integer>> threeSum(int[] nums) {
        // 不合法情况
        // 开始遍历数组

        // 初始化一个需要返回的多元list
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  //排序数组，排除一些不需要循环的情况
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0){
                return result;
            }

            // 元组去重
            if (i>0 && nums[i]==nums[i-1]){
                continue;
            }

            // 开始遍历
            int left=i+1,right= nums.length-1;
            // 在当前类别下遍历数组，直到左右指针重合
            while (right>left){
                // 求和，判断左右边界的移动
                int sum = nums[i] + nums[left]+nums[right];
                if (sum>0){
                    // 如果总和大于0，因为排序过，所以可以判断最右元素太大了，右指针收缩
                    right--;
                }else if (sum<0){
                    // 如果总和小于0，因为排序过，所以可以判断最左元素太小了，左指针收缩
                    left++;
                }else {
                    // 这个情况表示 sum=0，把三个坐标存入到list，并且存入到result中
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));  //Arrays.asList  先存成数组，再转list

                    // 再次去重
                    while (right>left && nums[right]==nums[right-1]) {
                        right--;
                    }
                    while (right>left && nums[left]==nums[left+1]) {
                        left--;
                    }

                    // 去重之后再收缩
                    right--;
                    left++;
                }
            }

        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}