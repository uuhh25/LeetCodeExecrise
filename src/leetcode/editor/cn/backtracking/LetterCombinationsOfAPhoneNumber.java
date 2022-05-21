package leetcode.editor.cn.backtracking;

// 组合总和
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 👍 1729 👎 0
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class P17_LetterCombinationsOfAPhoneNumber{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P17_LetterCombinationsOfAPhoneNumber().new Solution();
        String digits = "34";
        System.out.println(solution.letterCombinations(digits));
        System.out.println('0'-1);
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    String[] str = new String[]{
        "", // 0
        "", // 1
        "abc", // 2
        "def", // 3
        "ghi", // 4
        "jkl", // 5
        "mno", // 6
        "pqrs", // 7
        "tuv", // 8
        "wxyz", // 9
    };
    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();   // 每一次的临时组合结果
    int idx=0;  // 表示每次横向遍历的新起点，也表示纵向遍历的新起点
    public List<String> letterCombinations(String digits) {
        // 电话号码：是一个映射+组合问题；首先要解决数字键和字母的映射(二维数组、map)；然后是字母之间的组合
        // 根据数字确定数组索引
        if (digits.length()==0){
            return res;
        }
        backtracking(digits,idx);
        return res;
    }
    // 1. 函数及参数，横向遍历的起点idx、
    // 2. 如果数字为 0，1，*，# 则停止递归，直接返回；组合到了 digits.length() 长度就停止
    // 3. 单层逻辑：先确定是哪个数字，然后 确定字符集(则需要将原始字符串加入到回溯函数中) -> 在对应数字下的字符集进行递归组合+回溯
    public void backtracking(String digits,int idx){
        // 终止
        if (idx==digits.length()){
            // 纵向遍历到了叶子节点
            res.add(new String(path));
            return;
        }
        // 单层逻辑： 先获得字符集，再对字符集进行回溯
//        if (digits.charAt(idx)==1 || digits.charAt(idx)== '*'|| digits.charAt(idx)== '#'){
//            return;
//            // 输入是 1 * # 都为异常值,则直接返回
//        }
        int digit =  digits.charAt(idx) - '0';   // 转成int类型的结果
        String charSet = str[digit]; // 选择相应字符集
        for (int i = 0; i < charSet.length(); i++) {
            // 处理，添加到path中
            // idx+=1;
            path.append(charSet.charAt(i));
            // 递归，回溯，注意index+1，因下层要处理下一个数字了
            backtracking(digits,idx+1);
            // 回溯path,idx，去掉最后一个
            // idx-=1;
            path.delete(path.length()-1,path.length());
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
