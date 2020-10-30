package space.worldhu.practice;

import cn.hutool.core.collection.CollectionUtil;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author hushicheng
 * @date 2020/9/22
 */
public class FindMedianSortedArrays {
    /**
     * 4. 寻找两个正序数组的中位数
     * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
     *
     * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     *
     * 你可以假设 nums1 和 nums2 不会同时为空。
     *
     * 示例 1:
     *
     * nums1 = [1, 3]
     * nums2 = [2]
     *
     * 则中位数是 2.0
     * 示例 2:
     *
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     *
     * 则中位数是 (2 + 3)/2 = 2.5
     */

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return findMedian(nums2);
        } else if (nums2.length == 0) {
            return findMedian(nums1);
        } else if (nums1[nums1.length - 1] <= nums2[0]) {
            return findMedian(nums1, nums2);
        } else if (nums2[nums2.length - 1] <= nums1[0]) {
            return findMedian(nums2, nums1);
        }
        //合并
        int p1 = 0;
        int p2 = 0;
        int[] arr = new int[nums1.length + nums2.length];
        int index = 0;

        int mediumLength = 0;
        int rightMediumLength = 0;
        int leftMediumLength = 0;
        int mod = 2;
        if (arr.length % mod == 0) {
            rightMediumLength = arr.length / 2;
            leftMediumLength = arr.length / 2 - 1;
        } else {
            mediumLength = arr.length / 2;
        }

        while (index < arr.length) {
            if (p1 < nums1.length && p2 < nums2.length) {
                if (nums1[p1] <= nums2[p2]) {
                    arr[index++] = nums1[p1++];
                } else {
                    arr[index++] = nums2[p2++];
                }
            } else if (p1 == nums1.length && p2 < nums2.length){
                arr[index++] = nums2[p2++];
            } else if (p1 < nums1.length && p2 == nums2.length){
                arr[index++] = nums1[p1++];
            }
            if (arr.length % mod == 0 && (index - 1) == rightMediumLength) {
                return (arr[index - 2]);
            }
        }
        return findMedian(arr);
    }

    public double findMedian(int[] nums) {
        int length = nums.length;
        int mod = 2;
        if (length % mod == 0) {
            return (nums[length/2] + nums[length/2 - 1]) / 2f;
        } else {
            return nums[length/2];
        }
    }

    public double findMedian(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int mod = 2;
        int halfLength = length / 2;
        if (length % mod == 0) {
            int left = (halfLength > (nums1.length - 1)) ? nums2[halfLength - nums1.length] : nums1[halfLength];
            int temp = halfLength - 1;
            int right = (temp > (nums1.length - 1)) ? nums2[temp - nums1.length] : nums1[temp];
            return (left + right) / 2f;
        } else {
            return (halfLength > (nums1.length - 1)) ? nums2[halfLength - nums1.length] : nums1[halfLength];
        }
    }

    public static void main(String[] args) {
        FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();
        double medianSortedArrays = findMedianSortedArrays
                .findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        System.out.println(medianSortedArrays);
    }
}
