package leetcode.editor.cn.string;

//给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。 
//
// 示例 1: 
//
// 
//输入: "abab"
//
//输出: True
//
//解释: 可由子字符串 "ab" 重复两次构成。
// 
//
// 示例 2: 
//
// 
//输入: "aba"
//
//输出: False
// 
//
// 示例 3: 
//
// 
//输入: "abcabcabcabc"
//
//输出: True
//
//解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
// 
// Related Topics 字符串 字符串匹配 👍 592 👎 0

class RepeatedSubstringPattern{
    public static void main(String[] args) {
        Solution solution = new RepeatedSubstringPattern().new Solution();
        String s = "babbabbabbabbab";
        System.out.println(solution.repeatedSubstringPattern(s));;
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        // 怎么找到那个组成的字符串？最长相同前后缀？
        // 在strstr中，我们通过判断 模式串是否指向最后一位来判断, 模式串是否为文本串的子串，
        // 然后返回子串长度 = i - next.length - 1 = i - (next[next.length-1]+1)

        // 在这个题中，数组长度减去最长相同前后缀的长度相当于是第一个周期的长度，如果这个周期可以被整除，就说明整个数组就是这个周期的循环。
        // 最长相同前后缀长度为 next[len-1] +1 ; 为什么加一？因为我们存的next数组是经过右移 -1的
        // 则如果该字符是由重复子串组成，存在 len % (len - next[next.length-1] + 1) = 0

        int len = s.length();
        int[] next=new int[len];
        // 获取存储最长相同前后缀长度的next数组，记得+1； 如果next的最后一值为-1，则说明没有最长相同前后缀
        getNext(next,s);

        // 这个是怎么想出来的啊，牛的
        // 本题难点，怎么找到重复子串的长度！
        // 数组长度减去最长相同前后缀的长度相当于是第一个重复子串的长度，
        // 如果这个周期可以被整除，就说明整个数组就是这个周期的循环。
        if (next[len - 1] != -1 && len % (len-(next[len-1]+1))==0){
            return true;
        }else {
            return false;
        }
    }
    public void getNext(int[] next,String s){
        // 记录位置后移一位，即表示在当前位置下，前一位的最大相同前后缀长度
        int j=-1;
        next[0]=j;
        for (int i = 1; i < s.length(); i++) {
            // 字符不相同
            while (j>=0 && s.charAt(i)!=s.charAt(j+1)){
                j=next[j];  // j回退
            }
            // 字符相同，则两指针移位
            if (s.charAt(i)==s.charAt(j+1)){
                j++;
            }
            // 记录最大相同前后缀长度
            next[i]=j;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}