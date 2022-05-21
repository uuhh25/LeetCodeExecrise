package leetcode.editor.cn;

import java.util.*;

//6041. 多个数组求交集
//给你一个二维整数数组 nums ，其中 nums[i] 是由 不同 正整数组成的一个非空数组，
//按 升序排列 返回一个数组，数组中的每个元素在 nums 所有数组 中都出现过
public class arrayIntersection {
    public static void main(String[] args) {
        int[][] nums=new int[][]{{3,1,2,4,5},{1,2,3,4},{3,4,5,6}};
        System.out.println(findIntersection(nums));
    }
    public static List<Integer> intersection(int[][] nums) {
        List<Integer> list=new LinkedList<>();
        if(nums.length<2){
            for(int i=0;i<nums[0].length;i++){
                list.add(nums[0][i]);
            }
            Collections.sort(list);
            return list;
        }
        // 先找前两的交集，然后再第三个开始，去收缩交集？
        int[] n1 = nums[0];
        int m=n1.length;
        int[] n2 = nums[1];
        int n=n2.length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(n1[i]==n2[j]){
                    list.add(n1[i]);
                }
            }
        }
        for (int i = 2; i < nums.length; i++) {
            List<Integer> tmpList=new LinkedList<>();
            for (Integer num:nums[i]) {
                if (list.contains(num)){
                    tmpList.add(num);
                }
            }
            list=new LinkedList<>(tmpList);
        }
        Collections.sort(list);
        return list;
    }

    // 只要找到出现次数是n的数字，肯定就是交集了，因为每个nums[i]数组的元素是不重复的
    public static List<Integer> findIntersection(int[][] nums){
        List<Integer> list=new LinkedList<>();
        if(nums.length<2){
            for(int i=0;i<nums[0].length;i++){
                list.add(nums[0][i]);
            }
            Collections.sort(list);
            return list;
        }
        // 因为是要找所有nums[i]的子集，所以只需要找出出现次数为n的数字
        Map<Integer,Integer> map=new HashMap();
        for(int i=0;i<=nums.length-1;i++){
            for(int j=0;j<=nums[i].length-1;j++){
                // 如果已经存有 nums[i][j]，则在基础上+1，如果没有给1
                map.put(nums[i][j], map.getOrDefault(nums[i][j],0)+1);
            }
        }
        // 遍历map
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            Integer a=entry.getValue();
            if(a==nums.length){
                // 加入key，而不是value
                list.add(entry.getKey());
            }
        }
        Collections.sort(list);
        return list;
    }
}
