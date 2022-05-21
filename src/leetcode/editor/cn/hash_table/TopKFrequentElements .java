package leetcode.editor.cn.hash_table;

//347
//前 K 个高频元素
//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 👍 984 👎 0
import java.util.*;

class TopKFrequentElements{
    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements().new Solution();
        int[] nums = new int[]{10,1,1,1,2,2,2,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(solution.topKFrequent(nums, k)));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 1. 统计次数 2. 次数排序 3.截取长度
    // https://programmercarl.com/0347.%E5%89%8DK%E4%B8%AA%E9%AB%98%E9%A2%91%E5%85%83%E7%B4%A0.html
    public int[] topKFrequent(int[] nums, int k) {
        // 1. 用哈希表去遍历并记录元素出现次数
        // 2. 用堆（第一次用，完全二叉树的一种），大顶堆是从大到小的排序，小顶堆是从小到大的排序
        // 然后对比 k 与 堆的长度，弹出相应差值个堆头
        // java中怎么构造堆？
        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // entrySet
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        // 根据map的value值正序排，相当于一个小顶堆； 将键值对存入优先级队列
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        // 遍历map的键值对，
        for (Map.Entry<Integer, Integer> entry : entries) {
            queue.offer(entry);
            // 只保留k个元素
            if (queue.size() > k) {
                queue.poll();
            }
        }
        // 将队元素按照从小到大，倒叙存入数组
        for (int i = k - 1; i >= 0; i--) {
            result[i] = queue.poll().getKey();
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}