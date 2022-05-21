package leetcode.editor.cn.Sort.Insert;

/**
 * @author ylh
 * 演示插入排序代码
 */

@SuppressWarnings({"all"})
public class InsertSort {
    public static void main(String[] args) {
        int[] nums = new int[]{4,2,0,1,3,7,-1};
        InsertSort(nums);
        System.out.println(String.valueOf(nums));
    }
    // 插入排序： 即选定一个起点（左2，或者右2），然后通过对比大小
    // 确定全体左移/右移，把找到的值插入到空出的位置
    public static void InsertSort(int[] nums){

        for (int j = 1; j < nums.length; j++) {
            // 如果是从小到大，就从这个位置开始向左边的元素对比
            // 找到符合当前元素值的位置
            int temp=nums[j];   /// 保存值
            int k=j-1;  // 找到左边数组的右边界
            int l = j;  // 数组左移的最右
            // 往左边找位置
            while (k>=0 && nums[k]>temp) {
                k--;
                // 每经过一次while，要插入到元素都会向左移动一位，
                for (; l > k+1; l--) {
                    // 进行左移
                    nums[l]=nums[l-1];
                }
                // 插入空位
                nums[k+1]=temp;
            }
        }
    }
}

