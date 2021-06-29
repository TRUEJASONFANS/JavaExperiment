package org.zhxie.java.string.operation;

import java.util.Scanner;

/**
 * Created by zhxie on 6/4/2018.
 */
public class FilterStarInString {


    public static String filterStar (String input) {
       return input.replaceAll("(^\\*)|(\\*$)|\\*", "$1$2");
    }

    public static String filterStar2 (String input) {
        StringBuilder newS = new StringBuilder("");
        for (int i = 0; i < input.length(); i++) {
            if (i==0 || i == input.length() -1) {
                newS.append(input.charAt(i)) ;

            }
            else if (input.charAt(i) != '*') {
                newS.append(input.charAt(i)) ;
            }
        }
        return newS.toString();
    }

    public static String filterStar3 (String str) {
        String start = str.substring(0,1);
        String end = str.substring(str.length()-1);
        String afterTrans = start + str.replace("*", "") + end;
        return afterTrans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (scanner.hasNext()) {
            input = scanner.nextLine();
            System.out.println(filterStar2(input));
        }

    }
}
