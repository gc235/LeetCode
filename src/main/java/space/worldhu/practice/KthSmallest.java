package space.worldhu.practice;

import cn.hutool.crypto.SecureUtil;

/**
 * 378. 有序矩阵中第K小的元素
 * @author hushicheng
 * @e-mail upcoder.hu@gmail.ocm
 * @date 2020/7/2
 */
public class KthSmallest {
    /**
     * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
     * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
     *
     *  
     *
     * 示例：
     *
     * matrix = [
     *    [ 1,  5,  9],
     *    [10, 11, 13],
     *    [12, 13, 15]
     * ],
     * k = 8,
     *
     * 返回 13。
     *  
     *
     * 提示：
     * 你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int kthSmallest(int[][] matrix, int k) {
        return 0;
    }

    public static void main(String[] args) {
        String s = "文和";
        for (int i = 0; i < 100000000; i++) {
            s = SecureUtil.md5(s);

        }
        System.out.println(s);
    }

}
