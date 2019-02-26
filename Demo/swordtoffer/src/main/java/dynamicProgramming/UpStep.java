package dynamicProgramming;

/**
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class UpStep {
    public int JumpFloor(int target) {
        if (target==0)
            return 0;
        if (target==1)
            return 1;
        int a = 1;
        int b = 1;
        int i = 2;  // 从n=2开始计算
        while(i <= target){
            int tmp = a+b;
            a = b;
            b = tmp;
            i++;
        }
        return b;
    }
}
