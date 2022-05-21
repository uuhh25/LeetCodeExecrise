package leetcode.editor.cn.linked_list;

// import leetcode.editor.cn.ListNode;

//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
// Related Topics 递归 链表 👍 1177 👎 0
// 思路，用双指针完成固定长度和步长的滑动窗，滑动窗内进行元素交换; 使用虚拟头节点，方便返回头节点
class SwapNodesInPairs{
    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
        ListNode head = new ListNode(0);
        System.out.println(solution.swapPairs(head));
    }

//leetcode submit region begin(Prohibit modification and deletion)
public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */ // 题解
// https://programmercarl.com/0024.%E4%B8%A4%E4%B8%A4%E4%BA%A4%E6%8D%A2%E9%93%BE%E8%A1%A8%E4%B8%AD%E7%9A%84%E8%8A%82%E7%82%B9.html#%E6%80%9D%E8%B7%AF
class Solution {
    public ListNode swapPairs(ListNode head) {
        // 1. 使用虚拟头节点  2.元素交换之后，修改下一需要修改的节点的开头
        ListNode dummy = new ListNode(0);
        dummy.next = head;  // 给输入链表设置一个虚拟头节点
        ListNode pre = dummy;   // 以虚拟头节点为前驱节点
        ListNode tmp;   // 临时过渡节点
        while (pre.next !=null && pre.next.next != null){   // 即需要交换的两个节点不得为
            //
            tmp = head.next.next;   // 存储下一段的首个节点
            pre.next = head.next;   // 将第二个节点移动到前面
            head.next.next = head;  // 修改移动到前面节点的指针指向
            head.next = tmp;    // 修改移动到后面节点的指针指向

            // 移动窗口到下一需要修改的节点
            pre = head; // head被移动到后面，即下一窗口的虚拟头节点从head开始
            head = head.next;   // 开始下一窗口
        }
        return dummy.next;   // 返回修改后链表的头节点,dummy为虚拟头节点，所以需要返回dummy.next
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}