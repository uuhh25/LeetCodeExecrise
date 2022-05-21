package leetcode.editor.cn;

//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下： 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// 
//string convert(string s, int numRows); 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "PAYPALISHIRING", numRows = 3
//输出："PAHNAPLSIIGYIR"
// 
//示例 2：
//
// 
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// 示例 3： 
//
// 
//输入：s = "A", numRows = 1
//输出："A"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由英文字母（小写和大写）、',' 和 '.' 组成 
// 1 <= numRows <= 1000 
// 
// Related Topics 字符串 👍 1406 👎 0
import java.util.*;
class ZigzagConversion{
    public static void main(String[] args) {
        Solution solution = new ZigzagConversion().new Solution();
        String s = "PAYPALISHIRING";
        int num = 3;
        String res = solution.convert(s,num);
        System.out.println(res);
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convert(String s, int numRows) {
        // 从上往下、从左至右生成Z字；用多维数组？不会，看答案了
        // numRows 为1时，即不用打乱顺序
        if (numRows <2 ){
            return s;
        }
        // 将字符串按照Z形排列，则会遇到转向，那么我们都就可以根据转向设立 flag，然后将Z形区域分为三个部分（三个数组）

        // 用于保存每行数据
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        // 模拟Z形走位的过程，自上而下，自左到右
        // flag表示是否转向
        int i=0,flag=-1;
        for (char c:s.toCharArray()
             ) {
            // 找到当前是第几行，添加数据
            rows.get(i).append(c);
            // 判断是否需要转向
            if (i==0 || i == numRows-1){
                flag = -flag;
            }
            i+=flag;
        }
        // 定义一个容器，用于连接三个数组
        StringBuilder res = new StringBuilder();
        // 遍历塞入
        for (StringBuilder a:rows
             ) {
            res.append(a);
        } 
        // 返回字符串形式
        return res.toString();



    }
}
//leetcode submit region end(Prohibit modification and deletion)

}