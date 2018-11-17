package interfases;

import exceptions.PositionServiceExceptions;
import model.Position;
import model.Status;

import java.util.List;

public interface PositionService {
    //создать позицию
    Position createPosition(int row, int place, Status status);
    //заполнить позиции занятых мест в схеме зала
    List<Position> fillPositions(List<Position> allPositions, List<Position> bookingPositions) throws PositionServiceExceptions;
    //изменить статус позиции и вернуть ее
    Position updateStatusPosition(Position position, Status status) throws PositionServiceExceptions;
}
