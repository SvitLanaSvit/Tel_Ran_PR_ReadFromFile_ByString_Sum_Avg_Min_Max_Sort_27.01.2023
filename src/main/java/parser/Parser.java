package parser;

import exception.InvalidLineException;

import java.util.*;

public class Parser {
    public static List<Integer> pars(String s, int index) throws InvalidLineException {
        List<Integer> list;
        if(checkLine(s)){
           list = Arrays.stream(s.split("\\s+")).filter(e -> e.length() > 0)
                    .map(e -> Integer.parseInt(e)).toList();
        }
        else{
            throw new InvalidLineException("The line " + index  + " is invalid.");
        }
        return list;
    }

    public static boolean checkLine(String str){
        boolean isNum = false;
        var array = Arrays.stream(str.split("\\s+")).filter(e -> e.length() > 0).toList();
        for (String s : array) {
            if (isNumeric(s)) {
                isNum = true;
            } else {
                isNum = false;
                break;
            }
        }
        return isNum;
    }
    private static boolean isNumeric(String str){
        return str != null && str.matches("[0-9.]+");
    }
}