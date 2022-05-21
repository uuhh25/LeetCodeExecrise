package leetcode.editor.cn.linked_list;

//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [], val = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [7,7,7,7], val = 7
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 列表中的节点数目在范围 [0, 10⁴] 内 
// 1 <= Node.val <= 50 
// 0 <= val <= 50 
// 
// Related Topics 递归 链表 👍 761 👎 0

// import leetcode.editor.cn.ListNode;

class RemoveLinkedListElements{
    public static void main(String[] args) {
        Solution solution = new RemoveLinkedListElements().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**单向链表
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// java python 不需要手动释放内存

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // head 是一个链表 的头节点；
        // 1. 删除节点分为两种情况 ；如果是头节点，则把头节点右移一位
        while (head !=null && head.val == val){
            head = head.next;
            // 删除头节点
        }
        // 2. 经过判断头节点是否符合条件后，先判断是否为空
        if (head == null){
            return null;
        }
        // 3. 不为空，则节点迭代，找到要删除的节点
        // 遍历到链表的最后，即最后一个节点的空指针
        ListNode pre = head;    // 保存上一个节点，用于删除节点 / 修改指针指向
        ListNode n = head.next; // 当前的访问：头节点的下一个节点
        while (n !=null){
            if (n.val == val){
                pre.next = n.next;
            }
            else {
                // 当前不是目标节点，则更新访问节点的上一个节点
                pre = n;
            }
            // 访问下一节点
            n = n.next;

        }
        return head;

    }
}
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
//leetcode submit region end(Prohibit modification and deletion)

}