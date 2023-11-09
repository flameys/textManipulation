package testApplication;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class testExpression {

    public static long methodLees(String txt){
        long total;
        Pattern pattern = Pattern.compile("\\{{2}([a-zA-Z0-9_+.-]+)\\}{2}");
        Matcher searchWord = pattern.matcher(txt);
        total = searchWord.results().count();


        int i = 0;
        while (searchWord.find(i)) {
            i = searchWord.start() + 1;

        }
        System.out.println("Found " + total + " match(es) in text");
        return total;
    }


}






