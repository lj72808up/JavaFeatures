package array;

/**
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class RotateArrayMinNumber_11 {
    public int minNumberInRotateArray(int [] array) {
        int index1 = 0;
        int index2 = array.length-1;

        while(index2-index1>1){   // mid划分两个数组, 前面是大数组,后面是rotation的小数组
            int mid = (index1+index2) >> 1;

            if ((array[mid]==array[index1])&&(array[mid]==array[index2]))
                return searchMin(array,index1,index2);

            if(array[mid] >= array[index2]) {
                index1 = mid;
            }else if(array[mid] <= array[index1]){
                index2 = mid;
            }
        }
        //index2-index1=1时退出, index2是后面rotation小数组的头
        return array[index2];
    }
    private int searchMin(int[] array,int start,int end){
        int min = array[start];
        for(int i=start;i<=end;i++){
            if (array[i]<min)
                min = array[i];
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int min = new RotateArrayMinNumber_11().minNumberInRotateArray(arr);
        System.out.println(min);
    }
}
/**
 * 思路:
 *   旋转的数组有一个规律, 就是旋转后, 第1个元素, 一定大于等最后一个元素,因此若套用二分查找的思路:
 *   先计算出mid=(index1+index2)>>1,
 *      若arr[mid]>=arr[index1], 说明mid属于前半段, 则旋转点一定是在mid和index2之间
 *      若arr[mid]<=arr[index2], 说明mid属于后半段, 则旋转点一定是在index1和mid之间
 *   此外, 若值 旋转了0个元素,即{1,2,3,4}这样依然属于旋转数组, 此时第一个元素
 */