

package leetcode.editor.cn.backtracking;
//找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。 
//
// 说明： 
//
// 
// 所有数字都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: k = 3, n = 7
//输出: [[1,2,4]]
// 
//
// 示例 2: 
//
// 输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
// 
// Related Topics 数组 回溯 👍 423 👎 0

import java.util.ArrayList;
import java.util.List;

class P216_CombinationSumIii{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P216_CombinationSumIii().new Solution();
        int n=18,k=2;
        System.out.println(solution.combinationSum3(k,n));
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int startidx=1;
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k,n,startidx,n);
        return res;
    }
    public void backtracking(int k,int n,int startidx,int lack){
        // lack + 当前组合总和 = n
        // 终止条件,和为n且长度为k
        if (lack==0 && path.size()==k){
            // 说明找到了符合条件的组合，放入到res中
            res.add(new ArrayList<>(path));
            return;
        } else if (lack < 0) {
            // 剪枝操作，如果总和大于n，则算下去是没意义的
            return;
        }
        // 元素限定在 1-9之间
        for (int i = startidx; i <= n && i<=9; i++) {
            // lack-=i;
            path.add(i);
            backtracking(k,n,i+1,lack-i);   // 递归，如果返回则回溯i和lack
            path.remove(path.size()-1); // 去除最后一个元素
            // lack+=i; // 递归前减了，做回溯要加回去
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
