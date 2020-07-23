package space.worldhu.practice;

/**
 * 718. 最长重复子数组
 * @author hushicheng
 * @e-mail upcoder.hu@gmail.com
 * @date 2020/7/1
 */
public class FindLength {


    /**
     * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
     *
     * 示例 1:
     *
     * 输入:
     * A: [1,2,3,2,1]
     * B: [3,2,1,4,7]
     * 输出: 3
     * 解释:
     * 长度最长的公共子数组是 [3, 2, 1]。
     * 说明:
     *
     * 1 <= len(A), len(B) <= 1000
     * 0 <= A[i], B[i] < 100
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param A
     * @param B
     * @return
     */
    public int findLength(int[] A, int[] B) {
        int max = 0;
        for (int i = 0; i < A.length; i++) {

            for (int j = 0; j < B.length; j++) {
                int length = 0;
                while ((i + length) < A.length && (j + length) < B.length && A[i + length] == B[j + length]) {
                    length++;
                }
                max = Math.max(max, length);
            }
        }
        return max;
    }

    public int findLengthDP(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindLength findLength = new FindLength();
        int[] A = {0,0,0,0,0,0,1,0,0,0};
        int[] B = {0,0,0,0,0,0,0,1,0,0};
        long x = System.currentTimeMillis();
        int length = 0;
        for (int i = 0; i < 1000000; i++) {
            length = findLength.findLength(A, B);
        }
        long y = System.currentTimeMillis();
        System.out.println(length);
        System.out.println(y-x);
    }

}
