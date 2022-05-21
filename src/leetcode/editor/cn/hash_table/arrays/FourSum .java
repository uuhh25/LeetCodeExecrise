package leetcode.editor.cn.hash_table.arrays;

//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 双指针 排序 👍 1065 👎 0
//
//
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
class FourSum{
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
        int[] nums = new int[]{-2,-1,-1,1,1,2,2};
        int target = 0;
        System.out.println(solution.fourSum(nums,target));
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        // 双指针
    // 疑问点：怎么判断重复的元组->利用多指针，最后两个表示左右边界遍历数组，其余的都表示类别，并且要做去重操作；
    // 怎么判定重复的元素，用for循环确定前两个数的和，然后用双指针确定后两个数的和
    // 第一个指针移动时要做去重； target == sum的时候，左右边界收缩 同时去重
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);  // 先排序数组，才能用双指针

        for (int i = 0; i < nums.length; i++) {

            // 去重 1
            if (i>0 && nums[i]==nums[i-1]){
                continue;
            }
            for (int j = i+1; j < nums.length; j++) {
                // 找前两个元素和

                // 去重 2  ;应该是大于 每次j的起点 而不是我写的 1
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left=j+1,right= nums.length-1;
                // 遍历剩下的数组元素
                while (left<right){
                    // 判断左右边界移动
                    int sum=nums[i]+nums[j]+nums[left]+nums[right];
                    if (sum>target){
                        right--;
                    }else if (sum<target){
                        left++;
                    }else {
                        // target==sum
                        // 把list存成元组
                        list.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        // 左右边界先去重，再收缩
                        while (left<right && nums[left]==nums[left+1]) {
                            left++;
                        }
                        while (left<right && nums[right]==nums[right-1]) {
                            right--;
                        }

                        left++;right--;
                    }
                }
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}