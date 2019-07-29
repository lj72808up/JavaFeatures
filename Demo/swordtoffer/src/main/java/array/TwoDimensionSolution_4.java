package array;

/**
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class TwoDimensionSolution_4 {
    public boolean Find(int target, int [][] arr) {
        int row = arr.length - 1;
        int col = 0;

        while (row >= 0 && col < arr[0].length) {
            if (arr[row][col] == target) {
                return true;
            } else if (arr[row][col] > target) {
                row = row - 1;
            } else {  // arr[row][col]<target
                col = col + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TwoDimensionSolution_4 td = new TwoDimensionSolution_4();
        int[][] arr = {{1,2,8,9},{2,4,7,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(td.Find(11,arr));
    }
}
/**
 * 思路: 发现要从从上到下, 从左到右递增的数组中找到某个数,可以从4个角为起点, 不断缩小比较范围
 *  从哪个角为起点开始比较好呢:
 *      若选择副对角线(\)的2个角开始,比如从arr[0][0]开始, 当和target比较后, 若target大,则目标即有可能在该元素下面, 也可能在该元素上面;
 *      若选择主对角线上的元素开始, 比如arr[length][0], 若比较后发现比target大,则target一定在上面,]; 若比target小, 则target一定在右面;
 *  因此可选择主对角线上的元素开始
 * */