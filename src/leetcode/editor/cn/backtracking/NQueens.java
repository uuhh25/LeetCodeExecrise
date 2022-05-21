

package leetcode.editor.cn.backtracking;
//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
// 
// 
// Related Topics 数组 回溯 👍 1247 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class P51_NQueens{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P51_NQueens().new Solution();
        System.out.println(solution.solveNQueens(4).toArray());
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 皇后放置规则 - 不能同行、不能同列、不能同一斜线
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] m = new char[n][n];
        // 把整个矩阵变成 .
        for (char[] mm :
                m) {
            Arrays.fill(mm, '.');
        }
        backtracking(n,0,m);
        return res;

    }
    // 回溯，依然是分解到树上，横向即遍历二维矩阵的列；纵向遍历则遍历二维矩阵的行
    // 1. 参数，n的大小用于横、纵向遍历判断；row 记录纵向遍历的行数；一个二维数组，用于放置Q
    // 2. 终止条件，到叶子节点，然后再判断是否符合规则
    // 3. 单层逻辑，是不是要记录每个Q节点的坐标呢？用来判断符不符合规则，
    // 行、列值作为坐标 => 参数行row，列用每层横向遍历for循环的i来表示；
    //
    // 难点：如何对皇后的情况进行建模 => 回溯，树结构；
    //      皇后位置的约束 => 列、正对角线、反对角线； 行不需要因为一行只会存在一个
    void backtracking(int n,int row, char[][] m){
        // 终止条件
        if (row==n){
            // row记录行数，到达叶子节点
            // 一行一行地存入到list
            ArrayList<String> obj = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                char[] chars = m[i];
                String s = new String(chars);
                obj.add(s);
            }
            res.add(new ArrayList<>(obj));
        }
        // 单层逻辑
        for (int col = 0; col < n; col++) {
            // 先判断这个位置合不合法
            if (isValid(n,row,col,m)){
                m[row][col]='Q';
                backtracking(n,row+1,m);
                // 回溯
                m[row][col]='.';
            }
        }
    }

    boolean isValid(int n,int row,int col, char[][] m){
        // 用坐标判断合不合法; 列、对角线; 行不需要判断，因为每次只会在行停留一会
        // 列
        for (int i = 0; i < n; i++) {
            if (m[i][col]=='Q'){
                return false;
            }
        }

        // 对角线,分为两个方向，45度，135度
        // 135
        for (int i = row-1,j=col+1; i >= 0&&j<=n-1; i--,j++) {
            if (m[i][j]=='Q'){
                return false;
            }
        }
        // 45
        for (int i = row-1,j=col-1; i >= 0&&j>=0; i--,j--) {
            if (m[i][j]=='Q'){
                return false;
            }
        }
        // 都没有遇到
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
