package leetcode.editor.cn;

//在一个小镇里，按从 1 到 n 为 n 个人进行编号。传言称，这些人中有一个是小镇上的秘密法官。 
//
// 如果小镇的法官真的存在，那么： 
//
// 
// 小镇的法官不相信任何人。 
// 每个人（除了小镇法官外）都信任小镇的法官。 
// 只有一个人同时满足条件 1 和条件 2 。 
// 
//
// 给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示编号为 a 的人信任编号为 b 的人。 
//
// 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的编号。否则，返回 -1。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2, trust = [[1,2]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：n = 3, trust = [[1,3],[2,3]]
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：n = 3, trust = [[1,3],[2,3],[3,1]]
//输出：-1
// 
//
// 示例 4： 
//
// 
//输入：n = 3, trust = [[1,2],[2,3]]
//输出：-1
// 
//
// 示例 5： 
//
// 
//输入：n = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
//输出：3 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1000 
// 0 <= trust.length <= 10⁴ 
// trust[i].length == 2 
// trust[i] 互不相同 
// trust[i][0] != trust[i][1] 
// 1 <= trust[i][0], trust[i][1] <= n 
// 
// Related Topics 图 数组 哈希表 👍 208 👎 0
import java.util.ArrayList;
import java.util.HashMap;
class FindTheTownJudge{
    public static void main(String[] args) {
        Solution solution = new FindTheTownJudge().new Solution();
        int num = 2;
        int[][] trust = new int[][]{{1,2}};
        int res = solution.findJudge(num,trust);
        System.out.println(res);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findJudge(int n, int[][] trust) {

        //1.
        // 记录i是否信任过别人(法官不能信任任何人)
        boolean[] j = new boolean[n + 1];
        // 统计每个人被相信的次数
        int[] count = new int[n + 1];
        for (int[] t:trust) {
            j[t[0]] = true;
            count[t[1]] = count[t[1]] + 1 ;
        }
        // 找到那个被所有人信任，且不信任任何人的法官
        for (int i = 1; i <= n; i++) {
            if (j[i]!=true && count[i]==n-1){
                return i;
            }
        }
        return -1;
        // 1.1  可以做成游戏的形式，用一个一维数组统计（下标表示每个人，值表示被信任次数和信任次数的总和）
        // 被人信任则 +1 ，信任别人则-1，最后值为n-1的则为法官


        // 2.
        // a -> b,即找到出现最多次数的b，且b不会在a的位置
        // 用ArrayList记录没有出现过的 a，用HashMap统计a 在b位置出现的次数
        // 只有一组
//        if (trust.length==0){
//            return n>trust.length+1?-1:n;
//        }
//
//        if (trust.length==1){
//            return trust[0][1];
//        }
//
//        ArrayList list = new ArrayList(trust.length);
//        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
//        // 1. 遍历记录所有 a位置的数，O(n)
//        for (int i = 0; i < trust.length; i++) {
//            int a = trust[i][0];
//            if (list.indexOf(a)==-1){
//                list.add(a);
//            }
//        }
//        // 2. 再次遍历，找到没有出现在a位置的b
//        for (int i = 0; i < trust.length; i++) {
//            int b = trust[i][1];
//            if (list.indexOf(b) == -1){
//                map.put(b,map.getOrDefault(b,0)+1);
//            }
//        }
//        // 3. 统计最多次数的b
//        int max = 0;
//        int num = -1;
//        for (Integer i: map.keySet()){
//            int val = map.get(i);
//            if (max < val){
//                max = val;
//                // 每个a位置的人都信任法官
//                if (max == n-1){
//                    num = i;
//                }
//            }
//        }
//        return num;  //笨比做法 0.0



    }
}
//leetcode submit region end(Prohibit modification and deletion)

}