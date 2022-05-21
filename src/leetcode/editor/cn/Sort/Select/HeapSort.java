package leetcode.editor.cn.Sort.Select;

/**
 * @author w
 * 演示i 堆排序
 */
@SuppressWarnings({"all"})
public class HeapSort {
    public static void main(String[] args) {
        int[] nums = new int[]{4,2,0,1,3,7,-1};
        HearSort(nums);
        System.out.println(nums);
    }
    // 堆排序，
    // 1. 把数组建堆，升序 - 大顶堆 、 降序 - 小顶堆
    // 2. 进行堆排序 => 交换首尾的元素，然后恢复堆的特性
    // 堆排序相当于，不断地把大的元素进行上浮，然后放在堆的最后，并且堆长-1；
    // => 按照从大到小的顺序，把元素排在了堆的后面 => 从小到大排序的数组
    public static void HearSort(int[] arr){
        // 升序 - 大顶堆 、 降序 - 小顶堆
        int n = arr.length;
        //构建大顶堆
//        for (int i = (n - 2) / 2; i >= 0; i--) {
//            downAdjust(arr, i, n - 1);
//        }
//        //进行堆排序
//        for (int i = n - 1; i >= 1; i--) {
//            // 把堆顶元素与最后一个元素交换
//            int temp = arr[i];
//            arr[i] = arr[0];
//            arr[0] = temp;
//            // 把打乱的堆进行调整，恢复堆的特性
//            downAdjust(arr, 0, i - 1);
//        }

        // 构建小顶堆
        for (int i = n  / 2; i >= 1; i--) {
            // heapSize/2, 即第一个非叶子节点
            upAdjust(arr, i, n - 1);
        }
        //进行堆排序
        for (int i = n - 1; i >= 1; i--) {
            // 把堆顶元素与最后一个元素交换
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            // 把打乱的堆进行调整，恢复堆的特性
            upAdjust(arr, 0, i - 1);
        }
    }

    // 怎么建立堆？ 用数组表示 堆，堆顶 i,左孩子 2i+1,右孩子 2i+2
    // 用向下调整算法建堆，O(n) ；
    public static void downAdjust(int[] arr, int parent, int n){
        //临时保存要下沉的元素
        int temp = arr[parent];
        //定位左孩子节点的位置
        int child = 2 * parent + 1;
        //开始下沉
        while (child <= n) {
            // 如果右孩子节点比左孩子大，则定位到右孩子
            if(child + 1 <= n && arr[child] < arr[child + 1])
                child++;
            // 如果孩子节点小于或等于父节点，则下沉结束
            if (arr[child] <= temp ) break;
            // 父节点进行下沉
            arr[parent] = arr[child];
            parent = child;
            child = 2 * parent + 1;
        }
        arr[parent] = temp;
    }

    public static void upAdjust(int[] arr, int parent, int n){
        //临时保存要上浮的元素
        int temp = arr[parent];
        //定位左孩子节点的位置
        int child = 2 * parent + 1;
        //开始上浮
        while (child <= n) {
            // 如果右孩子节点比左孩子小，则定位到右孩子
            if(child + 1 <= n && arr[child] > arr[child + 1])
                child++;
            // 如果孩子节点大于或等于父节点，则下沉结束
            if (arr[child] >= temp ) break;
            // 子节点进行上浮
            arr[parent] = arr[child];
            parent = child;
            child = 2 * parent + 1;
        }
        arr[parent] = temp;
    }
}
