

package leetcode.editor.cn.backtracking;

import java.util.*;

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
@SuppressWarnings({"all"})
class P332_ReconstructItinerary{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P332_ReconstructItinerary().new Solution();
    }
//力扣代码
    // 本题难点：
    // 1. 怎么在(起飞,降落[]）中找到自然排序最小的那个降落机场
    // 2. 如果是自然排序最小，但是没有新目的地，怎么回溯回去？
    // 3. 如何判断（标记）降落机场是否已经经过
    // => 抽象成树结构；我们要找的就是合理的叶子节点（path.size=tickes.size()+1)
    // => 用一个map来标记所有的 (起飞,降落<String,Integer>)
    // 降落<String,Integer>中的Integer，是降落次数，用于判断是否飞过
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Map<String ,Map<String,Integer>> map = new HashMap<>();
    LinkedList<String> res = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> t : tickets){
            // 把tickets用map进行遍历，以进行后面回溯的工作
            // 对起飞机场的降落进行汇总，并且记录要降落的次数
            Map<String, Integer> temp;
            if(map.containsKey(t.get(0))){
                temp = map.get(t.get(0));
                temp.put(t.get(1), temp.getOrDefault(t.get(1), 0) + 1);
            }else{
                temp = new TreeMap<>();//升序Map
                temp.put(t.get(1), 1);
            }
            map.put(t.get(0), temp);

        }
        // 起飞机场默认是JFK
        res.add("JFK");
        backTracking(map,tickets.size());
        return new ArrayList<>(res);
    }
    // 1.参数，就是一个map,还有终止条件的判断 tickets.size()
    // 2.终止条件,当最后的结果长度 = tickets.size()+1就是找到叶子节点,如果找到叶子节点，返回true；否则返回false
    // 3.单层逻辑
        // 1.首先要初始化map，先遍历tickets
        // 2.然后是在回溯里面进行遍历，用降落次数为判断基准，判断是否使用过;如果“航班次数”大于零，说明目的地还可以飞，如果如果“航班次数”等于零说明目的地不能飞
    boolean backTracking(Map<String,Map<String,Integer>> map,int tickNum){
        // 终止条件
        if (res.size()==tickNum+1){
            return true;
        }
        // 起飞机场
        String s = res.get(res.size()-1);
        if (map.containsKey(s)){
            // 防止null,在对应机场里面，找下一机场
            for (Map.Entry<String,Integer> entry:map.get(s).entrySet()) {
                // 获得对应机场的value中的map键值对,
                int count=entry.getValue();

                if (count>0){
                    // 如果还有降落次数,因为已经对降落机场进行升序，所以可以直接从第一个键值对开始取；依次向后取
                    res.add(entry.getKey());    // 放入到结果中
                    entry.setValue(count - 1);  // 降落一次
                    if(backTracking(map,tickNum)) return true;
                    res.removeLast();   // 就是说上面语句没用找到叶子节点，所以要进行回溯
                    entry.setValue(count);
                }
            }
        }
        // 如果没找到叶子节点
        return false;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
