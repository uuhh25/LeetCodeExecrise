package leetcode.editor.cn;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

//给定一个初始元素全部为 0，大小为 m*n 的矩阵 M 以及在 M 上的一系列更新操作。
//
// 操作用二维数组表示，其中的每个操作用一个含有两个正整数 a 和 b 的数组表示，含义是将所有符合 0 <= i < a 以及 0 <= j < b 的元素
// M[i][j] 的值都增加 1。 
//
// 在执行给定的一系列操作后，你需要返回矩阵中含有最大整数的元素个数。 
//
// 示例 1: 
//
// 
//输入: 
//m = 3, n = 3
//operations = [[2,2],[3,3]]
//输出: 4
//解释: 
//初始状态, M = 
//[[0, 0, 0],
// [0, 0, 0],
// [0, 0, 0]]
//
//执行完操作 [2,2] 后, M = 
//[[1, 1, 0],
// [1, 1, 0],
// [0, 0, 0]]
//
//执行完操作 [3,3] 后, M = 
//[[2, 2, 1],
// [2, 2, 1],
// [1, 1, 1]]
//
//M 中最大的整数是 2, 而且 M 中有4个值为2的元素。因此返回 4。
// 
//
// 注意: 
//
// 
// m 和 n 的范围是 [1,40000]。 
// a 的范围是 [1,m]，b 的范围是 [1,n]。 
// 操作数目不超过 10000。   ???这个条件不是迷惑人吗？？？？？
// 
// Related Topics 数组 数学 👍 121 👎 0
class RangeAdditionIi{
    public static void main(String[] args) {
        Solution solution = new RangeAdditionIi().new Solution();
        int m=4,n=4;
        int[][] ops = {{1,1}};

        int res = solution.maxCount(m,n,ops);
        System.out.println(res);

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        // 这题的目的就是，ops中的数组即从左上角覆盖矩阵的范围，

        // 1. ops为0，则每个值都算是最大值
        if(ops.length==0){
            return m*n;
        }

        // 2. 遍历ops，找到最小的覆盖矩阵
        int minx=ops[0][0],miny=ops[0][1];
        for(int[] arr:ops){
            int x=arr[0],y=arr[1];
//            if (x*y>10000){
//                if (ops.length==1){
//                    return m*n;
//                }
//                continue;
//            }
            if(x<minx){
                minx = x;
            }
            if(y<miny){
                miny=y;
            }
        }
        return minx*miny;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}