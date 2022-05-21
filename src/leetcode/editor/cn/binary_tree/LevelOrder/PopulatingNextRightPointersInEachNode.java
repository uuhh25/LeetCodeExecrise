

package leetcode.editor.cn.binary_tree.LevelOrder;
//给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下： 
//
// 
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//} 
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。 
//
// 初始状态下，所有 next 指针都被设置为 NULL。 
//
// 
//
// 进阶： 
//
// 
// 你只能使用常量级额外空间。 
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。 
// 
//
// 
//
// 示例： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,6,7]
//输出：[1,#,2,3,#,4,5,6,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 
//next 指针连接，'#' 标志着每一层的结束。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数量少于 4096 
// -1000 <= node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 656 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class P116_PopulatingNextRightPointersInEachNode{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P116_PopulatingNextRightPointersInEachNode().new Solution();
        int[] nums = new int[]{1,2,3,4,5,6,7};
    }
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        // 就是把所有的node连接起来
        // 依然是层序遍历，用队列实现；
        // 还是一层一层地来，如果当前队列peek为null，则当前node.next为null；否则node.next指向peek的node
        // 每层的最后一个node.next直接给null，不然容易跟其他的节点连起来
        List<Node> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if (root!=null){
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            int len = queue.size(); // 当前层的节点个数
            while (len>0){
                Node node = queue.poll();
                // 先处理next指针
                if (queue.peek()!=null && len!=1){
                    node.next = queue.peek();
                }else {
                    node.next=null;
                }
                // 先左孩子，再右孩子
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
                len--;
            }
        }
        return root;    // 为什么返回的是一个root？ 返回整棵树？
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
