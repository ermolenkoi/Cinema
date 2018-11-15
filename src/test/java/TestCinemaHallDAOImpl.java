import dao.CinemaHallDAO;
import dao.CinemaHallDAOImpl;
import exceptions.CinemaHallDaoException;
import model.CinemaHall;
import model.HallName;
import model.TypeVideo;

public class TestCinemaHallDAOImpl {
    public static void main(String[] args) throws CinemaHallDaoException {
        CinemaHallDAO cinemaHallDAO = new CinemaHallDAOImpl();
        TypeVideo typeVideo = cinemaHallDAO.getTypeVideoCinemaHall(HallName.NUMBER_3);
        System.out.println(typeVideo);
        System.out.println();

        CinemaHall cinemaHall = cinemaHallDAO.getCinemaHall(HallName.NUMBER_2);
        System.out.println(cinemaHall);
    }
}
