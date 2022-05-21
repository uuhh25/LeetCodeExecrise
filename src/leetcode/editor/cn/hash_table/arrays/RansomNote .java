package leetcode.editor.cn.hash_table.arrays;

//给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。 
//
// 如果可以，返回 true ；否则返回 false 。 
//
// magazine 中的每个字符只能在 ransomNote 中使用一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：ransomNote = "a", magazine = "b"
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
// 
//
// 
//
// 提示： 
// 用数组存值；将字符转成数字下标，出现次数作为元素的值；两次遍历数组，一次加、一次减；
// 判断数组是否有位置不为0，就可以判断 前者是否包含于后者
// 
// 1 <= ransomNote.length, magazine.length <= 10⁵ 
// ransomNote 和 magazine 由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 计数 👍 259 👎 0
// 判断 ransomNote 是否属于 magazine 吗？
// 用数组做，字符共有26种，则长度26
// 时间复杂度应该是O(n),空间应是O(1)
// 先对magazine进行遍历，然后记录每个字符出现的次数，
// 然后遍历ransomNote中的字符，并且在对应的数组上-1，
// 最后再遍历一次 ransomNote，判断对应数组位置是否都大于等于0，否则返回false
class RansomNote{
    public static void main(String[] args) {
        Solution solution = new RansomNote().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // arrays
        int[] record = new int[26];
        // 遍历magazine，记录个数
        for (char s:magazine.toCharArray()
             ) {
            record[s-'a']++;
        }
        //
        for (char t:ransomNote.toCharArray()
             ) {
            record[t-'a']--;
        }
        //
        for (char t:ransomNote.toCharArray()
             ) {
            if (record[t-'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}