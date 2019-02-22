package array;

/**
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class TwoDimensionSolution {
    public boolean Find(int target, int [][] array) {
        int m = array.length;  // 行数
        int n = array[0].length; // 列数
        int i = 0;
        int j = n-1;
        while(i<m && j>=0){
            if (array[i][j] == target)
                return true;
            else if (array[i][j] > target)
                j--;
            else
                i++;
        }
        return false;
    }

    public static void main(String[] args) {
        TwoDimensionSolution td = new TwoDimensionSolution();
        int[][] arr = {{1,2,8,9},{2,4,7,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(td.Find(11,arr));
    }
}
