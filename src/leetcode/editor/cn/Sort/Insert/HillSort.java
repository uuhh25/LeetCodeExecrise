package leetcode.editor.cn.Sort.Insert;

/**
 * @author w
 * 希尔排序
 */
@SuppressWarnings({"all"})
public class HillSort {
    public static void main(String[] args) {
        int[] nums = new int[]{4,2,0,1,3,7,-1};
        HillSort(nums);
        System.out.println(nums);
    }
    // 希尔排序是插入排序的变种
    // 插入排序的前进步长，是1；所以最坏的情况下，每一次都要移动n次，=> O（n^2)
    // 希尔排序就是先给定一个较大的步长 s <n.length,在每次的步长下进行插入排序
    // 然后不断地减小步长（s/2)，直到s=1；就完成了排序
    public static void HillSort(int[] n){
        int s = n.length-1; // 设定初始步长
        for (int i = s; i >=1 ; i/=2) {
            // 步长也是要变的
            for (int j = i; j < n.length; j+=i) {
                int temp=n[j];  // 存值
                int k = j-i;    // 找到该步长下的上一个值
                int h = j;  // 记录右移的开始位置
                while (k>=0 && n[k]>temp){
                    // 满足插入排序中，左数组的右边界大小 比 当前值大
                    k-=i;
                    // k进行向左移动，当前步长为i
                    for (; h > k+i ; h-=i) {
                        // 进行右移
                        n[h]=n[h-i];
                    }
                    // 插入空位
                    n[k+i]=temp;
                }
            }
        }
    }
}
