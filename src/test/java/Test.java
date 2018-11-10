/*
import services.SeanceServiceImpl;
import model.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Test {
    public static void main(String[] args) {
        SeanceServiceImpl seanceServiceImpl = new SeanceServiceImpl();
        //создаю даты и время начала сеансов
        Calendar hall3_9_30 = new GregorianCalendar(2018,Calendar.OCTOBER,31,9,30);
        Calendar hall1_18_00 = new GregorianCalendar(2018,Calendar.OCTOBER,30,18,0);
        Calendar hall1_20_10 = new GregorianCalendar(2018,Calendar.OCTOBER,30,20,10);

        //создаю фильмы
        Film film_K9 = new Film("K9", TypeVideo.VIDEO, new GregorianCalendar(1989, Calendar.APRIL, 28));
        Film film_Venom_IMAX = new Film("Venom", TypeVideo.IMAX, new GregorianCalendar(2018, Calendar.OCTOBER, 4));
        Film film_Venom_3D = new Film("Веном в 3D", TypeVideo.D3, new GregorianCalendar(2018, Calendar.OCTOBER, 4));
        Film film_SupperBobrovi_2 = new Film("Супер Бобровы 2", TypeVideo.D3, new GregorianCalendar(2018, Calendar.NOVEMBER, 1));

        //создаю сеансы
        Seance seance_3hall_9_30 = seanceServiceImpl.createSeance(film_K9, hall3_9_30, 200.00, new CinemaHall(HallName.NUMBER_3));
        Seance seance_1hall_18_00 = seanceServiceImpl.createSeance(film_Venom_IMAX, hall1_18_00, 360.00, new CinemaHall(HallName.NUMBER_1));
        Seance seance_1hall_20_00 = seanceServiceImpl.createSeance(film_Venom_IMAX, hall1_20_10, 360.00, new CinemaHall(HallName.NUMBER_1));

        //добавляю сеансы в расписание
        seanceServiceImpl.addSeance(seance_3hall_9_30);
        seanceServiceImpl.addSeance(seance_1hall_18_00);
        seanceServiceImpl.addSeance(seance_1hall_20_00);
        System.out.println(Schedule.getInstance().getSeances());

        //получить сеанс по залу и времени
        Seance testSeance = seanceServiceImpl.getSeance(hall1_18_00, HallName.NUMBER_1);
        System.out.println(testSeance);

        //изменить цену сеанса
        seanceServiceImpl.updatePriceSeance(hall1_18_00, HallName.NUMBER_1, 300.00);
        System.out.println(seanceServiceImpl.getSeance(hall1_18_00, HallName.NUMBER_1));

        //изменить статус места
        System.out.println(seanceServiceImpl.getSeance(hall1_18_00, HallName.NUMBER_1).getCinemaHall());
        Position position = new Position(1,1);
        seanceServiceImpl.updateStatusPosition(hall1_18_00, HallName.NUMBER_1, position, Status.CLOSED);
        System.out.println();
        System.out.println(seanceServiceImpl.getSeance(hall1_18_00, HallName.NUMBER_1).getCinemaHall());
    }
}
*/
