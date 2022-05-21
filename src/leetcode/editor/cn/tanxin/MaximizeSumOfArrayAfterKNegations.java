

package leetcode.editor.cn.tanxin;
//给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组： 
//
// 
// 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。 
// 
//
// 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。 
//
// 以这种方式修改数组后，返回数组 可能的最大和 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,2,3], k = 1
//输出：5
//解释：选择下标 1 ，nums 变为 [4,-2,3] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,-1,0,2], k = 3
//输出：6
//解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [2,-3,-1,5,-4], k = 2
//输出：13
//解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -100 <= nums[i] <= 100 
// 1 <= k <= 10⁴ 
// 
// Related Topics 贪心 数组 排序 👍 229 👎 0

import java.util.Arrays;

class P1005_MaximizeSumOfArrayAfterKNegations{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1005_MaximizeSumOfArrayAfterKNegations().new Solution();
        int[] n = new int[]{2,-3,-1,5,-4};
        System.out.println(solution.largestSumAfterKNegations(n,2));
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 局部最优：尽可能让负数/最小的值，做-nums[i]；k>负数的个数，则考虑
    // 整体最优：如果每次都是对负数/最小值做相反值，则可以获得最大和；
    public int largestSumAfterKNegations(int[] nums, int k) {
        // 先找负数 和 k的关系
//        Arrays.sort(nums);  // 正序排序
//        int count=0;
//        boolean flag=false;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i]<0){
//                count++;
//            }
//            // 如果有，则存0的位置;并且标记有0
//            if (nums[i]==0){
//                flag=true;
//            }
//        }
//        // 判断负数个数和k的关系
//        if (count > k){
//            for (int i = 0; i < k; i++) {
//                nums[i]=-nums[i];
//            }
//        }else {
//            for (int i = 0; i < count; i++) {
//                nums[i]=-nums[i];
//            }
//            // 找0，如果没有，则找最小值
//            if (!flag){
//                Arrays.sort(nums);
//                for (int i = 0; i < k-count; i++) {
//                    nums[0]=-nums[0];
//                }
//            }
//        }
//        // 求和
//        int sum=0;
//        for (int i = 0; i < nums.length; i++) {
//            sum+=nums[i];
//        }
//        return sum;


        // 其实可以一开始按照绝对值大小来排序，然后从后向前遍历，把负数变为正数
        // 如果k>负数个数，则我们再对最小的那个值反复变换
        AbsquickSort(nums,0, nums.length-1);

        for (int i = nums.length-1; i >=0; i--) {
            if (nums[i]<0 && k>0){
                k--;
                nums[i]=-nums[i];
            }
        }
        // k还有剩
        // 减少次数，如果是奇数则直接取负、如果是偶数则不用管
        if (k%2 == 1){
            nums[0]=-nums[0];
        }
        // 返回
        return Arrays.stream(nums).sum();
    }

    public void AbsquickSort(int[] nums,int left, int right){
        if (left>=right){
            return;
        }
        // 快速排序
        int p = nums[left]; // 选择左边为基准值
        int l = left;
        int r = right;

        // 先判断右、再判断左，如果 l r重合，则结束，并且把基准值放到重合位置
        while (l<r){
            // 右
            while (l<r && Math.abs(nums[r])>=Math.abs(p)){
                r--;
            }
            if (Math.abs(nums[r])<Math.abs(p)){
                // 小的放左边
                nums[l++]=nums[r];
            }
            // 左
            while (l<r && Math.abs(nums[l])<=Math.abs(p)){
                l++;
            }
            if (Math.abs(nums[l])>Math.abs(p)){
                // 大的放右边
                nums[r--]=nums[l];
            }
        }
        // 把基准值放到重合位置
        nums[l]=p;
        // 对左右进行递归
        AbsquickSort(nums,left,l-1);
        AbsquickSort(nums,l+1,right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
