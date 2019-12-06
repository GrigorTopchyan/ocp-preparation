package date_time_api;

import java.time.Duration;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class DurationDemo {
    public static void main(String[] args) {
        String m1 = Duration.of(1, ChronoUnit.MINUTES).toString();
        String m2 = Duration.ofMinutes(1).toString();
        String s = Duration.of(60, ChronoUnit.SECONDS).toString();
        String d = Duration.ofDays(1).toString();
        String p = Period.ofDays(1).toString();

        System.out.println(m1 + "\n" + m2 + "\n" + s + "\n" + d + "\n" + p);

        System.out.println( m1.equals(m2));
        System.out.println( m1.equals(s));

        System.out.println( d.equals(p));

    }
}
