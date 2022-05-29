package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

class createTreeNode {

    public TreeNode create(Integer[] tree){
        // 2n+1 2n+2
        int len=tree.length;
        TreeNode root=new TreeNode(tree[0]);
        Deque<TreeNode> que=new ArrayDeque<>();
        que.offer(root);
        for (int i = 0; i < tree.length; i++) {
            //
            TreeNode node=que.poll();
            if (node==null) {
                continue;
            }
            // 左、右节点
            if(2*i+1<len && tree[2*i+1]!=null){
                node.left=new TreeNode(tree[2*i+1]);
            }
            if(2*i+2<len && tree[2*i+2]!=null){
                node.right=new TreeNode(tree[2*i+2]);
            }
            // 存左右节点
            if (node.left!=null) {
                que.offer(node.left);
            }
            if (node.right!=null) {
                que.offer(node.right);
            }
        }
        return root;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val){this.val=val;}
    TreeNode(int val,TreeNode left,TreeNode right){this.val=val;this.left=left;this.right=right;}
}
