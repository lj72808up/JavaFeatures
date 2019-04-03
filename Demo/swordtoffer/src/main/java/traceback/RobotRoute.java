package traceback;

/**
 * 题目描述
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子？
 */
public class RobotRoute {
    public int movingCount(int threshold, int rows, int cols) {
        int[] visited = new int[rows*cols];
        return countCore(threshold,rows,cols,0,0,visited);
    }

    private int countCore(int threshold, int rows, int cols, int row, int col,int[] visited){
        if (getDigitSum(row)+getDigitSum(col)>threshold
                || row>rows-1 || col>cols-1
                || visited[row*cols+col]==1) {
            return 0;
        }

        int up = countCore(threshold,rows,cols,row+1,col,visited);
        int right = countCore(threshold,rows,cols,row,col+1,visited);
        visited[row*cols+col]=1;
        return up+right+1;
    }

    private int getDigitSum(int number){
        int sum = 0;
        while(number>0){
            sum += number % 10 ;
            number = number/10 ;
        }
        return sum;
    }
}
