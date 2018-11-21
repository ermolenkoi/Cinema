package services;

import dao.SeanceDAO;
import dao.SeanceDAOImpl;
import exceptions.SeanceDaoException;
import exceptions.SeanceServiceException;
import model.*;

import java.time.LocalDate;
import java.util.List;

/*
 * сервис управления сеансами
 * */
public class SeanceServiceImpl implements SeanceService {
    private SeanceDAO seanceDAO = new SeanceDAOImpl();

    //добавить сеанс
    @Override
    public void addSeance(Seance seance) throws SeanceServiceException {
        if (seance != null) {
            if (seance.getFilm().getTypeVideo().equals(seance.getCinemaHall().getType())) {
                try {
                    seanceDAO.addSeance(seance);
                } catch (SeanceDaoException e) {
                    e.printStackTrace();
                }
            }else {
                throw new SeanceServiceException("Формат фильма не соответсвует формату зала");
            }
        }
    }

    //получить сеанс по id
    @Override
    public Seance getSeance(long id) throws SeanceServiceException {
        try {
            return seanceDAO.getSeance(id);
        } catch (SeanceDaoException e) {
            e.printStackTrace();
        }
        return null;
    }

    //удалить сеанс по id
    @Override
    public void deleteSeance(long id) throws SeanceServiceException {
        try {
            seanceDAO.deleteSeance(id);
        } catch (SeanceDaoException e) {
            e.printStackTrace();
        }
    }

    //изменить сеанс
    @Override
    public void updateSeance(Seance seance) throws SeanceServiceException {
        try {
            seanceDAO.updateSeance(seance);
        } catch (SeanceDaoException e) {
            e.printStackTrace();
        }
    }

    //получить список сеансов на заданную дату
    @Override
    public List<Seance> getSeancesByDate(LocalDate localDate) throws SeanceServiceException {
        try {
            return seanceDAO.getSeancesByDate(localDate);
        } catch (SeanceDaoException e) {
            e.printStackTrace();
        }
        return null;
    }
}
