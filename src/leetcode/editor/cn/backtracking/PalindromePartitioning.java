

package leetcode.editor.cn.backtracking;
//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 回溯 👍 1004 👎 0

import java.util.ArrayList;
import java.util.List;

class P131_PalindromePartitioning{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P131_PalindromePartitioning().new Solution();
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    int startindex=0;
    public List<List<String>> partition(String s) {
        backtracking(s,0);
        return res;
    }
    // 用回溯，做分割字符串找回文串
    // 写一个判断函数？双指针？ ;按照树状的结构去递归 s
    // 参数：
    // 终止条件，找到叶子节点 => 找到当前切割方式下的所有回文子串
    // 单层逻辑：按照切割来看，判断切割出来的字串是否符合回文的结构；如果符合，则加入到path，并且做横向遍历从当前idx+1开始；如果不符合则接着在当前切割字串下找回文子串；
    // 直到深层遍历到该切割子串的最后
    public void backtracking(String s,int startIndex){
        // 终止条件，切割的位置超过字符串的长度
        if (startIndex>=s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        // 单层逻辑; startIndex 为切割的起点
        for (int i = startIndex; i < s.length(); i++) {
            // 先判断当前切割的,是不是回文子串
            if (isreversed(s,startIndex,i)){
                String sub = s.substring(startIndex,i+1);
                path.add(sub);
                // 如果有回文子串，则进行下一步的切割
                i+=1;   // 下一切割位置，要向右一步，因为已经切割的就不能再切割了
                backtracking(s,i);
                i-=1;   // 回溯
                path.remove(path.size()-1); // 回溯
            }
        }
    }


    public boolean isreversed(String s,int left,int right){
        for (;left<right;left++,right--){
            if (s.charAt(left)!=s.charAt(right)){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
