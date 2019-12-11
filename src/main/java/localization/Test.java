package localization;

import java.util.Locale;
import java.util.ResourceBundle;

public class Test {
    public static void main(String[] args) {
        Locale localeFr = new Locale("fr");
       // Locale.setDefault(localeFr);

        Locale localeDe = new Locale("de");
        Locale localeEn = new Locale("en");
        ResourceBundle rb = ResourceBundle.getBundle("SRBundel",localeFr);


        System.out.println(rb.getString("Hi"));
        System.out.println(rb.getString("HE"));


    }
}
