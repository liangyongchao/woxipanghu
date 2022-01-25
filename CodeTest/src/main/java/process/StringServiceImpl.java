package process;

import java.util.ArrayList;

public class StringServiceImpl implements StringService {

    private char chars[];
    private ArrayList<String> list = new ArrayList<String>();
    String[] args = new String[3];

    private Integer tagRemove = 1;
    private Integer tagReplace = 2;


    @Override
    public String Process(String input, Integer tag) {

        this.list = PublicFunctions.StringToList(input);

        if(!Validation(list)) return "";

        String r = ProcessWithTag(list, tag);
        for(Integer i = 0; i <= r.length(); i ++)
        {
            r = ProcessWithTag(PublicFunctions.StringToList(r), tag);
        }
        return r;
    };

    private String ProcessWithTag(ArrayList<String> list, Integer tag) {
        String body = "";
        String repeatLetter = "";
        Integer repeatCnt = 0;
        Integer len = list.size();
        Integer location = 0;

        if(len < 3){
            return String.join("", list);
        }

        for(String s : list){
            location ++;


            if(repeatLetter.equals(s) && location < len ){
                body = body + s;
                repeatCnt ++;
            }

            if(repeatLetter.equals(s) && location == len){
                body = ProcessRepeat(body, repeatCnt, repeatLetter, tag);
            }

            if(!repeatLetter.equals(s) && repeatCnt >= 2 && location < len){
                body = ProcessRepeat(body, repeatCnt, repeatLetter, tag) + s;
                repeatLetter = s;
                repeatCnt = 0;
            }

            if(!repeatLetter.equals(s) && repeatCnt >= 2 && location == len){
                body = ProcessRepeat(body, repeatCnt, repeatLetter, tag) + s;
                repeatLetter = s;
                repeatCnt = 0;
            }

            if(!repeatLetter.equals(s) && repeatCnt < 2){
                body += s;
                repeatLetter = s;
                repeatCnt = 0;
            }

        }
        return body;
    }

    private String ProcessRepeat(String body, Integer cnt, String repeatLetter, Integer tag){

        String s = "";

        if(tag == tagRemove){
            s = body.substring(0, body.length() - cnt -1);
        }

        if(tag == tagReplace){
            s = body.substring(0, body.length() - cnt -1) + PublicFunctions.GetFrontLetter(repeatLetter);
        }

        return s;
    }



    public boolean Validation(ArrayList<String> li){

        String badChar = "";

        badChar = (String) li.stream().filter(ch -> !Character.isLowerCase(ch.charAt(0)))
                .findAny().map(r -> {System.out.println("Sorry, the input is invalid."); return r;})
                .orElse("");

        return (badChar == "" ) ? true : false;
    }
}