import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        LocalDateTime d1 = LocalDateTime.of(2018, 12, 8, 10,10);
        LocalDateTime d2 = LocalDateTime.of(2018, 12, 8, 10,20);
        LocalDateTime d3 = LocalDateTime.of(2018, 12, 8, 10,30);
        LocalDateTime d4 = LocalDateTime.of(2018, 12, 8, 10,40);

        LocalTime t1 = LocalTime.of(10,0);
        LocalTime t2 = LocalTime.of(10,20);

        System.out.println(t1.isAfter(t2));

        Set<LocalDateTime> set = new TreeSet<>();
        set.add(d1);
        set.add(d2);
        set.add(d3);
        set.add(d4);

        System.out.println(((TreeSet<LocalDateTime>) set).ceiling(d2.plusMinutes(1)));


    }
}
