package space.worldhu.practice;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.MD5;
import cn.hutool.http.HttpUtil;

/**
 * @author hushicheng
 * @date 2020/7/24
 */
public class AddTwoNumbers {

    /**
     * 2. 两数相加 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * <p>
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * <p>
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例：
     * <p>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
     * <p>
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int x = 0;
        int y = 0;
        if (l1 != null) {
            x = l1.val;
        }
        if (l2 != null) {
            y = l2.val;
        }
        int sum = x + y;
        int c = sum / 10;
        ListNode first = new ListNode(sum % 10);
        ListNode temp = first;
        ListNode t1 = l1.next;
        ListNode t2 = l2.next;

        while (t1 != null || t2 != null) {
            x = 0;
            y = 0;
            sum = 0;
            if (t1 != null) {
                x = t1.val;
                t1 = t1.next;
            }
            if (t2 != null) {
                y = t2.val;
                t2 = t2.next;
            }
            sum = x + y + c;
            c = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
        }
        if (c > 0 ) {
            temp.next = new ListNode(c);
        }
        return first;
    }

    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        String x = "73.25%";
        for (int i = 0; i < 200000000; i++) {
            x =SecureUtil.md5(x);
        }
        System.out.println(x);
    }
}
