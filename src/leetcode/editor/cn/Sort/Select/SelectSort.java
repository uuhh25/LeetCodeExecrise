package leetcode.editor.cn.Sort.Select;

/**
 * @author w
 * 做 直接选择排序
 */
@SuppressWarnings({"all"})
public class SelectSort {

    public static void main(String[] args) {
        // int[] nums = new int[]{4,2,0,1,3,7,-1};
        int[] nums = new int[]{5,12,-2,1,3,7,-1};
        SelectSort(nums);
        System.out.println(nums);
    }
    // 从小到大
    // 选择排序，先选定一个起点，然后向右侧遍历，找到最小的那个值，进行交换
    // 用两个for循环，试试，一个是外层遍历；一个是内层找最小值的遍历
    public static void SelectSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int idx = i;
            int min=nums[i];
            int j = i+1;
            // 向右侧找最小值，进行交换
            for (; j < nums.length; j++) {
                if (nums[j]<min){
                    idx = j;
                    min = nums[j];
                }
            }
            int temp=nums[i];
            nums[i]=min;
            nums[idx]=temp;
        }
    }
}
