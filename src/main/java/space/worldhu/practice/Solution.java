package space.worldhu.practice;


/**
 * @author hushicheng
 * @date 2020/9/17
 */
public class Solution {

    public static void main(String[] args) {

    }
//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
//如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
//您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//示例：
//
//输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/add-two-numbers
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ll1 = l1;
        ListNode ll2 = l2;
        int carry = 0;
        ListNode result;
        while (ll1 != null || ll2 != null) {
            int sum = ll1.val + ll2.val + carry;
            if (ll1 != null && ll2 != null) {

            }
            carry = sum > 10 ? (sum - 10) : 0;
            ll1 = ll1.next;
            ll2 = ll2.next;
        }

        return null;
    }

    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
