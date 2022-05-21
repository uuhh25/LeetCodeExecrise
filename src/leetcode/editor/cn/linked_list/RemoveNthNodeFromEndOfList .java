package leetcode.editor.cn.linked_list;

//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 👍 1721 👎 0
// 倒数第n个，正数第size-n个

// import leetcode.editor.cn.ListNode;

class RemoveNthNodeFromEndOfList{
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        
    }

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
// 思路：使用双指针方法，用快慢指针找到要删除节点的前驱节点
// fast指针先走n步，然后两个指针一直走，直到fast到达尾节点  fast一共走n步，slow走size-n步
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);   // 定义虚拟头节点
        dummy.next = head;  // 把虚拟头节点接到链表上
        ListNode slow = dummy;
        ListNode fast = dummy;

        // fast先走n+1步,因为有虚拟头节点
        n+=1;
        while (n!=0 && fast!=null){
            fast=fast.next;
            n--;
        }
        // 一起走 L-n步
        while (fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        // slow当前位置为待删除节点的前驱节点
        // 删除slow的下一个节点
        slow.next = slow.next.next;
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}