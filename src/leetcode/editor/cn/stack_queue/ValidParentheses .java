package leetcode.editor.cn.stack_queue;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 👍 2892 👎 0
import java.util.Deque;
import java.util.ArrayDeque;
class ValidParentheses{
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        String s = "()";
        System.out.println(solution.isValid(s));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        // 这几个括号，他们之间的关系是什么？ 用匹配的关系，赋予另一半;
        // 分析不匹配的情况：1. 左边有多余的括号、2.右边有多余的括号、3.括号的类型不匹配
        Deque<Character> deque = new ArrayDeque<>();    // java中 常用 Deque接口，使用封了一段的双端队列实现 栈
        // 开始遍历该字符，

        // 如果符合条件，则字符的长度肯定是偶数
        if (s.length()%2!=0){
            return false;
        }
        for (char ch:s.toCharArray()
             ) {
            // 找到三种左括号对应的另一半，存入栈中
            if (ch=='('){
                deque.push(')');
            }
            else if (ch=='{'){
                deque.push('}');
            }
            else if (ch=='['){
                deque.push(']');
            }
            // 如果是遍历到的右括号，与对应的左括号类型不符，则返回fasle; 或者是没有左括号 （栈为空）
            else if ( deque.isEmpty() || ch!=deque.peek()){
                return false;
            }else {
                // 如果上述情况都不符合，则表明是统一括号的另一半，出栈
                deque.pop();
            }
        }
        // 如果遍历完了字符串，栈内还有元素，则表明右括号有多余
        return deque.isEmpty();

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}