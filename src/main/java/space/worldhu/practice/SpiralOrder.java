package space.worldhu.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushicheng
 * @date 2020/5/18
 */
public class SpiralOrder {

    public static void main(String[] args) {
        int[][] x = new int[][]{{ 1, 2, 3 },{4, 5, 6 },{7, 8, 9}};
        List<Integer> integers = spiralOrder(x);

        for (int i = 0; i < integers.size(); i++) {
            System.out.print(integers.get(i) + "   ");
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> d = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        getPositiveRow(0, n - 2, 0, matrix, d);
        getAntiRow(m-1, n - 2, 0, matrix,  d);
        getPositiveCol(n-1, m-2, 0, matrix, d);
        getAntiCol(0, m-1, 1, matrix, d);
        return d;
    }

    public static void getPositiveRow(int row, int maxColumn, int minColumn, int[][] matrixk,
            List<Integer> data) {
        for (int i = minColumn; i <= maxColumn; i++) {
            data.add(matrixk[row][i]);
        }
    }
    public static void getAntiRow(int row, int maxColumn, int minColumn, int[][] matrixk,
            List<Integer> data) {
        for (int i = maxColumn; i <= minColumn; i--) {
            data.add(matrixk[row][i]);
        }
    }

    public static void getPositiveCol(int column, int maxRow, int minRow, int[][] matrixk,
            List<Integer> data) {
        for (int i = minRow; i <= maxRow; i++) {
            data.add(matrixk[i][column]);
        }
    }
    public static void getAntiCol(int column, int maxRow, int minRow, int[][] matrixk,
            List<Integer> data) {
        for (int i = maxRow; i <= minRow; i--) {
            data.add(matrixk[i][column]);
        }
    }
}
