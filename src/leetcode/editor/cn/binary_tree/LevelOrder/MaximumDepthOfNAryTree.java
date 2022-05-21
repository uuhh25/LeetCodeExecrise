

package leetcode.editor.cn.binary_tree.LevelOrder;
//给定一个 N 叉树，找到其最大深度。 
//
// 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。 
//
// N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,null,3,2,4,null,5,6]
//输出：3
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
//null,13,null,null,14]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树的深度不会超过 1000 。 
// 树的节点数目位于 [0, 10⁴] 之间。 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 👍 248 👎 0
import java.util.List;

class P559_MaximumDepthOfNAryTree{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P559_MaximumDepthOfNAryTree().new Solution();
    }
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
//        // 最简单的方法就是层序遍历
//        Queue<Node> queue = new LinkedList<>();
//        if (root != null) {
//            queue.offer(root);
//        }
//        int depth=0;
//        while (!queue.isEmpty()) {
//            //
//            depth++;
//            int len = queue.size();
//            for (int i = 0; i < len; i++) {
//                Node node = queue.poll();
//                List<Node> children = node.children;    // 孩子都放在一个list中
//                for (Node child:children) {
//                    // 把所有child放入队列
//                    queue.offer(child);
//                }
//            }
//        }
//        return depth;
        return getDepth(root);
    }
    // 递归
    // 1.输入参数，N叉树结点；返回类型 int； public int getDepth(Node node)
    // 2.终止条件，结点为空 List<Node> children==null
    // 3.单层逻辑； 我们是找根节点的N个子树深度中的最大深度; 找最大的那个值+1
    public int getDepth(Node node){

        int depth=0;
        // 终止条件
        if (node == null) {
            return depth;
        }
        // 获取N个子树
        List<Node> children = node.children;
        // 通过对比，找最大值
        for (Node child:children) {
            //
            int d = getDepth(child);    // 调用递归函数，求每一个子树的深度
            depth = Math.max(d,depth);
        }
        return depth+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
