

package leetcode.editor.cn;
//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
// Related Topics 字符串 动态规划 👍 5075 👎 0

class P5_LongestPalindromicSubstring{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P5_LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("ababd"));
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s)
    {
        // 中心扩散法，判断回文子串，就是要判断子串的对应位置是否相同
        // 先向左扩散，如果遇到相同，则left--、长度len++，直至遇到不相同的数
        // 再向右扩散，如果遇到相同，则right++、长度len++，直至遇到不相同
        // 最后是在现在的left right位置出发，如果左右相同，则left-- right++ len+=2
        // 更新最大长度
        // 因为本题是找出最大回文子串，所以还要记录坐标
        int maxLen=0;
        int left,right;
        int maxStart=0;
        int len=1;
        int sLen=s.length();
        for(int i=0;i < sLen;i++){
            // 先把left和right的位置计算出来
            left=i-1;
            right=i+1;
            // 先向左扩散
            while(left>=0 && s.charAt(left)==s.charAt(i)){
                left--;
                len++;
            }
            // 再向右扩散
            while(right<sLen && s.charAt(right)==s.charAt(i)){
                right++;
                len++;
            }
            // 向左右扩散
            while(left >=0 && right<sLen && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
                len+=2;
            }
            // 更新长度
            if (len>=maxLen){
                maxLen=len;
                maxStart=left;
            }
            // 恢复找到的长度
            len=1;
        }
        return s.substring(maxStart + 1, maxStart + maxLen + 1);
    }

    public String longestPalindromeDP(String s)
    {
        // 动态规划的方法，就是牺牲空间换时间，用dp数组，表示当前的子串是否是回文串
        // 1. dp数组，思想跟中心扩散相近，先找到一个起止点，然后向两边扩散; 扩散之后会出现l、r边界，那么就用dp数组，来存两个边界和当前子串是不是回文串
        // dp[l][r]=true,则表示l-r范围的子串是回文子串
        // 2.递推公式，我们是用中心扩散的左右扩散思想，所以可从前一个边界判断是不是回文子串; l=r时，也置为true
        // if (dp[l+1][r-1]==true || r-l<=2) && s.charAt(l)==s.charAt(r)  => dp[l][r]=true
        // 3.初始化，全部都初始化为false; l=r 时，此时 dp[l][r]=true
        // 4.遍历顺序，因为是找子串，所以用两个for循环构造滑动窗口找字符串中的子串
        // 5.举例
        // 6.记录最长长度，和起始的坐标，以返回子串
        int sLen=s.length();
        int maxLen=0,maxStart=0;
        boolean[][] dp = new boolean[sLen][sLen];
        // 遍历
        for (int r = 0; r <= sLen-1; r++) {
            for (int l = 0; l <= r; l++) {
                // 左右扩散位置的字符相同 并且 子串长度为1 或 前一子串是回文子串
                if (s.charAt(l)==s.charAt(r) && (r-l<=2 || dp[l+1][r-1])){
                    dp[l][r]=true;
                    if (r-l+1 > maxLen){
                        maxLen=r-l+1;
                        maxStart=l;
                    }
                }
            }
        }
        return s.substring(maxStart,maxStart+maxLen);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
