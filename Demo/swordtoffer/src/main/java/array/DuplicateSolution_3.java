package array;

/**
 * 题目描述
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 *
 */
public class DuplicateSolution_3 {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(length<=0)
            return false;
        for (int i = 0; i < length; i++) {
            while(numbers[i]!=i){
                if(numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                int tmp = numbers[numbers[i]];
                numbers[numbers[i]] = numbers[i];
                numbers[i] = tmp;
            }
        }
        return false;
    }
}

/**
 * 思路: 由于数组长度为n, 且元素都是0-n-1的值; 所以可以先遍历数组, 看位置i上的数字是否也是i;
 *  如果不是, 就把i位置上的数字置换到相应的位置上; 此时若发现这2个数字相同, 则找到一个重复值; 如果这2个数字不同, 则要持续置换, 直到这轮迭代遇到的数字都处于应有的位置上
 */
