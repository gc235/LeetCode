package space.worldhu.practice;

/**
 * @author hushicheng
 * @date 2020/8/13
 */
public class MultiplyStrings {

    /**
     * 43. 字符串相乘难度中等
     * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     * 示例 1:
     * 输入: num1 = "2", num2 = "3"
     * 输出: "6"
     *
     * 示例 2:
     * 输入: num1 = "123", num2 = "456"
     * 输出: "56088"
     *
     * 说明：
     *
     * 	1. num1 和 num2 的长度小于110。
     * 	2. num1 和 num2 只包含数字 0-9。
     * 	3. num1 和 num2 均不以零开头，除非是数字 0 本身。
     * 	4. 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
     */

    public String multiply(String num1, String num2) {
        int[] arr2 = new int[num2.length()];
        for (int i = num2.length() - 1; i > -1; i--) {
            arr2[i] = Integer.parseInt(num2.substring(i, i + 1));
        }
        
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Math.pow(2, 300));
    }

}
