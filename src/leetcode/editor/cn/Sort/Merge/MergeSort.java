package leetcode.editor.cn.Sort.Merge;

/**
 * @author w
 * 演示归并排序
 */
@SuppressWarnings({"all"})
public class MergeSort {
    public static void main(String[] args) {
        // int[] nums = new int[]{4,2,0,1,3,7,-1};
        int[] nums = new int[]{5,12,-2,1,3,7,-1};
        // MergeSort(nums,0, nums.length-1);
        MergeSort(nums);
        System.out.println(nums);
    }
    // 归并排序的过程：先对一个大数组进行 二分 拆分，
    // 然后再对 拆分的数组继续拆分
    // 直到拆成一个一个的元素 (递归？）
    // 再向上 排序 并 合并
    // 参数，数组，数组左、右边界;返回数组
    // 终止条件，当左右边界相同，则停止
    // 单层逻辑，找到数组的中点，然后输入到递归函数中进行分割；
    public static int[] MergeSort(int[] nums,int left, int right){
        // 对数组进行拆分
        if (left < right) {
            // == 的时候，表示只有一个元素
            int mid = left + (right-left) /2;   // 防止溢出
            // 左右数组 进行递归
            nums = MergeSort(nums,left,mid);
            nums = MergeSort(nums,mid+1,right);
            // 进行合并，该函数不返回
            merge(nums,left,mid,right); // 相当于是在同一个数组中，用索引进行分割
        }
        // 合并之后返回，或者不用分割的直接返回
        return nums;
    }
    public static void merge(int[] nums,int left, int mid, int right){
        // 对两个数组进行合并，
        // 就是对输入的两个数组，不断地比较其左边界，然后取小(大)的那一个
        // 用一个临时数组，进行合并
        int[] a = new int[right-left+1];
        int i=left;
        int j = mid+1;
        int idx = 0;    // 用于添加元素到临时数组
        // 存在左右数组，则进行比较合并，经过这个判断后，会有一边超出界，从而导致另一边的数组没有进行加入
        while (i<=mid && j<=right){
            //
            if (nums[i]>nums[j]){
                a[idx++] = nums[j++];
            }else {
                a[idx++] = nums[i++];
            }
        }
        // 这两个是针对有一边出界的情况
        while (i<=mid ){
            a[idx++] = nums[i++];
        }
        while (j<=right){
            a[idx++] = nums[j++];
        }
        // 把数组放回到原数组,不能直接用 num.length，要用idx的长度
        for (int k = 0; k < idx; k++) {
            // 因为我们是在nums上修改的，所以nums的边界是从left开始
            nums[left++]=a[k];
        }
    }

    // 用迭代的方法，做归并排序 => 用迭代 模拟 递归分割数组的过程
    // left = 0 ,mid = left+i-1,right = mid+i ; 就可以保证是对半分的数组；
    // 然后i+=i,就可以实现数组的分割过程 => 然后进行归并、排序
    public static void MergeSort(int[] nums){
        // 迭代法
        for (int i = 1; i < nums.length; i+=i) {
            // 确定左中右位置
            int left=0;
            int mid = left+i-1;
            int right = mid+i;
            // 有了左数组的边界，就可以找到右数组，进行合并
            while (right< nums.length){
                //
                merge(nums,left,mid,right);
                // 切换到右数组
                left=right+1;   // 左数组右边界 + 1
                mid = left+i-1;
                right=mid+i;
            }
            // 处理一些遗漏的数组
            // 因为不可能每个子数组大小刚好为 i
            if (left< nums.length && mid< nums.length){
                merge(nums,left,mid,nums.length-1);
                // 就是如果 i 比较大的时候，可能数组后面的几个元素就包括不到了
                // 所以要对最后几个元素也进行归并
            }
        }
    }
}
