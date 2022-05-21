package leetcode.editor.cn.arrays.remove_element;

//给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。 
//
// 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。 
//
// 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。 
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
//// nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
//int len = removeElement(nums, val);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,2,3], val = 3
//输出：2, nums = [2,2]
//解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 
//nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,2,2,3,0,4,2], val = 2
//输出：5, nums = [0,1,4,0,3]
//解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面
//的元素。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 100 
// 0 <= nums[i] <= 50 
// 0 <= val <= 100 
// 
// Related Topics 数组 双指针 👍 1124 👎 0
//
// 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素
// 思路：删除数组元素 -- 用后面元素进行覆盖； 快慢双指针、暴力解法

class RemoveElement{
    public static void main(String[] args) {
        Solution solution = new RemoveElement().new Solution();
        int[] arr = new int[]{0,1,2,2,3,0,4,2};
        int val =2 ;
        System.out.println(solution.removeElement(arr,val));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeElement(int[] nums, int val) {
        //1. 暴力解法
//        int len = nums.length;  // 动态保存删除元素之后的长度
//        for (int i = 0; i < len; i++) {
//            if (nums[i]==val){
//                for (int j = i+1; j < len; j++) {
//                    nums[j-1]=nums[j];
//                }
//                // 删除了元素，所以长度和索引都会变化
//                len--;
//                i--;
//            }
//        }
//        return len;

        // 2. 双指针，快慢指针；慢指针用于表示长度，快指针去查找匹配的元素位置(遍历)；
        int left=0,right=0;
        // boundary constrain
        while (right < nums.length){
            // 如果有匹配，则fast++；如果不匹配，则slow当前位置元素改为fast当前元素，然后slow++，fast++
            if (nums[right] != val){
                nums[left] = nums[right];
                // 如果结束循环，left已经+1了，所以可以直接表达最后的数组长度
                left++;
            }
            // 当 fast 指针遇到要删除的元素时停止赋值
            // slow 指针停止移动, fast 指针继续前进
            right++;
        }
        // 返回的是数组长度
        return left;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}