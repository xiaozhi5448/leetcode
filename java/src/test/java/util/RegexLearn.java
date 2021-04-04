package util;
import java.util.regex.*;
public class RegexLearn {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("(\\w+)\\((\\d+)\\)");
        Matcher m = p.matcher("xiaozhi(13)");
//        System.out.println(m.matches());
        System.out.println(m.find());
        System.out.println(m.groupCount());
        System.out.println(m.start(1));
        System.out.println(m.end(1));
        System.out.println(m.group());

        p = Pattern.compile("([a-z]+)\\((\\d+)\\)");
        System.out.println(p.toString());
        m = p.matcher("xiaozhi(18)");
        System.out.println(m.matches());
//        System.out.println(m.find());
        System.out.println(m.groupCount());
        System.out.println(m.start());
        System.out.println(m.end());
        System.out.println(m.group());
        System.out.println(m.group(1));

    }
}
