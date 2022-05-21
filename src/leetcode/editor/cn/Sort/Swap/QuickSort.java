package leetcode.editor.cn.Sort.Swap;

/**
 * @author w
 * 演示 快速排序
 */
@SuppressWarnings({"all"})
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5,12,-2,1,3,7,-1};
        QuickSort(nums,0, nums.length-1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+ ",");
        }
    }
    // 快速排序的重点是：用一个基数，然后不断地交换和递归
    // 1.默认选择左边第一个数为基数P
    // 2.然后分别从左边界和右边界进行遍历，如果 >P ，放到右边；如果 <P,放到左边
    //   因为我们是选取左边第一个为基数，所以是右边指针先动
    // 3.如果左右指针重合，则把基数放到重合位置；
    // 4.从重合位置来看，是分为了左、右序列，所以对左、右进行递归排序
    public static void QuickSort(int[] n,int left,int right){
        // 终止条件
        if (left>=right) return;
        // 先选取基数
        int p = n[left];
        int l = left;
        int r = right;
        // 开始排序
        while (left<right){
            // 先从右边开始
            while (left<right && n[right]>=p){
                right--;
            }
            if (n[right]<p){
                n[left++]=n[right];
            }
            // 再判断左边
            while (left<right && n[left]<=p){
                left++;
            }
            if (n[left]>p){
                n[right--]=n[left];
            }
        }
        // 重合
        n[left]=p;
        // 对左右序列递归
        QuickSort(n,l,left-1);
        QuickSort(n,left+1,r);
    }
}
