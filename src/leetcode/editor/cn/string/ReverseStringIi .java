package leetcode.editor.cn.string;

//给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcdefg", k = 2
//输出："bacdfeg"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd", k = 2
//输出："bacd"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由小写英文组成 
// 1 <= k <= 10⁴ 
// 
// Related Topics 双指针 字符串 👍 231 👎 0

// 1.每隔2k个字符，则前k个字符进行反转
// 2.剩余字符少于k个，全部反转
// 3.剩余字符大于等于k个小于2k个，则反转前k个

// 可以理解为，把字符串分成若干组 2k长度的子字符串吗? 把遍历的步长加大！

class ReverseStringIi{
    public static void main(String[] args) {
        Solution solution = new ReverseStringIi().new Solution();
        String s = "abcdefg";
        int k = 8;
        System.out.println(solution.reverseStr(s,k));
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseStr(String s, int k) {

        // 按照 size/2k分 n组，每组再根据规则做反转
        char[] st = s.toCharArray();
        // 1. 每隔 2k 个字符的前 k 个字符进行反转
        for (int i = 0; i < st.length; i+=2*k) {
            // 2. 剩余字符大于等于k个小于2k个，则反转前k个
            if (i+k<st.length){
                // 长度为k，起点为i，重点为i+k; 下标为i+k-1
                reverse(st,i,i+k-1);
                continue;
            }
            // 3. 剩余字符少于k个，全部反转
            // 长度为length-i，起点为i，终点为最后
            reverse(st,i, st.length-1);
        }
        return new String(st);

    }

    private void reverse(char[] s, int i,int j){
        // 反转数组
        for (; i < j; i++, j--) {
            char temp  = s[i];
            s[i] = s[j];
            s[j] = temp;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}