package com.httpservlet.test.httpservlets.servlet.utils;

import java.util.Properties;

public final class ProportiesUtil {

    private static final Properties PROPERTIES = new Properties();
   
    private ProportiesUtil() {

    }

    public static String get(String key) {

            return PROPERTIES.getProperty(key);
    }
}
