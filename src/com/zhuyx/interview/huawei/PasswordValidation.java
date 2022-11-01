package com.zhuyx.interview.huawei;

import com.sun.istack.internal.NotNull;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * description：
 * 密码要求:
 * 1.长度超过8位
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 * 3.不能有长度大于2的包含公共元素的子串重复 （注：其他符号不含空格或换行）
 * <p>
 * 数据范围：输入的字符串长度满足 1 \le n \le 100 \1≤n≤100
 * <p>
 * 输入描述：
 * 一组字符串。
 * <p>
 * 输出描述：
 * 如果符合要求输出：OK，否则输出NG
 * <p>
 * 示例：
 * 输入：
 * 021Abc9000
 * 021Abc9Abc1
 * 021ABC9000
 * 021$bc9000
 * 复制
 * 输出：
 * OK
 * NG
 * NG
 * OK
 *
 * @author liyan
 * @version 1.0.0
 * @date 2022/11/1 11:14
 */
public class PasswordValidation {

    public static void main(String[] args) {
        // 1、输入
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            // 判断长度没有超过8位return
            if (str.length() <= 8) {
                System.out.println("NG");
                continue;
            }
            // 符号为三种一下直接return
            if (!isValidationOfTheNmuberOfSymbolTypes(str)) {
                System.out.println("NG");
                continue;
            }
            // 密码是否简单
            if (isSimple(str)) {
                System.out.println("NG");
                continue;
            }
            System.out.println("OK");
        }
    }

    /**
     * 检查输入str是否含有大小写字母.数字.其它符号,以上四种至少三种
     *
     * @param str 输入密码字符串
     * @return ture 字符类型三种以上 否则 false
     */
    private static boolean isValidationOfTheNmuberOfSymbolTypes(String str) {
        int count = 0;
        Pattern capitalPattern = Pattern.compile("[A-Z]");
        if (capitalPattern.matcher(str).find()) {
            count++;
        }
        Pattern lowerPattern = Pattern.compile("[a-z]");
        if (lowerPattern.matcher(str).find()) {
            count++;
        }
        Pattern digitalPattern = Pattern.compile("[0-9]");
        if (digitalPattern.matcher(str).find()) {
            count++;
        }
        Pattern otherPattern = Pattern.compile("[^a-zA-Z0-9]");
        if (otherPattern.matcher(str).find()) {
            count++;
        }
        return count >= 3;
    }

    private static boolean isSimple(String str) {
        return hasDuplcateSubsequences(str, 0, 3);
    }

    private static boolean hasDuplcateSubsequences(@NotNull String str, int l, int r) {
        if (str.isEmpty()) {
            return false;
        }
        if (l < 0 || r < 0 || l > r) {
            return false;
        }
        if (r >= str.length()) {
            return false;
        }
        if (str.substring(r).contains(str.substring(l, r))) {
            return true;
        } else {
            return hasDuplcateSubsequences(str, l + 1, r + 1);
        }
    }


}