package date_time_api;

import java.time.*;

public class InstantDemo {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, zoneId);
        long epochSeconds = 0;
        Instant instant = Instant.now();
        System.out.println(instant);
        instant = Instant.ofEpochSecond(epochSeconds);
        System.out.println(instant);
        instant = zonedDateTime.toInstant();
        System.out.println(instant);
    }
}
