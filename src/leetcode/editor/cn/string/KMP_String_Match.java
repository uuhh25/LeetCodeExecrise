package leetcode.editor.cn.string;

//实现 strStr() 函数。 
//
// 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如
//果不存在，则返回 -1 。 
//
// 
//
// 说明： 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "hello", needle = "ll"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：haystack = "aaaaa", needle = "bba"
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：haystack = "", needle = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= haystack.length, needle.length <= 5 * 10⁴ 
// haystack 和 needle 仅由小写英文字符组成 
// 
// Related Topics 双指针 字符串 字符串匹配 👍 1202 👎 0

import java.nio.charset.StandardCharsets;

class ImplementStrstr{
    public static void main(String[] args) {
        Solution solution = new ImplementStrstr().new Solution();
        String haystack="mississipi", needle="abcabcabc";
        String s="10";
        Integer i= Integer.parseInt(s);
        System.out.println(solution.strStr(haystack,needle));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        // 耗时太长了
//        // needle 为空，返回0
//        if ("".equals(needle)){
//            return 0;
//        }
//        if (haystack.length()<needle.length()){
//            return -1;
//        }
//        // 先找到开头的字符？然后再继续判断后面的？
//        for (int i = 0; i < haystack.length(); i++) {
//            int c = haystack.charAt(i);
//            if (c == needle.charAt(0)){
//                // 判断是否找到needle开头的字符
//                int idx=i;
//                for (int j = 0; j < needle.length(); j++) {
//                    if ( idx >=haystack.length() ||haystack.charAt(idx) != needle.charAt(j)){
//                        break;
//                    }
//                    idx++;
//                }
//                if (idx-i == needle.length()){
//                    return i;
//                }
//            }
//        }
//        return -1;

        // 不合法情况
        if (needle.length()==0){
            return 0;
        }
        // 字符串匹配，用KMP算法能够更加高效
        // KMP组成部分： next数组 ，用于存放最长相同前后缀，让指针进行回退

        // 获取next数组
        int[] next=new int[needle.length()];
        getNext(next,needle);

        int j=0;
        // 遍历文本串
        for (int i = 0; i < haystack.length(); i++) {
            // 如果字符串不匹配，则j回退
            while (j>0 && haystack.charAt(i)!=needle.charAt(j)){
                j=next[j-1];
            }
            // 如果字符相同，则j++，表明往下一个字符前进
            if (haystack.charAt(i)==needle.charAt(j)){
                j++;
            }
            // 判断是否匹配成功,即指针j指到next数组的最后部分
            if (j==needle.length()-1){
                return i-needle.length()+1;
            }
        }
        return -1;


    }
    public void getNext(int[] next,String s){
        // 计算当前位置的最长相同前后缀
        // 起始位置0，
        int j=0;
        next[0]=j;
        for (int i = 1; i < s.length(); i++) {
            // j从-1开始的，所以包括了 j=0的情况
            while (j>0 && s.charAt(i)!=s.charAt(j)){
                // 前后缀不相同的情况
                j=next[j-1];
            }
            // 前后缀相同的情况，记录长度加1，因为本函数是以j表示前后缀长度，所以j++
            if (s.charAt(i)==s.charAt(j)){
                j++;
            }
            // 记录每个下标的最长相同前后缀
            next[i]=j;
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}