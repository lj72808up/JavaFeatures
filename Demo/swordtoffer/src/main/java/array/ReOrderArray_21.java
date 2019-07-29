package array;


import java.util.Arrays;

/**
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray_21 {
    // 保证相对位置不变
    public void reOrderarr1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (isEven(arr[i])){
                int j = i+1;
                while(j < arr.length) {
                    if(!isEven(arr[j])){
                        int tmp = arr[j];
                        for (int k = j; k >i ; k--) {
                            arr[k] = arr[k-1];
                        }
                        arr[i] = tmp;
//                        i++;
                        break;
                    }
                    j++;
                }
            }
        }
    }

    // 不保证相对位置不变
    public void reOrderarr2(int[] arr) {
        int i=0;
        int j=arr.length-1;
        while(i<=j){
            while(i<=j && !isEven(arr[i])){
                i = i+1;
            }
            while(i<=j && isEven(arr[j])){
                j=j-1;
            }

            if(i<j){
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }
    }

    private boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static void main(String[] args) {
        ReOrderArray_21 reOrderArray_21 = new ReOrderArray_21();
        int[] arr = {1, 2, 3, 4, 5, 6};
        reOrderArray_21.reOrderarr2(arr);
        System.out.println(Arrays.toString(arr));
    }
}

/**思路:
 *  (1) 若题目不要求保证相对顺序一致, 可以想到, 维护2个指针, 1个从0开始递增, 1个从末尾开始递减,
 *      递增的指针找到偶数就停止, 递减的指针找到基数就停止, 如果前一个指针比后一个指针小, 就交换元素, 直到2个指针相遇
 *  (1) 但是题目要求保证奇数偶数相应位置不变, 上述交换奇数偶数的做法不再合适, 例如[1,2,4,3,5]会变成[1,5,3,4,2]
 *      若改成找到第一个偶数后, 在其后面找到第一个奇数就交换也不合适, 那样[1,2,4,3,5]会变成[1,3,4,2,5];
 *      因此想到插入做法, 每找到1个偶数后, 在其后面找到第一个奇数, 将这个奇数插入到偶数的位置, 将偶数到奇数之间的数向后移动1位
 * */