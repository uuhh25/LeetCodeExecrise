package leetcode.editor.cn.hash_table.set;

//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 458 👎 0
// 思路1：暴力解法 -- 两个for循环，存入数组，然后删除重复元素
// 思路2：两个哈希表，第一个存数组1的元素，第二个则遍历数组2 同时判断该元素是否存在数组1，然后将第二个哈希表的键放入数组
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
class IntersectionOfTwoArrays{
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArrays().new Solution();
        int[] n1 = new int[]{1,2,2,1};
        int[] n2 = new int[]{2,2};
        System.out.println((Arrays.toString(solution.intersection(n1, n2))));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // 过于暴力了，耗时耗空间
//        HashMap<Integer,Integer> hash1 = new HashMap<>();
//        HashMap<Integer,Integer> hash2 = new HashMap<>();
//        //
//        for (int i:nums1
//             ) {
//            if (hash1.containsKey(i)){
//                hash1.put(i,hash1.get(i)+1);
//            }
//            else {
//                hash1.put(i,1);
//            }
//        }
//        for (int i:nums2
//        ) {
//            if (hash2.containsKey(i)){
//                hash2.put(i,hash2.get(i)+1);
//            }
//            else {
//                hash2.put(i,1);
//            }
//        }
//        //
//        int count=0;
//        for (Integer i: hash1.keySet()
//             ) {
//            for (Integer j: hash2.keySet()
//                 ) {
//                if (i.equals(j)){
//                    count++;
//                }
//            }
//        }
//        int[] record = new int[count];
//        int idx=0;
//        for (Integer i: hash1.keySet()
//        ) {
//            for (Integer j: hash2.keySet()
//            ) {
//                if (i.equals(j)){
//                    record[idx++]=i;
//                }
//            }
//        }
//        return record;
        // 而且如果哈希值比较少、特别分散、跨度非常大，使用数组就造成空间的极大浪费。所以可以用set解决
        // 直接使用set 不仅占用空间比数组大，而且速度要比数组慢，set把数值映射到key上都要做hash计算的。
        // 解决一些不合法情况
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        //遍历数组1
        for (int i : nums1) {
            set1.add(i);
        }
        //遍历数组2的过程中判断哈希表中是否存在该元素
        for (int i : nums2) {
            if (set1.contains(i)) {
                resSet.add(i);
            }
        }
        int[] resArr = new int[resSet.size()];
        int index = 0;
        //将结果几何转为数组
        for (int i : resSet) {
            resArr[index++] = i;
        }
        return resArr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}