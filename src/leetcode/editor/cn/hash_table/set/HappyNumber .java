package leetcode.editor.cn.hash_table.set;

//编写一个算法来判断一个数 n 是不是快乐数。 
//
// 「快乐数」定义为： 
//
// 
// 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。 
// 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。 
// 如果 可以变为 1，那么这个数就是快乐数。 
// 
//
// 如果 n 是快乐数就返回 true ；不是，则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 19
//输出：true
//解释：
//1² + 9² = 82
//8² + 2² = 68
//6² + 8² = 100
//1² + 0² + 0² = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
// Related Topics 哈希表 数学 双指针 👍 766 👎 0
import java.util.*;
class HappyNumber{
    public static void main(String[] args) {
        Solution solution = new HappyNumber().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isHappy(int n) {
        // 题目分析： 1. 根据 对n=2和题目中提示的无限循环 推断出，新生成的数是有循环规律的；
        // 2. 根据条件1，可以判断这题考察 是否存在某元素，可以使用哈希表；由于不需要考虑val，可以使用set
        // 3. 考点3，如何获得数值各个位上的单数

        // 初始化存放元素的set、
        Set<Integer> set = new HashSet<>();
        // 进入循环，不断更新n;
        // 循环的条件：n不等于1 且 平方和数还没有罗列完
        while (n!=1 && !set.contains(n)){
            set.add(n);
            n = getNextNumber(n);
        }
        // n是否能够变为1
        return n==1;

    }

    private int getNextNumber(int n){
        int res = 0;
        // 取数中的每个单数
        // 1. 先求最右那位数
        // 2. 然后计算平方和
        // 3. 最后将n小数点向左移动一位 / 去掉最后一位
        while (n>0){
            int temp = n%10;
            res += temp*temp;
            n = n/10;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}