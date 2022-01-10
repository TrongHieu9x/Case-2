package Case_2.Qlnv;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    private static Pattern pattern;
    private static Matcher matcher;
    private static final String ID_REGEX = "^[CG]+[0-9]+$";
    private static final String SDT_REGEX = "^[0][0-9]{9}$";
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";


    public static boolean validateId(String regex) {
        pattern = pattern.compile(ID_REGEX);
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validateSDT(String regex) {
        pattern = pattern.compile(SDT_REGEX);
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validateEmail(String regex) {
        pattern = pattern.compile(EMAIL_REGEX);
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
