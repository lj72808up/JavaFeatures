package array;

public class minNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        int index1 = 0;
        int index2 = array.length-1;

        while(index2-index1>1){   // mid划分两个数组, 前面是大数组,后面是rotation的小数组
            int mid = (index1+index2) >> 1;
            if(array[mid] >= array[index1])
                index1 = mid;
            if(array[mid] <= array[index2])
                index2 = mid;
            if ((array[mid]==array[index1])&&(array[mid]==array[index2]))
                return searchMin(array,index1,index2);
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
}
