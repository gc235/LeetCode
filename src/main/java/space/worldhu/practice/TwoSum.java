package space.worldhu.practice;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import space.worldhu.util.Log;

/**
 * 167. 两数之和 II - 输入有序数组
 * @author hushicheng
 * @date 2020/7/20
 */
public class TwoSum {

    /**
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
     *
     * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
     *
     * 说明:
     *
     * 返回的下标值（index1 和 index2）不是从零开始的。
     * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
     * 示例:
     *
     * 输入: numbers = [2, 7, 11, 15], target = 9
     * 输出: [1,2]
     * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSumII_one(int[] numbers, int target) {
        int toIndex = numbers.length - 1;
        for (int i = 0; i < toIndex; i++) {
            int x = target - numbers[i];
            int index = Arrays.binarySearch(numbers, i + 1, numbers.length, x);
            if (index > -1) {
                return new int[]{i + 1, index + 1};
            }
        }
        return null;
    }

    public int[] twoSumII_two(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum < target) {
                ++low;
            } else {
                --high;
            }
        }
        return new int[]{low, high};
    }

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     *
     *  
     *
     * 示例:
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int[] twoSumI(int[] nums, int target) {
        //
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        return null;
    }

    public static int[] twoSum(int[] nums, int target) {
        //一遍哈希表
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        Snowflake snowflake = IdUtil.getSnowflake(1, 1);
        System.out.println(snowflake.nextId());

    }

    public static void println(String formatter, Object... objs) {
        for (int i = 0; i < objs.length; i++) {
            formatter = formatter.replaceFirst("\\{}", "{" + i + "}");
        }
        String formatStr = MessageFormat.format(formatter, objs);
        System.out.println(formatStr);
    }

    public static void println(Object obj) {
        System.out.println(JSON.toJSONString(obj));
    }
}
