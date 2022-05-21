package leetcode.editor.cn.hash_table.arrays;

//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 只会存在一个有效答案 
// 
//
// 进阶：你可以想出一个时间复杂度小于 O(n²) 的算法吗？ 
// Related Topics 数组 哈希表 👍 12524 👎 0

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TwoSum{
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
//        Scanner sc=new Scanner(System.in);
//        System.out.println("请输入数组：");
//        int[] nums=new int[3];
//        for (int i = 0; i <nums.length; i++) {
//            int b=sc.nextInt();
//            nums[i]=b;
//        }
//        System.out.println("请输入目标数字：");
//        int target=sc.nextInt();

        int[] nums = new int[]{1,2,3,5,7};
        int target = 5;

        int[] ints=solution.twoSum(nums,target);
        System.out.println(Arrays.toString(ints));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            // 先排序，再双指针? 写不出来

            // 暴力枚举
//            int[] res = new int[2];
//            for (int i = 0; i < nums.length; i++) {
//                int a = nums[i];
//                for (int j = 0; j < nums.length; j++) {
//                    if(i==j){
//                        continue;
//                    }
//                    int b = nums[j];
//                    int sum = a+b;
//                    if (sum == target){
//                        res[0]=i;
//                        res[1]=j;
//                    }
//                }
//            }
//            return res;
//            Map<Integer,Integer> hash = new HashMap<Integer,Integer>();
//            for (int i = 0; i < nums.length; i++) {
//                if (hash.containsKey(target - nums[i])) {
//                    int idx = hash.get(target - nums[i]); //找到第二值的下标
//                    return new int[]{i, idx};
//                }
//                hash.put(nums[i], i);
//            }
//            return new int[0];
            // 哈希表 先遍历数组放入哈希表，然后再次遍历数组，判断是否有 target-num[i] 这个值
            // 用哈希表遍历数组，通过寻找有没有 target-num[i] 这个值，来找到下标
            // 把元素值表示为key、下标表示为value
            Map<Integer,Integer> map = new HashMap<>();
            // 遍历保存数组的元素和对应下标
            // 怎么处理数组中重复的元素? 不提前遍历数组元素，以防止重复元素的下标值问题

            //  遍历数组
            for (int i = 0; i < nums.length; i++) {
                // 判断是否有 target-nums[i]
                // 遍历数组同时判断，可以避免重复元素下标存成一样的问题
                if (map.containsKey(target-nums[i])){
                    // 如果有，则获取key对应val 即下标，返回下标
                    int idx = map.get(target-nums[i]);
                    return new int[]{i,idx};
                }
                // 没有，则将该元素，存入哈希表；
                map.put(nums[i],i);
            }
            return new int[0];



        }
    }
		//leetcode submit region end(Prohibit modification and deletion)

}