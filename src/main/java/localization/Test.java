package localization;

import java.util.Locale;
import java.util.ResourceBundle;

public class Test {
    public static void main(String[] args) {
        Locale locale = new Locale("fr");
        ResourceBundle rb = ResourceBundle.getBundle("localization.SRBundel");
    //    System.out.println(rb.getString("Hi"));

        Locale loc = Locale.forLanguageTag("ens_US");
        System.out.println(loc);
    }
}
