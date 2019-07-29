package array;

/**
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class RotateArrayMinNumber_11 {
    public int minNumberInRotateArray(int [] arr) {
        if (arr.length==0)
            return 0;
        int index1=0;
        int index2=arr.length-1;
        int mid=index1;

        while(arr[index1]>=arr[index2]){
            if (index2-index1==1){
                mid = index2;
                break;
            }

            mid = (index1+index2)>>1;
            if (arr[index1]==arr[mid] && arr[index2]==arr[mid])
                this.searchMin(arr,index1,index2);
            if (arr[mid]>=arr[index1]){
                index1=mid;
            }else if(arr[mid]<=arr[index2]){
                index2=mid;
            }
        }

        return arr[mid];
    }

    private int searchMin(int [] arr,int start,int end){
        int min = arr[start];
        for (int i=start;i<=end;i++){
            if (arr[i]<min){
                min = arr[i];
            }
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
 *   旋转的数组有一个规律, 就是旋转后, 第1个元素, 一定大于等于最后一个元素,因此若套用二分查找的思路:
 *   先计算出mid=(index1+index2)>>1,
 *      若arr[mid]>=arr[index1], 说明mid属于前半段, 则旋转点一定是在mid和index2之间
 *      若arr[mid]<=arr[index2], 说明mid属于后半段, 则旋转点一定是在index1和mid之间
 *   最后,当index1和index2相邻时, index2即为最小值
 *   此外, 若只旋转了0个元素,即{1,2,3,4}这样依然属于旋转数组, 此时第一个元素小于第二个元素, 可直接找到最小值arr[0]
 *   再次, 上述判断漏掉一个可能, 就是arr[index1]=arr[mid]=arr[index2]的情形, 该情形无法判断最小值在哪一段:
 *      例如: [1,0,1,1,1]和[1,1,1,0,1]
 *      因此, 只能通过顺序查找整个列表
 */