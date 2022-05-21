package leetcode.editor.cn.arrays.element_square;

//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
// 非递减？ 从小到大排序
// 示例 1：

//输入：nums = [-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//解释：平方后，数组变为 [16,1,0,9,100]
//排序后，数组变为 [0,1,9,16,100]
//
// 示例 2：
//
//输入：nums = [-7,-3,2,3,11]
//输出：[4,9,9,49,121]
//

// 提示：
//
//
// 1 <= nums.length <= 10⁴
// -10⁴ <= nums[i] <= 10⁴
// nums 已按 非递减顺序 排序

// 进阶：
//
//
// 请你设计时间复杂度为 O(n) 的算法解决本问题
//
// Related Topics 数组 双指针 排序 👍 379 👎 0

// 思路1，然后遍历array，进行平方计算；再排序
//

class SquaresOfASortedArray{
    public static void main(String[] args) {
        Solution solution = new SquaresOfASortedArray().new Solution();
        int[] nums = new int[]{-4,-1,0,3,10};
        System.out.println(solution.sortedSquares(nums));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortedSquares(int[] nums) {
        // 暴力算法
//        int size = nums.length;
//        for (int i = 0; i < size; i++) {
//            nums[i] *= nums[i];
//        }
//        Arrays.sort(nums);  // 这用的是快排？
////        for (int i = 0; i < size; i++) {
////            for (int j = i+1; j < size; j++) {
////                if (nums[i]<nums[j]){
////                    continue;
////                }
////                int t = nums[i];
////                nums[i] = nums[j];
////                nums[j] = t;
////            }
////        }

        // 双指针，因为数组是从小到大排序，且需要返回同样排序的平方数组；
        // 可知左右两端计算的平方数会是最大，所以设定两个指针，通过大小对比倒序填入到新的数组
        // 左边大，则填左边平方数，并且左指针右移；右边大，则填右边平方数，并且右指针左移
        int l=0,r = nums.length-1;
        int[] n = new int[r+1];
        int k = r;
        while (l<=r){   // l=r时也是有意义，不然就少了一个数
            int a = nums[l];
            int b = nums[r];
            if ( a*a > b*b ){
                n[k--] = a*a;
                l++;
            }
            else {
                n[k--] = b*b;
                r--;
            }
        }
        return n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}