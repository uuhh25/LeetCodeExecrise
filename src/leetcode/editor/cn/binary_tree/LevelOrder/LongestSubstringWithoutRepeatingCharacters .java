package leetcode.editor.cn.binary_tree.LevelOrder;

//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 6594 👎 0
import java.util.*;

class LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        String s = "abcabcbb";
        int res = solution.lengthOfLongestSubstring(s);
        System.out.println(res);
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 双指针，右指针移动，左指针用于跳跃; 没做出来
//        // 用hashmap 遍历，相当于枚举法了
//        HashMap<Character, Integer> hash = new HashMap<Character, Integer>(s.length());
//        int count = 0;
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i; j < s.length(); j++) {
//                // 判断是否重复
//                if (hash.containsKey(s.charAt(j))==false){
//                    hash.put(s.charAt(j),j);
//                    if (count<j-i+1){
//                        count = j-i+1;
//                    }
//                }
//                else {
//                    // 清空
//                    hash = new HashMap<Character, Integer>(s.length());
//                    break;
//                }
//            }
//        }
//        return count;

        // 滑动窗口 虚假的滑动窗口
//        int len = s.length();
//        int left = 0;
//        int right = 0;
//        int count = 0;
//        // 遍历
//        ArrayList list = new ArrayList(len);
//        while (right<len){
//            for (int i = left; i < len; i++) {
//                // 判断是否存在这个元素
//                if (list.indexOf(s.charAt(i)) == -1){
//                    list.add(s.charAt(i));
//
//                    if (right-left+1 > count){
//                        count = right-left+1;
//                    }
//
//                    right++; //右边界加1
//                }
//                else {
//                    left++; //左边界+1
//                    right=left;
//                    list.removeAll(list);   //清空链表，重新滑动
//                    break;
//
//                }
//            }
//        }
//        return count;

        // 真实的滑动窗口
        int n = s.length(), ans = 0;
        // 用hashmap当作容器，从而快速检索需要的k、v
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int end = 0, start = 0; end < n; end++) {
            // 获取当前元素
            char alpha = s.charAt(end);
            // 判断是否有重复元素，如果有，则窗口起始移动到重复元素最后一次出现的位置
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            // 计算长度
            ans = Math.max(ans, end - start + 1);

            // 放入该元素至hashmap
            map.put(s.charAt(end), end + 1);
        }
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}