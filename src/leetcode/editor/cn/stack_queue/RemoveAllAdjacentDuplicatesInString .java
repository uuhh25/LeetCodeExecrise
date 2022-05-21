package leetcode.editor.cn.stack_queue;

//给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。 
//
// 在 S 上反复执行重复项删除操作，直到无法继续删除。 
//
// 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。 
//
// 
//
// 示例： 
//
// 输入："abbaca"
//输出："ca"
//解释：
//例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又
//只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 20000 
// S 仅由小写英文字母组成。 
// 
// Related Topics 栈 字符串 👍 315 👎 0

// java用deque接口实现stack
import java.util.ArrayDeque;
import java.util.Deque;
class RemoveAllAdjacentDuplicatesInString{
    public static void main(String[] args) {
        Solution solution = new RemoveAllAdjacentDuplicatesInString().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeDuplicates(String s) {
        // 用栈先进后出的特性，根据判断 当前栈顶元素和当前遍历的字符 是否相同，去判断是不是相邻且且重复字母；
        // 如果是，则跳过当前字符（continue），同时pop栈顶元素
        Deque<Character> stk = new ArrayDeque<>();
        for (char ch:s.toCharArray()
             ) {
            // 判断 两字符 是否相同时，先要判断栈是否为空
            if (stk.isEmpty() || stk.peek()!=ch){
                stk.push(ch);
            }else {
                stk.pop();
            }
        }
        // 把栈内的字符 弹出到数组，然后返回
        char[] ss = new char[stk.size()];
        int size=stk.size();
        while (size-->0){
            // 后进先出，刚好就是在数组的后面
            ss[size]=stk.pop();
        }
        return new String(ss);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}