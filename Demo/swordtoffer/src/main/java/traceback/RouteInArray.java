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
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i]==str[0]){
                int row = i / 4;
                int col = i % 4;
                return findPath(matrix,row,col,str,1); // 寻找str[1]
            }
        }
        return false;
    }

    private boolean findPath (char[] matrix, int rows, int cols, char[] str, int site){

    }

    private char getElem(char[] matrix, int row, int col){
        if(row>2 || row<0 || col>3 || col<0)
            return '\0';
        return matrix[row*4+col];
    }
}
