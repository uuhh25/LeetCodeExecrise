

package leetcode.editor.cn.tanxin;
//假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。 
//
// 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[
//i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。 
// 
//
// 示例 1: 
//
// 
//输入: g = [1,2,3], s = [1,1]
//输出: 1
//解释: 
//你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
//虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
//所以你应该输出1。
// 
//
// 示例 2: 
//
// 
//输入: g = [1,2], s = [1,2,3]
//输出: 2
//解释: 
//你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
//你拥有的饼干数量和尺寸都足以让所有孩子满足。
//所以你应该输出2.
// 
//
// 
//
// 提示： 
//
// 
// 1 <= g.length <= 3 * 10⁴ 
// 0 <= s.length <= 3 * 10⁴ 
// 1 <= g[i], s[j] <= 2³¹ - 1 
// 
// Related Topics 贪心 数组 排序 👍 481 👎 0

import java.util.Arrays;

class P455_AssignCookies{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P455_AssignCookies().new Solution();
        int[] s=new int[]{1,2};
        int[] g=new int[]{1,2,3};
        System.out.println(solution.findContentChildren(g,s));
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // s[j]>=g[i] 表示满足；那我们是不是可以用两层for，进行循环，找到最小的匹配值；如果找到则结果值+1；找不到则换一个换一个孩子
    // 同时还要记录g中饼干是否被使用 => 直接用一个idx，就能保证用过了不再用;两个进行排序吧，这样才能保证能够有局部最有匹配值
    public int findContentChildren(int[] g, int[] s) {
        int count=0;
        Arrays.sort(g);
        Arrays.sort(s);

        // 优先考虑大胃口
//        int idx=s.length-1;
//        for (int i = g.length-1; i >= 0; i--) {
//            int gVal = g[i];
//            if (idx>=0 && gVal<=s[idx]){
//                idx--;
//                count++;
//            }
//        }
//        return count;

        // 可以给s一个自减 / 自增 idx就可以少用一个for循环了
        // 优先考虑小胃口
        int idx=0;
        for (int i = 0; i < s.length; i++) {
            // 只用 idx+g 判断 饼干和胃口的关系
            //
            if (idx<g.length && g[idx]<=s[i]){
                // 移动g的指针，同时计数
                idx++;
                count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
