package leetcode.editor.cn.binary_tree;
//94
//二叉树的中序遍历
//给定一个二叉树的根节点 root ，返回它的 中序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[2,1]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1241 👎 0
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Deque;
class BinaryTreeInorderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
        
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stk = new ArrayDeque<>();
        TreeNode cur = root;
//        traversal(root,list);
//        return list;
        // 中序遍历规则，左中右; 先访问二叉树顶部节点，然后一层一层向下访问，直到最左，再开始处理节点
        while (cur!=null || !stk.isEmpty()){
            if (cur!=null){ // 指针来访问节点，访问到最底层
                stk.push(cur); // 将访问的节点放进栈
                cur=cur.left; // 左
            }
            else {
                //
                cur = stk.peek(); // 从栈里弹出的数据，就是要处理的数据（放进result数组里的数据）
                stk.pop();
                list.add(cur.val);  // 中
                cur=cur.right;  // 让节点从跟节点转到右孩子
            }
        }
        return list;
//        Deque<TreeNode> stk = new ArrayDeque<>();
//        List<Integer> list = new ArrayList<>();
//        if (root!=null){stk.push(root);}
//        while(!stk.isEmpty()){
//            // 根据栈内是否有标记，分为两个流程
//            TreeNode node = stk.peek();
//            if(node!=null){
//                stk.pop(); // 防止出现重复节点
//                // 根据右 中 左顺序push节点
//                if(node.right!=null) {stk.push(node.right);}  // 添加右节点（空节点不入栈）
//                stk.push(node);  //中间节点
//                stk.push(null);  // 标记，此题用null做标记 // 中节点访问过，但是还没有处理，加入空节点做为标记。
//                if(node.left!=null) {stk.push(node.left);}  // 添加左节点（空节点不入栈）
//            }
//            else{
//                // 只有遇到空节点的时候，才将下一个节点放进结果集
//                stk.pop();           // 将空节点弹出
//                node = stk.peek();    // 重新取出栈中元素
//                stk.pop();
//                list.add(node.val); // 加入到结果集
//            }
//        }
//        return list;
    }

    //递归三要素，确定递归函数的参数和返回值、确定终止的条件、确定单层递归的逻辑
    // 中序遍历，遍历顺序 左中右
    // 1. 参数是节点和用于存储二叉树结点的容器，不用返回  2. 终止条件，节点为空则终止 3. 中序遍历的逻辑是先中节点 然后左节点 再右节点
    public void traversal(TreeNode root, List<Integer> list){
        // 终止条件
        if (root == null){
            return;
        }
        // 递归逻辑，左中右
        traversal(root.left,list);
        list.add(root.val);
        traversal(root.right,list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}