package dao;

import exceptions.PositionBookingDaoException;
import model.Position;

import java.util.List;

public interface PositionBookingDAO {
    //записать забронированную или выкупленную позицию в бд
    void addPositionBooking(long seanceId, Position position) throws PositionBookingDaoException;
    //удалить из бызы даных забронированное или выкупленное место
    void deletePositionBooking(long seanceId, int positionId) throws PositionBookingDaoException;
    //изменить статус забронированной позиции на выкупленную
    void updatePositionBooking(long seanceId, int positionId) throws PositionBookingDaoException;
    //получить список всех не свободных мест по id сеанса
    List<Position> getPositionBooking(long seanceId) throws PositionBookingDaoException;

}
