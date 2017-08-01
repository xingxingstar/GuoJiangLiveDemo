package com.example.zhuwojia.guojianglivedemo.utils;

/**
 * author：shixinxin on 2017/6/23
 * version：v1.0
 */

public class RegexMatches {

    public static boolean phoneRegex(String phone) {
        String pattern = "(13\\d|14[57]|15[^4,\\D]|17[13678]|18\\d)\\d{8}|170[0589]\\d{7}";
        if (phone.isEmpty()) {
            return false;
        } else {
            return phone.matches(pattern);
        }
    }
}
