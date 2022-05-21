package leetcode.editor.cn.string;

// 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
// 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数
// 将返回左旋转两位得到的结果"cdefgab"。
//
// 
//
// 示例 1： 
//
// 输入: s = "abcdefg", k = 2
//输出: "cdefgab"
// 
//
// 示例 2： 
//
// 输入: s = "lrloseumgh", k = 6
//输出: "umghlrlose"
// 
//
// 
//
// 限制： 
//
// 
// 1 <= k < s.length <= 10000 
// 
// Related Topics 数学 双指针 字符串 👍 185 👎 0

class ZuoXuanZhuanZiFuChuanLcof{
    public static void main(String[] args) {
        Solution solution = new ZuoXuanZhuanZiFuChuanLcof().new Solution();
        String s= "abcdefg";
        System.out.println(solution.reverseLeftWords(s,2));
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseLeftWords(String s, int n) {
        // 1.
        // 用一个StringBuffer 用于存放移动的部分？
        // 把移动的加在后面，然后遍历StringBuffer，用于存放新的字符串
//        StringBuffer str = new StringBuffer();
//        for (int i = 0; i < n; i++) {
//            char ch = s.charAt(i);
//            str.append(ch);
//        }
//        String s1 = s+str;
//        for (int i=n;i<s1.length();i++){
//            if (i-n<n){
//                str.setCharAt(i-n,s1.charAt(i));
//            }else {
//                str.append(s1.charAt(i));
//            }
//        }
//        return new String(str);

        // 2.
//        StringBuffer add = new StringBuffer();
//        for (int i = 0; i < n; i++) {
//            add.append(s.charAt(i));
//        }
//        int right=s.length()-1,left=0;
//        s +=add;
//        return s.substring(n);
        // 3. 双指针怎么做呀？ 不用额外空间
        // 使用两次局部反转 + 整体反转 => abcdefg -> (ba)cdefg -> ba(gfedc) -> cdefgab
        // 1.反转前n个
        char[] ch = s.toCharArray();
        int l=0,r=n-1;
        while (l<r){
            char temp = ch[l];
            ch[l]=ch[r];
            ch[r]=temp;
            l++;r--;
        }
        // 2.反转第二部分
        l=n;r=ch.length-1;
        while (l<r){
            char temp = ch[l];
            ch[l]=ch[r];
            ch[r]=temp;
            l++;r--;
        }

        //
        reverse(ch);
        return new String(ch);


    }
    private void reverse(char[] ch){
        int l=0,r=ch.length-1;
        while (l<r){
            char temp=ch[l];
            ch[l]=ch[r];
            ch[r]=temp;
            l++;r--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}