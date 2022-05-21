

package leetcode.editor.cn;
//给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。 
//
//
// 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。如果存在多种有效的行程，请你按字典排序返回最小的行程组合。 
//
//
// 
// 例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。 
// 
//
// 假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
//输出：["JFK","MUC","LHR","SFO","SJC"]
// 
//
// 示例 2： 
//
// 
//输入：tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL",
//"SFO"]]
//输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
//解释：另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"] ，但是它字典排序更大更靠后。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= tickets.length <= 300 
// tickets[i].length == 2 
// fromi.length == 3 
// toi.length == 3 
// fromi 和 toi 由大写英文字母组成 
// fromi != toi 
// 
// Related Topics 深度优先搜索 图 欧拉回路 👍 533 👎 0

import java.util.ArrayList;
import java.util.List;

class P332_ReconstructItinerary_{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P332_ReconstructItinerary_().new Solution();
        String[][] s = new String[][]{{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"ATL", "SFO"}};
        // String[][] s = new String[][]{{"JFK", "KUL"}, {"JFK","NRT"}, {"NRT","JFK"}};
        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            List<String> path = new ArrayList<>();
            for (int j = 0; j < s[i].length; j++) {
                path.add(s[i][j]);
            }
            lists.add(new ArrayList<>(path));
        }
        System.out.println(solution.findItinerary(lists));
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> result=new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        boolean[] used = new boolean[tickets.size()];
        String des="JFK";
        // result.add(des);
        backtracking(tickets,used,des);
        return result;
    }
    // 要写一个判断自然排序大小的函数
    // 怎么记录机票已经使用呢？ 用一个used数组，true表示已用；fasle表示没用
    // 1. 找到JFK，然后选择自然序号小的那个目的地；并且记录当前行程已使用
    // 2. 到达第一个目的地后，选择自然序号小的那个目的地；并且记录当前行程已使用
    // 先写一个只能做一次连接的

    // 依然用回溯，但是这个回溯是...
    // 1.参数：List,使用数组,当前toi,
    // 2.result的长度==List.size+1 则结束；
    // 3.要用一个String参数表明，当前要找到toi是什么，然后进行for循环找
    // 找到后就传入到List中，如果有多个结果，则先判断哪个自然排序小，则选取哪个，并且记录已经使用过
    //
    void backtracking(List<List<String>> lists,boolean[] used, String desti ){
        // 终止条件？
        if (result.size()==lists.size()){
            // 已经到了最后一个目的地，没下一步了
            result.add(desti);
            return;
        }
        //
        for (int i = 0; i < lists.size(); i++) {
            //
            if (used[i]){
                continue;
            }
//            if (desti.equals(lists.get(i).get(0))){
//                // 如果找到出发点,当前当作只有一次出现的情况
//                // 怎么写才能把所有的结果找出来呢？ 加一个遍历
//                result.add(lists.get(i).get(0));
//                used[i]=true;
//                desti=lists.get(i).get(1);
//                backtracking(lists,used,desti);
//            }
            List<String> path = findPath(lists, used, desti);
            if (path.size()>0){
                result.add(path.get(0));
                desti=path.get(1);
                backtracking(lists,used,desti);
            }
        }
    }

    // 判断自然排序大小的函数
    public boolean compareString(String A,String B){
        // true 表示 A大，fasle表示B大
        if (A.compareTo(B)>=0){
            return true;
        }
        return false;
    }

    // 找到所有相同起点的结果,同样也要判断是否使用过
    public List<String> findPath(List<List<String>> lists,boolean[] used,String desti){
        List<List<String>> strings = new ArrayList<>();
        // 在遍历的过程中，找到最小的
        int idx=0;
        String destination=null;
        // 通过遍历lists，找到所有符合的机票
        for (int i = 0; i < lists.size(); i++) {
            if (used[i]){
                continue;
            }
            String B = lists.get(i).get(0);
            if (desti.equals(B)){
                // 遍历的过程找到最小的目的地
                if (destination==null){
                    destination=lists.get(i).get(1);
                    strings.add(lists.get(i));
                    used[i]=true;
                    idx=i;
                }else {
                    String C = lists.get(i).get(1);
                    // destination 排序大于 C
                    if (compareString(destination,C)){
                        destination=C;
                        used[idx]=false;
                        idx=i;
                        used[i]=true;
                        strings.remove(strings.size()-1);
                        strings.add(lists.get(i));
                    }
                }

            }
        }
        //
//        int idx=0;
//        desti=strings.get(0).get(1);
//        if (strings.size()>1){
//            for (int i = 1; i < strings.size(); i++) {
//                // 找到自然排序最小的那个
//                String B = strings.get(i).get(1);
//                if (compareString(desti,B)){
//                    desti=B;
//                    idx=i;
//                }else {
//
//                }
//            }
//        }
        return strings.get(0);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
