package services;

import exceptions.PositionServiceExceptions;
import interfases.PositionService;
import model.Position;
import model.Status;

import java.util.List;

public class PositionServiceImpl implements PositionService {
    //создать позицию
    @Override
    public Position createPosition(int row, int place, Status status) {
        if (status != null){
            return new Position(row, place, status);
        }
        return null;
    }

    //заполнить позиции занятых мест в схеме зала
    @Override
    public List<Position> fillPositions(List<Position> allPositions, List<Position> bookingPositions) throws PositionServiceExceptions {
        if (allPositions != null && bookingPositions != null){
            for(Position booking: bookingPositions){
                for (Position all: allPositions){
                    if (all.getId() == booking.getId()){
                        all.setStatus(booking.getStatus());
                    }
                }
            }
        }
        return allPositions;
    }

    //изменить статус позиции и вернуть ее
    @Override
    public Position updateStatusPosition(Position position, Status status) throws PositionServiceExceptions {
        if (position != null && status != null){
            position.setStatus(status);
        }
        return position;
    }
}
