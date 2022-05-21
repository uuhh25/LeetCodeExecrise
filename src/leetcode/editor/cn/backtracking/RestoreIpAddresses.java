

package leetcode.editor.cn.backtracking;
//有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
// 
//
// 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新
//排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅由数字组成 
// 
// Related Topics 字符串 回溯 👍 817 👎 0

import java.util.ArrayList;
import java.util.List;

class P93_RestoreIpAddresses{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P93_RestoreIpAddresses().new Solution();
        System.out.println(solution.restoreIpAddresses("25525511135"));
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        // 剪枝
        if (s.length() > 12) {
            return res;
        }
        backtracking(s,0,0);
        return res;

    }
    // 回溯，参数：字符串，切割位置，当前段数记录（也可以设置成全局的）
    // 2.终止条件，已经分了4段，=>加入到list中
    // 3.单层逻辑，1.先判断分割的字段是否合法，
    // 如果合法=>在切割的位置，加上一个分割点. ，并且记录当前分段数量；进入递归，下一切割的位置从i+2开始；回溯，去掉 . ，段数-1
    void backtracking(String s, int cutIdx, int pointSum){
        // 终止条件,已经有四段且最后一段也合法
        if (pointSum == 3 ) {
            if (isValid(s,cutIdx,s.length()-1)){
                res.add(s);
            }
            return;
        }
        // 单层逻辑
        for (int i = cutIdx; i < s.length(); i++) {
            // 先判断合法
            if (isValid(s,cutIdx,i)){
                pointSum++;
                s = s.substring(0,i+1)+'.'+s.substring(i+1);
                backtracking(s,i+2,pointSum);
                // 回溯
                s=s.substring(0,i+1)+s.substring(i+2);
                pointSum--;
            }else {
                break;
            }
        }
    }

    public boolean isValid(String s, int i, int j){
        // 判断切割的字段是否符合 网关
        // 开头不为0、字段中有非数字、值超过255
        if (i > j) {
            return false;
        }
        if (s.charAt(i)=='0' && i!=j ){
            return false;
        }
        int num=0;  // 记录该字段的值
        for (int k = i; k <= j; k++) {
            if (s.charAt(k) > '9' || s.charAt(k) < '0') {
                return false;
                // 有非数字出现
            }
            num=num*10 + (s.charAt(k)-'0');
            if (num > 255) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
