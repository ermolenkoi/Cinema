import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {

        LocalDateTime t1 = LocalDateTime.of(2018,12,2,10,0);
        LocalDateTime t2 = LocalDateTime.of(2018,12,2,10,0);
        LocalDateTime t3 = LocalDateTime.of(2018,12,2,11,0);

        System.out.println(!t1.equals(t2));
    }
}
