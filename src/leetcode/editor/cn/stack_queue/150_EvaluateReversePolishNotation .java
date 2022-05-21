package leetcode.editor.cn.stack_queue;

//根据 逆波兰表示法，求表达式的值。 
//
// 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。 
//
// 
//
// 说明： 
//
// 
// 整数除法只保留整数部分。 /
// 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：tokens = ["2","1","+","3","*"]
//输出：9
//解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
// 
//
// 示例 2： 
//
// 
//输入：tokens = ["4","13","5","/","+"]
//输出：6
//解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
// 
//
// 示例 3： 
//
// 
//输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
//输出：22
//解释：
//该算式转化为常见的中缀算术表达式为：
//  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
//= ((10 * (6 / (12 * -11))) + 17) + 5
//= ((10 * (6 / -132)) + 17) + 5
//= ((10 * 0) + 17) + 5
//= (0 + 17) + 5
//= 17 + 5
//= 22 
//
// 
//
// 提示： 
//
// 
// 1 <= tokens.length <= 10⁴ 
// tokens[i] 要么是一个算符（"+"、"-"、"*" 或 "/"），要么是一个在范围 [-200, 200] 内的整数 
// 
//
// 
//
// 逆波兰表达式： 
//
// 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。 
//
// 
// 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。 
// 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。 
// 
//
// 逆波兰表达式主要有以下两个优点： 
//
// 
// 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。 
// 适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中。 
// 
// Related Topics 栈 数组 数学 👍 450 👎 0

import java.util.Deque;
import java.util.ArrayDeque;
class EvaluateReversePolishNotation{
    public static void main(String[] args) {
        Solution solution = new EvaluateReversePolishNotation().new Solution();
        String[] tokens = new String[]{"3","11","5","+","-"};
        System.out.println(solution.evalRPN(tokens));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int evalRPN(String[] tokens) {
        // 利用栈后进先出的特性，判断当前位置是否为符号位，来选择是push 还是 pop
        // java常用 Deque接口 ArrayDeque类实现栈
        Deque<Integer> stk = new ArrayDeque<>();
        int sum = 0;
        for (String ch:tokens
             ) {
            // 用java的话需要注意判断字符串时不要用 ==，要用equals，可能是提交时的jdk版本老一些吧，String还不能用==

            // 如果sum为空，要先给他赋予初值
            // 计算过程在 条件判断语句里面设置好计算的顺序；为了不纠结顺序，所以把计算得到的数重新丢进栈内
            // 每次遇到操作符都pop两个数出来,先出来的那个数放在后面，后出来的数放前面

            if (isNumber(ch)){
                // 如果不为运算符，则从string转成数组，压入栈
                stk.push(Integer.parseInt(ch));
            }else if ("*".equals(ch)){
                int num1=stk.pop();int num2=stk.pop();
                stk.push(num2*num1);
            }else if ("+".equals(ch)){
                int num1=stk.pop();int num2=stk.pop();
                stk.push(num2+num1);
            }else if ("-".equals(ch)){
                int num1=stk.pop();int num2=stk.pop();
                stk.push(num2-num1);
            }else if ("/".equals(ch)){
                int num1=stk.pop();int num2=stk.pop();
                stk.push(num2/num1);
            }
        }
        return stk.pop();

    }
    public boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}