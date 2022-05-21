package leetcode.editor.cn.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class minSubArray {
    public static void main(String[] args) {
        int[] s=new int[]{2,3,1,2,4,3};
        System.out.println(p(7,s));
        System.out.println(generateMatrix(7));
    }
    public static int minSubArrayLen(int target, int[] nums) {
        // 用双指针 构成一个窗口，窗口里面的总和为target，
        // 快指针用于，遍历和窗口扩张；慢指针用于，收缩窗口
        int sum=nums[0];  // nums[i]>0
        int left=0,right=0;
        int len=nums.length;
        while(right<nums.length){
            if(sum>=target){
                if(len>=(right-left+1)){
                    len=right-left+1;
                }
                sum-=nums[left];
                left++;
                continue;
            }else {
                right++;
                if (right>=nums.length) {
                    break;
                }
                sum+=nums[right];
            }
        }
        return len;
    }

    public static int p(int target,int[] nums){
        int i=0,sum=0;
        int len=Integer.MAX_VALUE;

        for(int j=0;j<nums.length;j++){
            sum+=nums[j];
            // 判断和与target
            while(sum>=target){
                len=Math.min(len,j-i+1);
                sum-=nums[i++];
            }
        }
        return len;
    }

    public static int[][] generateMatrix(int n) {
        // 螺旋矩阵，即有4个方向 上->右->下->左 ->
        // 列+ -> 行+ -> 列- -> 行- -> 列+ ...
        // 起点0,0 -> n,n  每一圈的终点 n+1,n
        boolean flag;
        int[][] dp=new int[n][n];
        if(n%2==0){
            flag=true;  // 偶数
        }else{
            flag=false; // 奇数
        }
        int num=1;
        for(int i=0;i<n;i++){
            // 四个方向的边界
            int left=i,right=n-i-1,bottom=n-i-1,up=i;
            int c1=i,c2=i;
            // 1 2 3 4
            while(c2<right){
                dp[c1][c2]=num++;
                c2++;
            }
            while(c1<bottom){
                dp[c1][c2]=num++;
                c1++;
            }
            while(c2>left){
                dp[c1][c2]=num++;
                c2--;
            }
            while(c1>up){
                dp[c1][c2]=num++;
                c1--;
            }
        }
        if(!flag){
            dp[n/2][n/2]=num;
        }
        return dp;
    }
}
