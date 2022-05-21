

package leetcode.editor.cn.tanxin;
//n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。 
//
// 你需要按照以下要求，给这些孩子分发糖果： 
//
// 
// 每个孩子至少分配到 1 个糖果。 
// 相邻两个孩子评分更高的孩子会获得更多的糖果。 
// 
//
// 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。 
//
// 
//
// 示例 1： 
//
// 
//输入：ratings = [1,0,2]
//输出：5
//解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
// 
//
// 示例 2： 
//
// 
//输入：ratings = [1,2,2]
//输出：4
//解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
//     第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。 
//
// 
//
// 提示： 
//
// 
// n == ratings.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= ratings[i] <= 2 * 10⁴ 
// 
// Related Topics 贪心 数组 👍 811 👎 0

import java.util.Arrays;

class P135_Candy{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P135_Candy().new Solution();
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 一定是要确定一边之后，再确定另一边，例如比较每一个孩子的左边，然后再比较右边，
    // 如果两边一起考虑一定会顾此失彼
    // 贪心是指贪发更少的糖果
    // 局部最优：只要右边的评分比左边高，则右边的孩子就多一个糖果
    // => 全局最优：评分高的右孩子获得比左边孩子更多的糖果
    // 局部最优2：只要左孩子比右孩子评分高，则左边孩子多一个糖果; 从后向前遍历，才能用到从前向后遍历的结果
    // => 全局最优：为了保证这个左孩子即大于左边、又大于右边，则左孩子取(c[i],c[i+1]) +1
    public int candy(int[] ratings) {

        int[] candy = new int[ratings.length];
        candy[0]=1;
        // Arrays.fill(candy,1);
        // 局部1
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i]>ratings[i-1] ){
                candy[i]=candy[i-1]+1;  // 右评分高，则右边孩子多一个糖果
            }else {
                candy[i]=1;
            }
        }
        // 局部2，判断左边孩子和右边孩子
        for (int i = ratings.length-2; i >=0 ; i--) {
            if (ratings[i]>ratings[i+1]){
                // 左孩子 比较 右孩子, 然后在原有的糖果基础上进行变化
                candy[i]=Math.max(candy[i],candy[i+1]+1);
            }
        }
        return Arrays.stream(candy).sum();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
