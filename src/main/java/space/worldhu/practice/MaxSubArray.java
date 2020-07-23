package space.worldhu.practice;

/**
 * 最大子序和
 * @author hushicheng
 * @date 2020/5/18
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int i = maxSubArray(nums);
        System.out.println(i);
    }

    public static int maxSubArray(int[] nums) {
        int aw = 0;
        int max = nums[0];
        for (int num : nums) {
            aw += num;
            if (aw < num) {
                aw = num;
            }
            max = Math.max(max, aw);

        }
        return max;
    }
}
