package com.freund.tabletop_assistant.util;

public final class StringUtil {
    public static String removeLastChar(String str){
        if (str.length() > 0){
            return str.substring(0, str.length() - 1);
        }
        return "";
    }
    
}
