package localization;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Locale;

public class LocaleDemo {
    public static void main(String[] args) {
        Locale locale = new Locale("hi");
        locale = new Locale("hi","IN");
        locale = new Locale("IN");
        System.out.println(locale);

        LocalDate.of(2014, Month.JUNE, 21);
    }
}
