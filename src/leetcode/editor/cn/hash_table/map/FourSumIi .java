package leetcode.editor.cn.hash_table.map;

//给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足： 
//
// 
// 0 <= i, j, k, l < n
// nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
//输出：2
//解释：
//两个元组如下：
//1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1)
// + 2 = 0
//2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1)
// + 0 = 0
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
//输出：1
// 
//
// 
//
// 提示： 
//
// 每个数组的长度相同
// n == nums1.length 
// n == nums2.length 
// n == nums3.length 
// n == nums4.length 
// 1 <= n <= 200 
// -2²⁸ <= nums1[i], nums2[i], nums3[i], nums4[i] <= 2²⁸ 
// 
// Related Topics 数组 哈希表 👍 469 👎 0
// 因为要位置信息，应是用map吧，存元素同时存次数；只会暴力解法... O(n^4)
// 题解的方法是，降低时间复杂度为 O(n^2)，只用一个哈希表；两个数组为一组求和，记录相同和出现的次数，用以求得的哈希表，统计差值出现的次数

import java.util.HashMap;
import java.util.Map;
class FourSumIi{
    public static void main(String[] args) {
        Solution solution = new FourSumIi().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map = new HashMap<>();
        int temp,res=0;
        // 求前两个数组的和及出现次数，存入哈希表
        for (int i:nums1) {
            for (int j:nums2) {
                temp = i+j;
                if (map.containsKey(temp)){
                    map.put(temp,map.get(temp)+1);
                }
                else {
                    map.put(temp,1);
                }
            }
        }
        // 用以求得的哈希表，统计差值出现的次数
        // 统计剩余的两个元素的和，在map中找是否存在相加为0的情况，同时记录次数
        for (int i : nums3) {
            for (int j : nums4) {
                temp = i + j;
                if (map.containsKey(0 - temp)) {
                    res += map.get(0 - temp);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}