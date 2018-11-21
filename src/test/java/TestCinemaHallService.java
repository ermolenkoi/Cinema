import exceptions.CinemaHallDaoException;
import model.CinemaHall;
import services.CinemaHallService;
import services.CinemaHallServiceImpl;

public class TestCinemaHallService {
    public static void main(String[] args) throws CinemaHallDaoException {

        CinemaHallService cinemaHallService = new CinemaHallServiceImpl();

        CinemaHall cinemaHall = cinemaHallService.getCinemaHall(1);
        System.out.println(cinemaHall);
    }
}
