package space.worldhu.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 125. 验证回文串
 * @author hushicheng
 * @date 2020/6/19
 */
public class IsPalindrome {

    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     *
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     *
     * 示例 1:
     *
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     * 示例 2:
     *
     * 输入: "race a car"
     * 输出: false
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-palindrome
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static boolean isPalindrome(String s) {
        //正则很耗时
//        s = s.replaceAll("[^A-Za-z0-9]", "");
        List<Character> characterList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c > 47 && c < 58) || (c > 64 && c < 91) || (c > 96 && c < 123)) {
                characterList.add(c);
            }
        }
        System.out.println(s);
        if (characterList.size() == 0) {
            return true;
        }
        System.out.println(characterList.size());

        int ll = (int) Math.ceil(characterList.size() / 2.0);
        int endIndex = characterList.size() - 1;
        for (int i = 0; i < ll; i++) {
            char f = characterList.get(i);
            char b = characterList.get(endIndex - i);
            System.out.println(f + " " + b);
            if (f > 96) {
                f -= 32;
            }
            if (b > 96) {
                b -= 32;
            }
            if (f != b) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean palindrome = isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(palindrome);
    }
}
