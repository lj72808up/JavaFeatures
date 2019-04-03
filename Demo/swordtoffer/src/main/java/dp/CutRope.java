package dp;

/**
 面试题14：剪绳子
 题目：给你一根长度为n绳子，请把绳子剪成m段（m、n都是整数，n>1并且m≥1）。
 每段的绳子的长度记为k[0]、k[1]、……、k[m]。k[0]*k[1]*…*k[m]可能的最大乘
 积是多少？例如当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此
 时得到最大的乘积18。
 */
public class CutRope {
    // f(n)=max(f(i)*f(n-i))
    public int solution(int k){
        if (k<2) return 0;
        if (k==2) return 1;
        if (k==3) return 2;

        int[] dp = new int[k+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <k+1 ; i++) {
            int size=0;
            for (int j = 1; j < i; j++) {
                size = Math.max(size,dp[i-j]*dp[j]);
            }
            dp[i] = size;
        }
        for (int i : dp) {
            System.out.print(i+",");
        }
        System.out.println();
        return dp[k];
    }

    public static void main(String[] args) {
        System.out.println(new CutRope().solution(5));
    }
}
