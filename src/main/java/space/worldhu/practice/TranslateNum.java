package space.worldhu.practice;

/**
 * @author hushicheng
 * @date 2020/6/16
 */
public class TranslateNum {

    public static void main(String[] args) {
        int r = translateNum(12258);
        System.out.println(r);
    }

    public static int translateNum(int num) {
        System.out.println(num);
        if (num<=9) {return 1;}
        //获取输入数字的余数，然后递归的计算翻译方法
        int ba = num%100;
        //如果小于等于9或者大于等于26的时候，余数不能按照2位数字组合，比如56，只能拆分为5和6；反例25，可以拆分为2和5，也可以作为25一个整体进行翻译。
        if (ba<=9||ba>=26) {return translateNum(num/10);}
        // ba=[10, 25]时，既可以当做一个字母，也可以当做两个字母
        else  {return translateNum(num/10)+translateNum(num/100);}
    }
}
