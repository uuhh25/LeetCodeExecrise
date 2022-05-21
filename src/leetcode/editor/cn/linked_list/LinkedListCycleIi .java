package leetcode.editor.cn.linked_list;

//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到
//链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。 
//
// 不允许修改 链表。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [3,2,0,-4], pos = 1
//输出：返回索引为 1 的链表节点
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2], pos = 0
//输出：返回索引为 0 的链表节点
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1], pos = -1
//输出：返回 null
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围在范围 [0, 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// pos 的值为 -1 或者链表中的一个有效索引 
// 
//
// 
//
// 进阶：你是否可以使用 O(1) 空间解决此题？
// 这个真不会，竟然是把题目转成相遇问题

// Related Topics 哈希表 链表 双指针 👍 1295 👎 0

// 思路：通过找节点出现的次数吗?　hashmap?  速度慢，空间大

// 本题考察两个知识点：
// 1.判断链表是否有环；可以使用快慢指针法，定义一个快节点（每次移动两步）、一个慢节点（每次移动一步）；如果链表中有环，则两个指针 必定会相遇
// 2.如果有环，如果寻找环的入口；

class LinkedListCycleIi{
    public static void main(String[] args) {
        Solution solution = new LinkedListCycleIi().new Solution();
        
    }

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// leetcode.editor.cn. leetcode.editor.cn.
public class Solution {
    public ListNode detectCycle(ListNode head) {
//        // 用哈希表记录节点出现的次数
//        HashMap<ListNode,Integer> hash = new HashMap<ListNode,Integer>();
//        ListNode cur = head;
//        // 遍历这个链表，找到第一次出现为2的节点  O(n)
//        while (cur!=null){
//            // 判断是否有这个节点？
//            if (!hash.containsKey(cur)){
//                // 如果不存在，则出现次数加1
//                hash.put(cur,hash.getOrDefault(cur,0)+1);
//            }
//            else {
//                // 如果存在,则次数加1，并且停止循环
//                hash.put(cur,hash.getOrDefault(cur,0)+1);
//                break;
//            }
//            //
//            cur = cur.next;
//        }
//        // 遍历哈希表？找到出现次数为2的那个节点
//        ListNode index = null;
//        for (ListNode n: hash.keySet()
//             ) {
//            if (hash.get(n) == 2){
//                index = n;
//                break;
//            }
//        }
//        return index;

        // 用双指针的方法，1.判断是否有环 2.找到环的起点
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && fast.next!=null){
            // 快指针一次两步、慢指针一次一步;要先走
            fast = fast.next.next;
            slow = slow.next;
            // 是否有环
            if (fast == slow){
                // 找到环的起点，通过模拟得出的式子  x=z+(n-1)*(y+z)
                // -> 不管n是多少，x=z恒成立；n大于1则表明fast指针以相遇位置出发多走了n-1圈

                // 则可以定义两个指针，从头结点和相遇结点同时出发，直到相遇，相遇点即为环入口
                ListNode index1 = fast;
                ListNode index2 = head;
                while (index1!=index2){ // 遍历找到相同节点
                    index1=index1.next;
                    index2= index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}