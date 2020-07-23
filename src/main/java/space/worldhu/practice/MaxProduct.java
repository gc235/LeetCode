package space.worldhu.practice;

/**
 * 乘积最大子数组
 *
 * @author hushicheng
 * @date 2020/5/18
 */
public class MaxProduct {

    public static void main(String[] args) {
    }

    public int maxProduct(int[] nums) {
        int a = 1;
        int b = 1;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            a = a * nums[i];
            if (max < a) {
                max = a;
            }
            if (nums[i] == 0) {
                a = 1;
            }

            b = b * nums[nums.length - 1 - i];
            if (max < b) {
                max = b;
            }
            if (nums[nums.length - 1 - i] == 0) {
                b = 1;
            }
        }

        int aw = 1;
        int awMax = nums[0];
        for (int i = 0; i < nums.length; i++) {
            aw += nums[i];
            if (aw < nums[i]) {
                aw = nums[i];
            }
        }
        return max;
    }
}
