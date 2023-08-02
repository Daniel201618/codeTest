package com.example.codetest.utils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 Java program to check three or
 more consecutive identical
 characters or numbers
 using regular expression

 */

public class ConsecutiveCharactersUtil {

    private static int A_UC_ASCII_VALUE = 65;  //A_Upper_Case
    private static int Z_UC_ASCII_VALUE = 90;  //Z_Upper_Case
    private static int A_LC_ASCII_VALUE = 97;  //a_lower_Case
    private static int Z_LC_ASCII_VALUE = 122;  //z_lower_Case



    public static String resovleStr(String str,String replaceStr)
    {

        String regex  = "(.)\\1{2,}";//([a-zA-Z0-9])\\1\\1+
        Pattern p = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        if (str == null ) {
            return "";
        }
        if(str!=null &&  str.length()<3){
            return str;
        }
        Matcher matcher = p.matcher(str);
        StringBuffer sb = new StringBuffer();
        // 查找并替换与模式匹配的文本
        while (matcher.find()) {
            matcher.appendReplacement(sb, replaceStr);
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public static String loopReplaceStr(String input,String replaceStr){
        //(.)\1{2,}
        String regex  = "(.)\\1{2,}";
        Pattern p = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);

        if (input == null ) {
            return "";
        }
        if(input!=null &&  input.length()<3){
            return input;
        }
        Matcher matcher = p.matcher(input);
        StringBuffer sb = new StringBuffer();
        // 查找并替换与模式匹配的文本
        String strResult ="";
        while (matcher.find()) {
            input =  resovleStr( input, replaceStr);
             matcher = p.matcher(input);
        }
        return input;
    }


    public static  String advancedResovleStr(String str)
    {

        String regex  = "(.)\\1{2,}";//([a-zA-Z0-9])\\1\\1+
        Pattern p = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        if (str == null ) {
            return "";
        }
        if(str!=null &&  str.length()<3){
            return str;
        }
        Matcher matcher = p.matcher(str);
        StringBuffer sb = new StringBuffer();
        String  replaceStr ="";
        // 查找并替换与模式匹配的文本
        while (matcher.find()) {
            char startChar = str.charAt(matcher.start());
            int charAscii = charToByteAscii(startChar);
            if( charAscii >A_UC_ASCII_VALUE && charAscii <= Z_UC_ASCII_VALUE ) {
                replaceStr= ""+asciiToChar(charAscii-1);
            }else if(charAscii > A_LC_ASCII_VALUE && charAscii <= Z_LC_ASCII_VALUE){
                replaceStr= ""+asciiToChar(charAscii-1);
            }
            else{
                replaceStr ="";
            }
            matcher.appendReplacement(sb, replaceStr);
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public static String advancedLoopReplaceStr(String input){
        //(.)\1{2,}
        String regex  = "(.)\\1{2,}";
        Pattern p = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);

        if (input == null ) {
            return "";
        }
        if(input!=null &&  input.length()<3){
            return input;
        }
        Matcher matcher = p.matcher(input);
        StringBuffer sb = new StringBuffer();
        // 查找并替换与模式匹配的文本
        String strResult ="";
        while (matcher.find()) {
            input =  advancedResovleStr( input);
            matcher = p.matcher(input);
        }
        return input;
    }

    private static char asciiToChar(int ascii){
        char ch = (char)ascii;
        return ch;
    }

    private static byte charToByteAscii(char ch){
        byte byteAscii = (byte)ch;

        return byteAscii;
    }

    public static void main(String args[])
    {

        String input ="aabcccbbad";
        String replaceStr ="";
        String output = ConsecutiveCharactersUtil.loopReplaceStr(input,replaceStr);
        System.out.println("basic: "+output);

        String output2 = ConsecutiveCharactersUtil.advancedLoopReplaceStr(input);
        System.out.println("advanced: "+output2);



    }

}
