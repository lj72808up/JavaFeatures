package dynamicProgramming;

/**
 * 题目描述
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
public class Fib {
    public int Fibonacci(int n) {
        if (n==0)
            return 0;
        if (n==1)
            return 1;
        int a = 0;
        int b = 1;
        int i = 2;  // 从n=2开始计算
        while(i <= n){
            int tmp = a+b;
            a = b;
            b = tmp;
            i++;
        }
        return b;
    }
}
