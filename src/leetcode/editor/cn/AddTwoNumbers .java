package leetcode.editor.cn;

//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 👍 7247 👎 0

class AddTwoNumbers {

    public static void main(String[] args) {
        Solution solution = new Solution();

    }
}
class ListNode
{
    int val;
    ListNode next;

    public ListNode(int x){
        val=x;
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 每个结点只存一个数字
        // listnode的访问，每次都是其中的一个结点，若想访问下一个，则调用next；若想访问值，则调用val
        ListNode ln = new ListNode(0);  // 定义一个新的listnode，然后访问第一个结点
        ListNode nl = ln;
        int progress = 0;   // 进位
        // 当前任意节点不为空、或进位不为0 -> 还有下一个节点的内容
        while(l1 != null || l2 != null || progress != 0){
            int l1Val = l1 != null? l1.val : 0;
            int l2Val = l2 != null? l2.val : 0;
            int sumall = l1Val + l2Val + progress;

            progress = sumall/10;   // 是否大于10

            ListNode sumNode = new ListNode(sumall%10); //进位之后剩下的值

            nl.next = sumNode;  // 存储当前计算的新值
            nl = sumNode;   // 把结点位置向后移动一位

            // 访问l1 l2的下一个结点
            if (l1!=null) {
                l1 = l1.next;
            }
            if (l2!=null) {
                l2 = l2.next;
            }
        }
        return ln.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
