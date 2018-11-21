import dao.*;
import exceptions.CinemaHallDaoException;
import exceptions.PositionBookingDaoException;
import exceptions.PositionServiceExceptions;
import exceptions.SeanceDaoException;
import services.PositionService;
import model.CinemaHall;
import model.Position;
import model.Seance;
import model.Status;
import services.PositionServiceImpl;

import java.util.List;

public class TestPositionBookingDAOImpl {
    public static void main(String[] args) {
        PositionService positionService = new PositionServiceImpl();
        PositionBookingDAO positionBookingDAO = new PositionBookingDAOImpl();
        SeanceDAO seanceDAO = new SeanceDAOImpl();
        CinemaHallDAO cinemaHallDAO = new CinemaHallDAOImpl();

        try {
            Seance seance = seanceDAO.getSeance(1);
            CinemaHall cinemaHall = cinemaHallDAO.getCinemaHall(seance.getCinemaHall().getId());

            List<Position> positionBooking = positionBookingDAO.getPositionBooking(seance.getId());
            List<Position> allPositions = positionService.fillPositions(cinemaHall.getSetPositions(), positionBooking);

            cinemaHall.setSetPositions(allPositions);

            int idPosition = 107;
            for (Position p: cinemaHall.getSetPositions()){
                if (p.getId() == idPosition){
                    positionService.updateStatusPosition(p, Status.RESERVED);
                    positionBookingDAO.deletePositionBooking(seance.getId(), p.getId());
                    positionBookingDAO.addPositionBooking(seance.getId(), p);
                }
            }

            System.out.println(seance);
            System.out.println(cinemaHall);
        } catch (PositionServiceExceptions | PositionBookingDaoException | CinemaHallDaoException | SeanceDaoException e) {
            e.printStackTrace();
        }
    }
}
