package model;

import java.util.ArrayList;
import java.util.List;

public class DTOCinema {
    HallName hallName;
    List<DTOSeances> dtoSeances = new ArrayList<>();

    public HallName getHallName() {
        return hallName;
    }

    public void setHallName(HallName hallName) {
        this.hallName = hallName;
    }

    public List<DTOSeances> getDtoSeances() {
        return dtoSeances;
    }

    public void setDtoSeances(List<DTOSeances> dtoSeances) {
        this.dtoSeances = dtoSeances;
    }
}
