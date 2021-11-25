package com.bigboss;

import com.bigboss.utils.WebClientUtils;

public class WebClientTest {

    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            String s = WebClientUtils.doHttpRequest("https://baidu.com/", null, String.class, null);
            System.out.println(s);
            System.out.println(i);
        }
    }
}
