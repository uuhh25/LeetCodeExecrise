package leetcode.editor.cn.hash_table.arrays;

//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "rat", t = "car"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, t.length <= 5 * 10⁴ 
// s 和 t 仅包含小写字母 
// 
//
// 
//
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
// 定义一个长度为26的数组，即包含了 unicode的 字符；然后数组的下标就能够代表每一个字符，用 char-'a' 就能得到该字符对应的下标
// 1. 遍历第一个字符串时，记录每个字符出现的次数即 [char-'a']++; 2.遍历第二个字符时，每遍历一次字符则在数组上减1；3. 如果最后数组中有不为0的元素，则证明不符合条件
// Related Topics 哈希表 字符串 排序 👍 472 👎 0

// 判断字符出现次数、则多使用哈希表

// 包含小写字母，那么使用数组来做哈希最合适不过
class ValidAnagram{
    public static void main(String[] args) {
        Solution solution = new ValidAnagram().new Solution();
        String s="anagram";
        String t="nagaram";
        System.out.println(solution.isAnagram(s,t));
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        // 使用哈希表，分别计算两个字符串中字符出现的次数？
        // 判断两个哈希表是否相同
        // 1. 字符串长度不同，直接返回false
//        if (s.length() != t.length()){
//            return false;
//        }
//        // 2. 遍历两个字符串   O(2*n)
//        HashMap<Character,Integer> hash1 = new HashMap<Character, Integer>();
//        HashMap<Character,Integer> hash2 = new HashMap<Character, Integer>();
//        for (char c:s.toCharArray()
//             ) {
//            if (hash1.containsKey(c)){
//                hash1.put(c,hash1.get(c)+1);
//            }else {
//                hash1.put(c,1);
//            }
//        }
//        for (char c:t.toCharArray()
//        ) {
//            if (hash2.containsKey(c)){
//                hash2.put(c,hash2.get(c)+1);
//            }else {
//                hash2.put(c,1);
//            }
//        }
//        // 3. 判断两个hash表是否相等
//        if (hash1.equals(hash2)){
//            return true;
//        }
//        return false;

        int[] record = new int[26];
        //1. 遍历第一个字符串时，记录每个字符出现的次数即 [char-'a']++;

        for (char c:s.toCharArray()
             ) {
            record[c-'a']++;
        }
        //2. 遍历第二个字符串时，每遍历一次字符则在数组上减1；

        for (char h:t.toCharArray()
        ) {
            record[h-'a']--;
        }
        //3. 如果最后数组中有不为0的元素，则证明不符合条件
        for (int i:record
             ) {
            if (i!=0){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}