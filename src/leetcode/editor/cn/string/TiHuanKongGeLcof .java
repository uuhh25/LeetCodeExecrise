package leetcode.editor.cn.string;

//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// Related Topics 字符串 👍 193 👎 0

class TiHuanKongGeLcof{
    public static void main(String[] args) {
        Solution solution = new TiHuanKongGeLcof().new Solution();
        String s = "We are happy.";
        System.out.println(solution.replaceSpace(s));
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {
        // 字符串不能修改自身，要么改成StringBuffer，要么就转为数组；
        // 从前往后遍历O(n^2)，从后往前 双指针O(n)?
        // 怎么把字符改成字符串？ 理解错意思了，是把一个空格字符 修改成 %20 三个字符
        // 意味着需要把内存空间变大，因为 空格 转成 %20 多了2个字符，则空间变大 2*n
        // 扩容用 字符串 相加的形式 str = str1+str2 生成新字符串
        // 两个指针的位置也很重要，一个是原字符串末尾、一个是扩容字符串末尾，这样才能完整地将字符后移

        // 1. 计算需要扩容的空间
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==' '){
                count++;
            }
        }
        // 2. 字符串扩大，为转化成数组准备
        StringBuffer sadd = new StringBuffer();
        while (count>0){
            // 扩大 2 * 空格数量
            sadd.append("  ");
            count--;
        }
        int left =s.length()-1; // 从原s末尾出发
        s += sadd;
        char[] str = s.toCharArray();
        int right=str.length-1; // 从添加的末尾出发，为了把字符保存，后移
        while (left>=0){
            //  从后向前遍历，所用操作数比从前往后少很多；因为元素的移动次数不同
            if (str[left] == ' '){
                // 找到空格，则开始替换依次的三个字符
                str[right--]='0';
                str[right--]='2';
                str[right]='%';
            }else {
                // 没有空格，则把字符保存，后移
                str[right]=str[left];
            }
            left--;
            right--;


        }


        return new String(str);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}