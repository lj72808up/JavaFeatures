package dp.knapsack;

import java.util.Arrays;

/**
 * 0-1背包问题
 */
public class ZeroOne {
    // space complexity: O(vw)
    public void f1() {
        int W = 6;
        int[] w = {2,6,7,8};
        int[] v = {1,2,4,5};
        int N = 4;  // 4个item
        int[][] dp = new int[N+1][W+1];

        for (int i = 1; i <= N; i++) {  // 选择哪个item, 总重多少都是未知的
            for (int j = 1; j <=W ; j++) {
                if(j>=w[i-1])
                    dp[i][j] = Math.max(dp[i-1][j-w[i-1]]+v[i-1], dp[i-1][j]);   // 此处的w[i-1]和v[i-1]是为了避免数组越界
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        Arrays.sort(dp[N]);
        int res = dp[N][W];
        for (int i = 0; i <=N ; i++) {
            for (int j = 0; j <=W ; j++) {
                System.out.print(dp[i][j]+",");
            }
            System.out.println();
        }
        System.out.println("背包最大价值:"+res);
    }

    // 临时数组降维
    public void fun2(){
        int W = 3;
        int[] w = {1,1,2,2};
        int[] v = {1,2,4,5};
        int N = 4;  // 4个item

        int[] dp = new int[W+1];

        for (int i = 1; i <=N ; i++) {
            int[] tmp = new int[W+1];
            for (int j = 1; j <=W; j++) {
                if(j>=w[i-1])
                    tmp[j] = Math.max(dp[j-w[i-1]]+v[i-1], dp[j]);
                else
                    tmp[j] = dp[j];
            }
            dp = tmp;
        }

        Arrays.sort(dp);
        int res = dp[W];
        System.out.println("背包最大价值:"+res);
    }

    public static void main(String[] args) {
        new ZeroOne().f1();
    }
}
