package space.worldhu.practice;

/**
 * @author hushicheng
 * @date 2020/7/23
 */
public class MinPathSum {

    /**
     * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     *
     * 说明：每次只能向下或者向右移动一步。
     *
     * 示例:
     *
     * 输入:
     * [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     * 输出: 7
     * 解释: 因为路径 1→3→1→1→1 的总和最小。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-path-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int minPathSum(int[][] grid) {
        int[][] path = new int[2][grid[0].length];
        int index;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i % 2 == 0) {
                    index = 0;
                } else {
                    index = 1;
                }
                if (i == 0 && j == 0) {
                    path[i][j] = grid[i][j];
                } else if (i == 0) {
                    path[index][j] = path[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    path[index][j] = path[index == 0 ? 1 : 0][j] + grid[i][j];
                } else {
                    path[index][j] = Math.min(path[index == 0 ? 1 : 0][j], path[index][j - 1]) + grid[i][j];
                }
                System.out.print(path[index][j] + "  ");
            }
            System.out.println();
        }
        for (int[] ints : path) {
            for (int j = 0; j < path[0].length; j++) {
                System.out.print(ints[j]);
            }
            System.out.println();
        }
        return path[grid.length % 2 == 0 ? 1 : 0][grid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        int i = minPathSum(grid);
        System.out.println(i);
    }
}
