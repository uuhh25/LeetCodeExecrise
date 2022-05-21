package leetcode.editor.cn.Sort.Swap;

/**
 * @author w
 * 演示冒泡排序
 */
@SuppressWarnings({"all"})
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5,12,-2,1,3,7,-1};
        BubbleSort(nums);
        System.out.println(nums);
    }
    // 冒泡排序，就是不断地左右对比
    // 相邻两个数进行对比，满足对比的条件就交换
    // 最坏情况是 O(n*(n-1)) => O(n*n) ；最好的情况是O(n)
    public static void BubbleSort(int[] n){
        // 递增排序
        // 先选中一个起点，不断向右进行对比
        for (int i = 0; i < n.length; i++) {
            for (int j = i+1; j < n.length; j++) {
                // 亮亮对比，如果满足条件则交换
                if (n[i]>n[j]){
                    int temp = n[i];
                    n[i]=n[j];
                    n[j]=temp;
                }
            }
        }
    }
}
