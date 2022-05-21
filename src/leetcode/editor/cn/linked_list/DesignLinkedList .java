package leetcode.editor.cn.linked_list;

//设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针
///引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。 
//
// 在链表类中实现这些功能： 
//
// 
// get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。 
// addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。 
// addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。 
// addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val 的节点。如果 index 等于链表的长度，则该节点将附加
//到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。 
// deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。 
// 
//
// 
//
// 示例： 
//
// MyLinkedList linkedList = new MyLinkedList();
//linkedList.addAtHead(1);
//linkedList.addAtTail(3);
//linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
//linkedList.get(1);            //返回2
//linkedList.deleteAtIndex(1);  //现在链表是1-> 3
//linkedList.get(1);            //返回3
// 
//
// 
//
// 提示： 
//
// 
// 所有val值都在 [1, 1000] 之内。 
// 操作次数将在 [1, 1000] 之内。 
// 请不要使用内置的 LinkedList 库。 
// 
// Related Topics 设计 链表 👍 327 👎 0

class DesignLinkedList{
    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        obj.addAtTail(0);
        System.out.println(obj);
    }

//leetcode submit region begin(Prohibit modification and deletion)
static class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){this.val=val;}
}
static class MyLinkedList {
    int size;
    ListNode head;  // 设置一个虚拟的头节点，虚拟头节点

    // 初始化链表
    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }
    
    public int get(int index) {
        // 如果index大于等于节点数，或者index为负数
        if (index >= size || index <0){
            return -1;
        }
        // 找到第index+1个节点，并且返回val (因为有一个虚拟头节点，所以找第index+1个)
        ListNode cur = head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    //在链表的最后插入一个节点
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    // 在第 index 个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
    // 如果 index 等于链表的长度，则说明是新插入的节点为链表的尾结点
    // 如果 index 大于链表的长度，则返回空
    public void addAtIndex(int index, int val) {
        // 判断index合不合法
        if (index<0){
            index = 0;
        }
        // 超出长度不添加
        if (index>size){
            return;
        }
        size++; //要插入节点，先增加长度
        ListNode pre = head;
        // 找到插入位置的前驱节点
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        // 插入
        ListNode nnode = new ListNode(val);
        nnode.next = pre.next;
        pre.next = nnode;

    }
    
    public void deleteAtIndex(int index) {
        // index 不合法 (小于0 或者 大于等于 长度)
        if (index<0 || index>=size){
            return;
        }
        size--; // 删除一个节点，长度-1
        ListNode pre = head;
        // 找到需要删除节点的先驱
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;

    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)

}