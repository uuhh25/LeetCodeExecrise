

package leetcode.editor.cn.tanxin;
//给你一个非负整数数组 nums ，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 假设你总是可以到达数组的最后一个位置。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 示例 2: 
//
// 
//输入: nums = [2,3,0,1,4]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 贪心 数组 动态规划 👍 1528 👎 0

class P45_JumpGameIi{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P45_JumpGameIi().new Solution();
        int[] n = new int[]{5,3,1,2,0,4};
        System.out.println(solution.jump(n));
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 1. 看跳跃的覆盖范围，
    // 局部最优，每次都尽量往远跳，但是又要注意新的位置的覆盖范围；
    // 整体最优，相当于遍历nums,用最少的挑选次数，来达到覆盖整个数组的范围
    // 思路大概是：在当前的覆盖范围内，找到可跳跃的最远距离；然后如果到了覆盖范围的末尾，则判断在该范围内能否直接到终点
    // 如果可以，则直接直接结束；如果不能则至少需要多走一步，则step++,更新下一个的覆盖范围；
    public int jump(int[] nums) {
        int curDis=0;//
        int step=0;
        int nextDis=0;
        for (int i = 0; i < nums.length; i++) {
            // 对覆盖距离的更新,也可以说是找当前覆盖范围内，的最大下一覆盖范围
            nextDis=Math.max(nums[i]+i,nextDis);
            if (i==curDis){
                // 如果遍历到当前覆盖范围的末尾，则开始判断是否到数组的末尾
                if (curDis!= nums.length-1){
                    // 没到数组末尾，说明至少还需要多跳一步
                    step++;
                    curDis=nextDis; // 多跳一步之后的覆盖范围也变化了
                    if (nextDis>= nums.length-1){
                        // 同时提前判断下一覆盖范围是不是已经到末尾
                        break;
                    }
                }else {
                    // 到数组末尾,则直接结束
                    break;
                }
            }
        }
        return step;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
