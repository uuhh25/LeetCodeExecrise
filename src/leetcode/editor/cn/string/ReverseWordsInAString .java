package leetcode.editor.cn.string;

//给你一个字符串 s ，逐个翻转字符串中的所有 单词 。 
//
// 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。 
//
// 请你返回一个翻转 s 中单词顺序并用单个空格相连的字符串。 
//
// 说明： 
//
// 
// 输入字符串 s 可以在前面、后面或者单词间包含多余的空格。 
// 翻转后单词间应当仅用一个空格分隔。 
// 翻转后的字符串中不应包含额外的空格。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "the sky is blue"
//输出："blue is sky the"
// 
//
// 示例 2： 
//
// 
//输入：s = "  hello world  "
//输出："world hello"
//解释：输入字符串可以在前面或者后面包含多余的空格，但是翻转后的字符不能包括。
// 
//
// 示例 3： 
//
// 
//输入：s = "a good   example"
//输出："example good a"
//解释：如果两个单词间有多余的空格，将翻转后单词间的空格减少到只含一个。
// 
//
// 示例 4： 
//
// 
//输入：s = "  Bob    Loves  Alice   "
//输出："Alice Loves Bob"
// 
//
// 示例 5： 
//
// 
//输入：s = "Alice does not even like bob"
//输出："bob like even not does Alice"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 包含英文大小写字母、数字和空格 ' ' 
// s 中 至少存在一个 单词 
// 
//
// 
// 
//
// 
//
// 进阶： 
//
// 
// 请尝试使用 O(1) 额外空间复杂度的原地解法。 
// 
// Related Topics 双指针 字符串 👍 423 👎 0

class ReverseWordsInAString{
    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAString().new Solution();
        String s = "S D N E I F R";
        System.out.println(solution.reverseWords(s));

        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        // 两个任务：第一个是翻转单词位置，第二个是去掉多余的空格
        // 翻转单词可以用双指针，先整体翻转，再逐个单词进行翻转；如果快指针的下一位是空格，则翻转
        // 怎么去除多余的空格呢？ 从后向前遍历，移动元素吗
        char[] st = s.toCharArray();
        // 1.翻转单词
        int slow = st.length-1,fast=st.length-1;
        while (fast>=0){ // O(n)
            if (fast-1<0 || st[fast-1]==' '){
                int left=fast;
                while (slow>left){
                    char temp=st[slow];
                    st[slow]=st[left];
                    st[left]=temp;
                    slow--;
                    left++;
                }
                fast--; // 移动fast到空格位置，然后判断下一个是不是空格
                // 移动起始位置
                while (fast>0 && st[fast]==' '){
                    // 让fast指针跳过空格位置
                    fast-=1;
                }
                slow=fast;
                continue;   // 要加一个continue ，不然还会再移动一次
            }
            fast--;
        }
        // 翻转整个数组
        slow=0;fast=st.length-1;
        while (slow<fast){
            char temp = st[slow];
            st[slow]=st[fast];
            st[fast]=temp;
            slow++;fast--;
        }

        // 转成字符串
        String ss = new String(st);

        // 2. 去除多余的空格 -- 空间复杂度为O（1）的解法我做不出来；
        // 原地修改应该是用StringBuffer吧？
        // 用一个新的数组，去除重复的空格
        StringBuffer ss_n = new StringBuffer();
        // 去除收尾空格
        int start=0,end=ss.length()-1;
        while (ss.charAt(start)==' ') {
            start++;
        }
        while (ss.charAt(end)==' ') {
            end--;
        }
        // 遍历中间字符，去除重复的空格
        while (start<=end){
            // 要么当前字符不是空格，要么这是单词后面接的第一个空格
            if (ss.charAt(start)!=' ' || ss_n.charAt(ss_n.length()-1)!=' '){
                ss_n.append(ss.charAt(start));
            }
            start++;
        }

        return new String(ss_n);


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}