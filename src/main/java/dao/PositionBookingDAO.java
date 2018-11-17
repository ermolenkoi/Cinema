package dao;

import exceptions.PositionBookingDaoException;
import model.Position;

import java.util.List;

public interface PositionBookingDAO {
    //записать забронированную или выкупленную позицию в бд
    void addPositionBooking(int seanceId, Position position) throws PositionBookingDaoException;
    //удалить из бызы даных забронированное или выкупленное место
    void deletePositionBooking(int seanceId, int positionId) throws PositionBookingDaoException;
    //изменить статус забронированной позиции на выкупленную
    void updatePositionBooking(int seanceId, int positionId) throws PositionBookingDaoException;
    //получить список всех не свободных мест по шв сеанса
    List<Position> getPositionBooking(int seanceId) throws PositionBookingDaoException;

}
