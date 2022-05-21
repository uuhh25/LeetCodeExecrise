package leetcode.editor.cn.dp.bagage;

public class bagage0102 {
    public static void main(String[] args) {
        int[] weight = {1, 2, 4};
        int[] value = {15, 20, 30};
        int bagsize = 4;
        testweightbagproblem(weight, value, bagsize);
        testweightbagProblemdp(weight, value, bagsize);
    }

    public static void testweightbagproblem(int[] weight, int[] value, int bagsize){
        // 初始化数组,即没有物品也没有重量也要一行一列
        int[][] dp = new int[weight.length+1][bagsize+1];
        // 初始化
        for (int i = 0; i < weight.length; i++) {
            dp[i][0]=0;
        }
        // 动态规划，i、j都从开始，因为第一列和第一行已经是初始化过了；即没有重量和没有物品的情况
        for (int i = 1; i <= weight.length; i++) {
            // 遍历背包
            for (int j = 1; j <= bagsize; j++) {
                // 遍历重量
                // 递推公式中有两种情况
                if (j<weight[i-1]){
                    // i这个物品没法放进来，因为超重了
                    dp[i][j]=dp[i-1][j];
                }else {
                    // 如果可以加，则看是哪个价值更大，一边是
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weight[i-1]] + value[i-1]);
                }
            }
        }
        //打印dp数组
        for (int i = 0; i <= weight.length; i++){
            for (int j = 0; j <= bagsize; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }
    }


    // 滚动数组，即在二位数组的基础上，进行优化，只用一维数组 <= 前提是dp[i-1][] 直接可以用在 dp[i][]的情况下
    // => dp[i][j]=>dp[j]，即每次dp[j]的更新都会覆盖原本的情况
    // 1.dp数组为,dp[]; dp[j]表示j重量下，可以装得最大价值总数
    // 2.递推公式，dp[j] 是从前面状态推过来的，要么是上一重量直接复制过来（没有物品可以加入）dp[i] 或者 从加入新物品前的状态转移过来
    // dp[i]=Math.max(d[j],dp[j-weight[i]) => 既要遍历物品、也要遍历背包
    // 3.初始化，dp[0]=0，重量为0的时候，价值也为0；dp[j]是从其他状态转移过来的，所以也初始化为0就好，都会被覆盖的
    // 4.遍历顺序，因为我们是一维数组，不像原来的二维数组是通过左上角进行状态转移；
    // 且因为dp[j-weight[i]]，如果从前往后遍历，假如dp[1]是有值，  weight[0]=1
    // 可能出现，dp[2]=dp[2-weight[0]]+value[0],dp[1]=dp[1-weight[0]]+value[0]，会导致物品0被是使用2次！！
    // 所以背包重量要从后往前遍历，dp[j]=dp[j-weight[i]]时，j[h] h<j,都是0
    //
    public static void testweightbagProblemdp(int[] weight,int[] value, int bagsize){
        //
        int[] dp= new int[bagsize+1];
        dp[0]=0;
        //
        for (int i = 0; i < weight.length; i++) {
            // 做了剪枝，如果j小于物品重量，直接不便利了
            for (int j = bagsize; j >=weight[i] ; j--) {
                dp[j]=Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
        }

//        for (int j = bagsize; j >=0 ; j--) {
//            for (int i = 0; i < weight.length && weight[i]<j; i++) {
//                dp[j]=Math.max(dp[j],dp[j-weight[i]]+value[i]);
//            }
//        }

        for (int i = 0; i < bagsize+1; i++) {
            System.out.print(dp[i]+",");
        }
    }
}
