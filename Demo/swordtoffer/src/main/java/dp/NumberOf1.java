package dp;

/**
  面试题15：二进制中1的个数
 题目：请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。例如
 把9表示成二进制是1001，有2位是1。因此如果输入9，该函数输出2。
 */

public class NumberOf1 {

    // num如果按位与上1, 结果不为0, 则说明num在该位上是1
    public int solution(int num){
        int count = 0;
        int flag = 1;
        while(flag!=0){
            if ((num&flag) != 0)
                count++;
            flag = flag<<1;
        }
        return count;
    }

    public static void main(String[] args) {
        int i=1;
        while(i!=0){   //循环32次
            System.out.print(i+",");
            i = i<<1;
        }
        System.out.println();
        System.out.println(new NumberOf1().solution(9));
    }
}
