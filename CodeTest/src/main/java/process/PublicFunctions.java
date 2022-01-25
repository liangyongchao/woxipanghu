package process;

import pojo.alphabet;

import java.util.ArrayList;

public class PublicFunctions {

    public static ArrayList StringToList(String input){
        char[] chars = input.toCharArray();
        ArrayList list = new ArrayList();
        for(char c : chars){
            list.add(String.valueOf(c));
        }
        return  list;
    }

    public static String GetFrontLetter(String input){

        ArrayList<String> list = alphabet.alphabet;

        Integer i = list.indexOf(input);

        String front = (i > 0 ) ? list.get(i - 1) : "";

        return front;

    }
}
