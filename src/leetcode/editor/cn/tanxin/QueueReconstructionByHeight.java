

package leetcode.editor.cn.tanxin;
//假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i 
//个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。 
//
// 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第
// j 个人的属性（queue[0] 是排在队列前面的人）。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
//输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
//解释：
//编号为 0 的人身高为 5 ，没有身高更高或者相同的人排在他前面。
//编号为 1 的人身高为 7 ，没有身高更高或者相同的人排在他前面。
//编号为 2 的人身高为 5 ，有 2 个身高更高或者相同的人排在他前面，即编号为 0 和 1 的人。
//编号为 3 的人身高为 6 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
//编号为 4 的人身高为 4 ，有 4 个身高更高或者相同的人排在他前面，即编号为 0、1、2、3 的人。
//编号为 5 的人身高为 7 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
//因此 [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] 是重新构造后的队列。
// 
//
// 示例 2： 
//
// 
//输入：people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
//输出：[[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= people.length <= 2000 
// 0 <= hi <= 10⁶ 
// 0 <= ki < people.length 
// 题目数据确保队列可以被重建 
// 
// Related Topics 贪心 数组 排序 👍 1202 👎 0

import java.util.Arrays;
import java.util.LinkedList;

class P406_QueueReconstructionByHeight{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P406_QueueReconstructionByHeight().new Solution();
    }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 先用hi来进行排序？hi相同时则看ki大小
    // 因为有两个维度，所以我们要先把一个维度确定好，再处理第二个维度
    // 如果先按照k排列,则排完之后,h还是乱序的,而h移动之后,k又乱序了
    // 所以选择先排h;又因为这道题的k是说前面有k个大于等于的数,那我们就应该对h进行从大到小的排序
    // 然后,再从前到后,根据k的值,插入到对应的位置
    public int[][] reconstructQueue(int[][] people) {
        // 按照身高进行排序,身高相同时,按照k大小排序
        Arrays.sort(people,(a,b)->{
            if (a[0]==b[0]) {
                return a[1]-b[1];
            }
            return b[0]-a[0];
        });

        // 因为我要做插入的操作,如果用数组的话,会很麻烦,因为每次都要移动
        // 所以可以选择使用链表
        LinkedList<int[]> que = new LinkedList<>();
        for (int[] ele:people
             ) {
            que.add(ele[1],ele);
        }

        // list转为array
        return que.toArray(new int[people.length][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
