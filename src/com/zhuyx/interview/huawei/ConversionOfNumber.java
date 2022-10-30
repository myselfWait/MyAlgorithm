package com.zhuyx.interview.huawei;

import java.util.Scanner;

/**
 * @author liyan
 * @version 1.0.0
 * @description 输入一个十六进制的数输出一个十进制的数
 * @date 2022/10/30 19:25
 */
public class ConversionOfNumber {

    public static void main(String[] args) {
//        System.out.println("请输入一个数:");
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别

        // 接收一个数
        String a = in.nextLine();
        String aUp = a.toUpperCase();
        // 检验这个数是否为16进制
        String b = aUp.startsWith("0X") ? aUp.substring(2) : aUp;
        String regex = "^[A-F0-9]+$";
        if (!b.matches(regex)) {
            return;
        }
        String c = b.replaceAll("^0*", "");
        char[] chars = c.toCharArray();
        Long result = 0L;
        for (int i = chars.length - 1; i >= 0; i--) {
            int temp = chars[i] >= 'A' && chars[i] <= 'F' ? chars[i] - 'A' + 10 : chars[i] - '0';
            result = result + (long) (temp * Math.pow(16, chars.length - 1 - i));

        }
        // 将十六进制转换成十进制，从最低为开始每取一位乘以16，然后相加
        System.out.println(result);
        // 输出
    }

}
