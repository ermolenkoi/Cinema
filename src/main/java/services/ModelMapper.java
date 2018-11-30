package services;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class ModelMapper {
    public static List<DTOFilms> convertToDto(Schedule schedule){
        List<DTOFilms> dtoFilms = new ArrayList<>();

        List<Seance> seances = schedule.getSeances();

        for(Seance seance: seances){

            DTOSeances dtoSeance = new DTOSeances();
            dtoSeance.setId(seance.getId());
            dtoSeance.setFilmName(seance.getFilm().getName());
            dtoSeance.setStartSeance(seance.getStartSeance());
            dtoSeance.setPriceTicket(seance.getPriceTicket());

            if (dtoFilms.size()<1){
                DTOFilms dtoFilm = new DTOFilms();
                dtoFilm.setId(seance.getFilm().getFilmId());
                dtoFilm.setFilmName(seance.getFilm().getName());
                dtoFilm.setTypeVideo(seance.getFilm().getTypeVideo());

                DTOCinema dtoCinema = new DTOCinema();
                dtoCinema.setHallName(seance.getCinemaHall().getName());
                dtoCinema.getDtoSeances().add(dtoSeance);

                dtoFilm.getDtoCinemas().add(dtoCinema);
                dtoFilms.add(dtoFilm);
            } else {
                Boolean flag = true;
                for (DTOFilms film: dtoFilms){
                    if (dtoSeance.getFilmName().equals(film.getFilmName())){
                        for (DTOCinema cinema: film.getDtoCinemas()){
                            if (cinema.getHallName().equals(seance.getCinemaHall().getName())){
                                cinema.getDtoSeances().add(dtoSeance);
                                flag = false;
                            }
                        }
                        if (flag){
                            DTOCinema dtoCinema = new DTOCinema();
                            dtoCinema.setHallName(seance.getCinemaHall().getName());
                            dtoCinema.getDtoSeances().add(dtoSeance);
                            film.getDtoCinemas().add(dtoCinema);
                            flag = false;
                        }
                    }
                }
                if (flag){
                    DTOFilms dtoFilm = new DTOFilms();
                    dtoFilm.setId(seance.getFilm().getFilmId());
                    dtoFilm.setFilmName(seance.getFilm().getName());
                    dtoFilm.setTypeVideo(seance.getFilm().getTypeVideo());

                    DTOCinema dtoCinema = new DTOCinema();
                    dtoCinema.setHallName(seance.getCinemaHall().getName());
                    dtoCinema.getDtoSeances().add(dtoSeance);

                    dtoFilm.getDtoCinemas().add(dtoCinema);
                    dtoFilms.add(dtoFilm);
                }
            }

        }
        return dtoFilms;
    }
}
