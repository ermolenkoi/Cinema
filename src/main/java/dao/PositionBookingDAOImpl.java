package dao;

import exceptions.PositionBookingDaoException;
import model.Position;
import model.Status;
import services.PositionServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionBookingDAOImpl implements PositionBookingDAO{

    private static final String SELECT
            = "SELECT row, place, status FROM Booking_Positions WHERE id_Seance=?";
    private static final String INSERT
            = "INSERT INTO Booking_Positions (id_Seance, id, row, place, status) VALUES (?, ?, ?, ?, ?)";
    private static final String DELETE
            = "DELETE FROM Booking_Positions WHERE id_Seance=? AND id=?";
    private static final String UPDATE
            = "UPDATE Booking_Positions SET status=? WHERE id_Seance=? AND id=?";

    private SimpleConnection simpleConnection = new SimpleConnection();

    //записать забронированную или выкупленную позицию в бд
    @Override
    public void addPositionBooking(long seanceId, Position position) throws PositionBookingDaoException {
        if (position != null) {
            try (Connection connection = simpleConnection.getConnection();
                 PreparedStatement pst = connection.prepareStatement(INSERT)) {
                pst.setLong(1, seanceId);
                pst.setInt(2, position.getId());
                pst.setInt(3, position.getRow());
                pst.setInt(4, position.getPlace());
                pst.setInt(5, Status.getNumType(position.getStatus()));
                pst.executeUpdate();
            } catch (SQLException ex) {
                throw new PositionBookingDaoException(ex);
            }
        }
    }

    //удалить из бызы даных забронированное или выкупленное место
    @Override
    public void deletePositionBooking(long seanceId, int positionId) throws PositionBookingDaoException {
        try(Connection connection = simpleConnection.getConnection();
            PreparedStatement pst = connection.prepareStatement(DELETE)){
            pst.setLong(1, seanceId);
            pst.setInt(2, positionId);
            pst.executeUpdate();
        }catch (Exception ex){
            throw new PositionBookingDaoException(ex);
        }
    }

    //изменить статус забронированной позиции на выкупленную
    @Override
    public void updatePositionBooking(long seanceId, int positionId) throws PositionBookingDaoException {
        try(Connection connection = simpleConnection.getConnection();
            PreparedStatement pst = connection.prepareStatement(UPDATE)) {
            pst.setInt(1, Status.getNumType(Status.CLOSED));
            pst.setLong(2, seanceId);
            pst.setInt(3, positionId);
            pst.executeUpdate();
        } catch (SQLException ex) {
            throw new PositionBookingDaoException(ex);
        }
    }

    //получить список всех не свободных мест по id сеанса
    @Override
    public List<Position> getPositionBooking(long seanceId) throws PositionBookingDaoException {
        List<Position> positionsBooking = null;
        try(Connection connection = simpleConnection.getConnection();
            PreparedStatement pst = connection.prepareStatement(SELECT);){
            pst.setLong(1, seanceId);
            try(ResultSet resultSet = pst.executeQuery();){
                positionsBooking = new ArrayList<>();
                while (resultSet.next()){
                    positionsBooking.add(fillSeance(resultSet));
                }
                return positionsBooking;
            }catch (SQLException ex){
                throw new PositionBookingDaoException(ex);
            }
        }catch (SQLException ex){
            throw new PositionBookingDaoException(ex);
        }
    }

    //собрать объект Position из строки таблици Booking_Positions в базе данных
    public Position fillSeance (ResultSet resultSet) throws SQLException{
        PositionServiceImpl positionService = new PositionServiceImpl();
        int row = resultSet.getInt("row");
        int place = resultSet.getInt("place");
        Status status = Status.getType(resultSet.getInt("status"));
        return positionService.createPosition(row, place, status);
    }
}
