import java.util.Arrays;

/**
 * 定义矩阵计算:
 * 若矩阵A = (a[i][j]) 和 矩阵B = (b[i][j])为n*n的方针
 * 定义矩阵乘法运算C = A · B ， 其中c[i][j] = \sum_{k=0}^{n} (a[i][k] * b [k][j])
 * 实现满足这一运算规则的函数。
 * 输入: int[][] a, int[][] b 。入参保证a和b有相同的长度和宽度
 * 输出: int[][] c
 */

public class 矩阵乘法_暴力算法 {

    public static void main(String[] args) {
        int[][] a = new int[][]{{1,0},{0,1}};
        int[][] b = new int[][]{{1,0},{0,1}};
        int[][] c = matrixMultiply(a, b);
        printMatrix(c);
    }

    public static int[][] matrixMultiply(int[][] a, int[][] b){
        int n = a.length;
        int[][] c = new int[n][n];
        for (int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < n ; j ++){
                c[i][j] = 0;
                for(int k = 0 ; k < n ; k ++){
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    private static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

}
