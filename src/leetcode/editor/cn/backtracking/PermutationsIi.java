

package leetcode.editor.cn.backtracking;
//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 数组 回溯 👍 978 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class P47_PermutationsIi{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P47_PermutationsIi().new Solution();
        int[] nums = new int[]{1,1,2};
        System.out.println(solution.permuteUnique(nums));
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        // 用第二种方法的话需要进行排序
        // Arrays.sort(nums);
        backtracking(nums,used);
        return res;
    }
    // 本题排列，和46题是差不多的，只要在纵向遍历的时候，坐标都是从0开始，所以不需要startidx
    // 同时要标记使用过的元素，所以用一个数组进行标记纵向遍历时，元素的使用
    // 这题新增的条件是，返回所有不重复的全排列， => 横向遍历时，判断是不是横向遍历，且是不是重复；
    // 因为这个题没有startidx，所以不能像之前那样判断是不是重复 => for循环前,用一个数组标记同层元素是不是用过
    // 1.参数 数组、标记数组
    // 2.path长度等与nums的长度时，就结束，并且加入到res中；

    void backtracking(int[] nums,boolean[] used){
        // 终止条件
        if (path.size()== nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        boolean[] layer = new boolean[21];  // 用于判断元素是不是用过
        // 单层逻辑, 每次都从头开始
        for (int i = 0; i < nums.length; i++) {
            // 判断是不是横向遍历用过, 再判断当前元素是否在纵向遍历用过
            if (layer[nums[i]+10] || used[i]){
                // 为什么要加一个layer呢？因为只用我这种used的话，没有办法区别同一个值是否用过
                // 并且这个方法可以不需要对原数组进行排序
                continue;
            }
            layer[nums[i]+10]=true;
            // 开始回溯过程
            used[i]=true;
            path.add(nums[i]);
            backtracking(nums,used);
            path.remove(path.size()-1);
            used[i]=false;
        }
    }
    // 1.参数 数组、标记数组
    // 2.path长度等与nums的长度时，就结束，并且加入到res中；
    // 3.题解的思路 = 用一个跟nums等长的数组；同时完成 树层去重（横向），和 判断纵向时元素是否使用过
    void backtracking2(int[] nums,boolean[] used){
        // 终止条件
        if (path.size()== nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        // boolean[] layer = new boolean[21];  // 用于判断元素是不是用过
        // 单层逻辑, 每次都从头开始
        for (int i = 0; i < nums.length; i++) {
            // 判断是不是横向遍历用过
            // used[i - 1] == true，说明同一树枝nums[i - 1]使用过
            // used[i - 1] == false，说明同一树层nums[i - 1]使用过
            if ((i > 0 && (nums[i] == nums[i - 1]) && (used[i - 1]) == false)){
                continue;
            }
            if (used[i]==false){
                // 开始回溯过程
                used[i]=true;
                path.add(nums[i]);
                backtracking2(nums,used);
                path.remove(path.size()-1);
                used[i]=false;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
