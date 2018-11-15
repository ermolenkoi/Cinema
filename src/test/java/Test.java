

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class Test {
    public static void main(String[] args) {

        LocalTime d1 = LocalTime.of(23, 0);
        LocalTime d2 = d1.plusMinutes(95);
        System.out.println(d2);

        LocalDate ld = LocalDate.of(2018, 1, 25);
        System.out.println(ld);

        LocalDateTime localDateTime = LocalDateTime.of(ld, d1);
        System.out.println(localDateTime);




    }
}
