

package leetcode.editor.cn;
//给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。 
//
// 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
// 
//
// 示例 2： 
//
// 
//输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
//     注意，你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 
//输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s 和 wordDict[i] 仅有小写英文字母组成 
// wordDict 中的所有字符串 互不相同 
// 
// Related Topics 字典树 记忆化搜索 哈希表 字符串 动态规划 👍 1567 👎 0

import java.util.*;

class P139_WordBreak{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P139_WordBreak().new Solution();
        String[] wordD=new String[]{"apple", "pen"};
        String s="applepenapple";
        List<String> wordDict=Arrays.asList(wordD);
        System.out.println(solution.wordBreak(s,wordDict));
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 这是一个排列、完全背包问题；物品是字符串的字符,重量是字符串的长度
    // 1. dp[i]=true 表示，在长度为i的子串，能够拆分成一个或多个字典里的单词
    // 2. 递推公式，当前为 j，dp[j] 的状态取决于 dp[i]和substring(j,i-j)是否出现在字典
    // if(set.get(part) && dp[i]) dp[j]=true
    // 3. 初始化，因为要判断能拆分才为true，所以全部初始化为false，才能覆盖；
    // 同时，dp[1]取决于dp[0]；且没有长度即不需要排列也能成,dp[0]=true
    // 4. 遍历顺序，因为是排列问题(leetcode != codeleet)，所以先背包重量，再物品
    // 5. 举例，s = "applepenapple", wordDict = ["apple", "pen"]
    // n=13
    // 0 1 2 3 4 5 6 7 8 9 10 11 12 13  直接得最终结果
    // 1 0 0 0 0 1 0 0 1 0 0  0  0  1  => dp[n]
    public boolean wordBreak(String s, List<String> wordDict) {
        //
        int n = s.length();
        Set<String> set=new HashSet<>();
        for (String word:wordDict
             ) {
            set.add(word);
        }
        //
        boolean[] dp=new boolean[n+1];
        dp[0]=true;
        // 先背包，再物品(一个个字符)
        for (int i = 1; i <=n; i++) {
            for (int j = 0; j < i; j++) {
                // 找i-j 这一段子串
                String sub=s.substring(j,i);
                // 判断i-j这一段是否能够在字典找到，同时dp[j]这个状态是不是true
                if (set.contains(sub) && dp[j]){
                    dp[i]=true;
                }
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
