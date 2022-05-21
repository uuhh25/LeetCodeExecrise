

package leetcode.editor.cn.tanxin;
//给定一个数组 prices ，其中 prices[i] 表示股票第 i 天的价格。 
//
// 在每一天，你可能会决定购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以购买它，然后在 同一天 出售。 
//返回 你能获得的 最大 利润 。 
//
// 
//
// 示例 1: 
//
// 
//输入: prices = [7,1,5,3,6,4]
//输出: 7
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
// 
//
// 示例 2: 
//
// 
//输入: prices = [1,2,3,4,5]
//输出: 4
//解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3: 
//
// 
//输入: prices = [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 3 * 10⁴ 
// 0 <= prices[i] <= 10⁴ 
// 
// Related Topics 贪心 数组 动态规划 👍 1635 👎 0

class P122_BestTimeToBuyAndSellStockIi{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P122_BestTimeToBuyAndSellStockIi().new Solution();
        int[] n = new int[]{7,1,5,3,6,4};
        System.out.println(solution.maxProfit(n));
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 我可以理解为  找数组中的  上升区间嘛？
    // 每一个上升区间都是局部最优？ => 拥有全部上升区间则全局最优？
    // 先遍历一遍数组，记录上升区间的左右位置？然后再计算最大利润？
    // 如果有连续重复元素，也算作上升区间
    public int maxProfit_(int[] prices) {
        int count=0;
        // 先遍历数组，找上升区间的位置
        boolean[] flag = new boolean[prices.length];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i]>=prices[i-1]){
                flag[i]=true;
            }
        }
        // 根据上升区间的位置，求和，获得每个局部最优
        for (int i = 1; i < flag.length; i++) {
            if (flag[i]){
                count+=(prices[i]-prices[i-1]);
            }
        }
        return count;

    }

    public int maxProfit(int[] prices) {
        // 题解，找局部最优起始可以以每两个为一个单位，那么我们先把每两天之间的利润算好
        // 再从利润中挑选正的加在一起，就是我们能达到的最大利润了
        int count=0;
        for (int i = 0; i < prices.length-1; i++) {
            count+=Math.max(0,prices[i+1]-prices[i]);
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
