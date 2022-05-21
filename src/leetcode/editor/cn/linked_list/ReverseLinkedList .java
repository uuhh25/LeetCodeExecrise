package leetcode.editor.cn.linked_list;

//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 递归 链表 👍 2166 👎 0

// import leetcode.editor.cn.ListNode;

class ReverseLinkedList{
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 */
static class ListNode{   // 这题不需要定义ListNode
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){this.val=val;}
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
// 思路1： 双指针法，通过反转每个节点的next，遍历一次就完成；先定义一个虚拟头节点，构成双指针
// 思路2： 递归方法，将反转next指针写成一个函数，不停调用，直到访问至最后一个节点


class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode tmp;
        ListNode pre = null;
        // 遍历反转next指针指向
        while (cur!=null){
            tmp = cur.next; // 保存下一节点
            cur.next = pre; // 反转next
            pre = cur;  // 左指针移动
            cur = tmp;  // 右指针移动
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}