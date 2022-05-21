package leetcode.editor.cn.hash_table.map;

//给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现
//次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
// 
//
// 示例 2: 
//
// 
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 1000 
// 
//
// 
//
// 进阶： 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 619 👎 0

// 我的思路1 先遍历数组1，存于哈希表；然后遍历数组2，判断是否元素是否出现在数组1，存入第二个哈希表；然后统计第二个哈希表val的总和确定数组长度
// 怎么确定出现的最小次数

// 省时间空间的思路：用map存，然后第一个map遍历短的，第二个map遍历长的并且判定是否存在于第一个数组，并且对比出现的次数
import java.util.Arrays;
import java.util.HashMap;
class IntersectionOfTwoArraysIi{
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArraysIi().new Solution();
        int[] n1 = new int[]{3,1,2};
        int[] n2 = new int[]{1,1};
        System.out.println((Arrays.toString(solution.intersect(n1, n2))));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 不合法情况
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        int len1 = nums1.length;
        int len2 = nums2.length;
        HashMap<Integer,Integer> hash1 = new HashMap<>();
        HashMap<Integer,Integer> hash2 = new HashMap<>();
        // 根据数组长度，选择放入的哈希表
        if (len1>len2){
            for (int i:nums2
            ) {
                if (hash1.containsKey(i)){
                    hash1.put(i,hash1.get(i)+1);
                }
                else {
                    hash1.put(i,1);
                }
            }
            for (int k:nums1
            ) {
                // 该元素出现在hash1中
                if (hash1.containsKey(k)){
                    int val = hash1.get(k);
                    // 找该元素出现的最小次数
                    if (hash2.containsKey(k)){
                        hash2.put(k, Math.min(hash2.get(k) + 1, val));
                    }else {
                        hash2.put(k,1);
                    }
                }
            }
        }
        else {
            for (int i:nums1
            ) {
                if (hash1.containsKey(i)){
                    hash1.put(i,hash1.get(i)+1);
                }
                else {
                    hash1.put(i,1);
                }
            }
            for (int k:nums2
            ) {
                // 该元素出现在hash1中
                if (hash1.containsKey(k)){
                    int val = hash1.get(k);
                    // 找该元素出现的最小次数
                    if (hash2.containsKey(k)){
                        hash2.put(k, Math.min(hash2.get(k) + 1, val));
                    }else {
                        hash2.put(k,1);
                    }
                }
            }
        }
        // 记录共有多少个元素,去创建对应长度的数组
        int l =0;
        for (Integer val: hash2.values()
             ) {
            l+=val;
        }
        int[] record = new int[l];
        int idx=0;
        // 把交集元素放到数组中
        for (Integer kk:hash2.keySet()
             ) {
            int count = hash2.get(kk);
            while (count>0){
                record[idx++]=kk;
                count--;
            }
        }
        return record;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}