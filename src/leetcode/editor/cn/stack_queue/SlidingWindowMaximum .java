package leetcode.editor.cn.stack_queue;

//239
//滑动窗口最大值
//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,-1], k = 1
//输出：[1,-1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [9,11], k = 2
//输出：[11]
// 
//
// 示例 5： 
//
// 
//输入：nums = [4,-2], k = 2
//输出：[4] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 1354 👎 0

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
class SlidingWindowMaximum{
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        int[] nums = new int[]{1,5,-1,2,0,3,7};
        System.out.println(Arrays.toString(solution.maxSlidingWindow(nums, 3)));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 用队列，但是队列里面的元素应该保存的是当前窗口内的最大值及其他值
        // 根据队列先进先出的特性，对自定义队列的 pop 和 push进行一定规则的重写

        // pop 如果窗口要移除的元素与队列出口元素相同，则pop；即窗口滑动
        // push 分两种情况，即如果压入队列元素比队列入口元素大，则将当前的队列入口元素弹出 ，再进行push；如果队列元素比队列入口元素小，则直接push
        // 在这种push的规则下，就可以一直保持队头元素是当前窗口最大的元素，到最后只要返回队头就可以了

        if (nums.length==1 || k==1){
            return nums;
        }
        // 用于定义存放窗口最大元素的数组，长度如下
        int len = nums.length-k+1;
        int[] res = new int[len];
        int num = 0;
        //自定义队列
        MyQueue myQueue = new MyQueue();
        //先将前k的元素放入队列
        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }
        // 并且保存第一个窗口的最大元素
        res[num++] = myQueue.peek();
        for (int i = k; i < nums.length; i++) {
            // 这里一进一出，就能够将窗口进行滑动了

            //滑动窗口移除最前面的元素，移除是判断该元素是否放入队列
            myQueue.poll(nums[i - k]);  // 判断是不是滑动之后，不在窗口内的元素
            //滑动窗口加入最后面的元素
            myQueue.add(nums[i]);   // 判断是否为最大值...
            //记录对应的最大值
            res[num++] = myQueue.peek();
        }
        return res;

    }
    class MyQueue{
        // 以Deque实现Queue
        Deque<Integer> que = new ArrayDeque<>();

        // 重写MyQueue的pop和push方法
        void poll(int val){
            // 比较当前要弹出的数值是否等于队列出口的数值，如果相等则弹出
            // 同时判断队列当前是否为空
            if (!que.isEmpty() && val== que.peek()){
                que.poll(); //弹出
            }
        }

        //
        void add(int val){
            // 即如果压入队列元素比队列入口元素大，则将当前的入口元素弹出
            while (!que.isEmpty() && val>que.getLast()){
                que.removeLast();
            }
            que.add(val);
        }
        // 获取队列队顶元素
        int peek(){
            // 肯定会有元素，所以不用担心为空的情况下报错
            return que.peek();
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}