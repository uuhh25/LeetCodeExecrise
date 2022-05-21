

package leetcode.editor.cn.binary_tree.LevelOrder;
//给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。 
//
// 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,null,3,2,4,null,5,6]
//输出：[[1],[3,2,4],[5,6]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
//null,13,null,null,14]
//输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
// 
//
// 
//
// 提示： 
//
// 
// 树的高度不会超过 1000 
// 树的节点总数在 [0, 10^4] 之间 
// 
// Related Topics 树 广度优先搜索 👍 194 👎 0
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class P429_NAryTreeLevelOrderTraversal{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P429_NAryTreeLevelOrderTraversal().new Solution();
    }
    // N叉树的定义
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }
        // 每个根节点都有若干个孩子
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
    public List<List<Integer>> levelOrder(Node root) {
        // 怎么访问结点下的所有child呢
        List<List<Integer>> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        // 应该跟二叉树层序遍历是一样的,N叉树的孩子由list存储
        if (root!=null){
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            //
            int len = queue.size();
            List<Integer> tmplist = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                Node node = queue.poll();   // 获取出队节点
                tmplist.add(node.val);

                List<Node> children = node.children;    // 读取node的所有child集合
                if (children==null || children.size()==0){
                    continue;
                }
                for (Node child:children) {
                    if (child!=null){
                        queue.offer(child);
                    }
                }
            }
            list.add(tmplist);
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
