package leetcode.editor.cn.arrays.Spiral_Matrix;

//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 矩阵 模拟 👍 552 👎 0
// 顺时针画矩阵过程：1.上行 从左到右 2.右列从上到下 3.下行从右到左 4.左列从下到上
// 本题考察，代码边界的处理；画四条边，可以坚持每条边都遵循左开右闭的原则，则拐角处由新的边来画
// 思路就是一圈套一圈，但是怎么画好每圈很难;(遵循每条边单独画，且每条边的原则统一，如：左开右闭；确定每条边的长度也很重要)

class SpiralMatrixIi{
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int startx=0,starty=0;  // 每一圈开始的位置
        int loop = n/2; // 当前矩阵需要画的圈数
        int count=1;    // 赋值用，从1-n*n
        int mid = n/2;  // n为奇数时，最中间元素会单独空出来，需要单独赋值
        int offset = 1; // 用来控制每圈每条边的长度,初始边长为 n-1;所以offset初始为1,随后每多一圈，offset+2,即需要画的变成-2
        while (loop>0){
            int i = startx;
            int j = starty;

            // 画4条边，用4个for循环
            // 上边，从左到右 -- 列变y 行不变x
            for (; j < starty+n-offset; j++) {
                matrix[i][j] = count++;
            }
            // 右列, 从上倒下 -- 行变x 列不变y
            for (; i < startx+n-offset; i++) {
                matrix[i][j]=count++;
            }
            // 下行，从右到左 -- 列变y，行不变x
            for (; j > starty;j--){
                matrix[i][j]=count++;
            }
            // 左列，从下到上 -- 行变x 列不变y
            for (; i>startx;i--){
                matrix[i][j]=count++;
            }
            // 改变位置，改变画边长度
            loop--;startx++;starty++;offset+=2;
        }
        // 如果n为奇数，则最中间会多出一个位置，放入最后的count
        if (n%2==1){
            matrix[mid][mid]=n*n;   // 或者count
        }
        return matrix;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}