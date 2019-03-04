package traceback;

/**
 * 题目描述
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如 a b t g
 *     c f c s
 *     j d e h
 * 这样的3 X 4 矩阵中包含一条字符串"bfce"的路径，但是矩阵中不包含"abfb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class RouteInArray {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        int[] visited = new int[matrix.length];

        boolean flag = false;
        for (int i = 0; i < matrix.length; i++) {
            int row = i / cols;
            int col = i % cols;
            if(findPath(matrix,row,col,str,0,rows,cols,visited)){
                flag = true;
                break;  // 寻找str[1]
            }
        }
        return flag;
    }

    private boolean findPath (char[] matrix, int row, int col, char[] str, int site, int rows, int cols, int[] visited){
        if(site>str.length-1)
            return true;
        char target = str[site];
        if( row>=0 && row<rows
                && col>=0 && col<cols
                && visited[row*cols+col]==0
                && target==getElem(matrix,row,col,cols)){
            visited[row*cols+col] = 1;
            boolean dflag = findPath(matrix,row-1,col,str,site+1,rows,cols,visited);
            boolean uflag = findPath(matrix,row+1,col,str,site+1,rows,cols,visited);
            boolean lflag = findPath(matrix,row,col-1,str,site+1,rows,cols,visited);
            boolean rflag = findPath(matrix,row,col+1,str,site+1,rows,cols,visited);

            boolean find = dflag || uflag || lflag || rflag;

            if (!find)
                visited[row*cols+col] = 0;

            return find;
        }else{
            return false;
        }
    }

    private char getElem(char[] matrix, int row, int col, int cols){ // 3行4列为例
        return matrix[row*cols+col];
    }


    public static void main(String[] args) {
        RouteInArray inArray = new RouteInArray();
        char[] matrix = "A".toCharArray();
        char[] strs = "A".toCharArray();
        System.out.println(inArray.hasPath(matrix,1,1,strs));
    }
}
