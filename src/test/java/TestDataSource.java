import exceptions.FilmDaoException;
import model.Film;
import model.TypeVideo;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDataSource {
    private static final String SELECT
            = "SELECT id, name, type, duration FROM films";
    /*public static void main(String[] args) throws FilmDaoException {
        List<Film> films = new ArrayList<>();
        DataSource ds = MyDataSourceFactory.getMyDataSource("postgres");
        try (Connection con = ds.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(SELECT);
            ResultSet resultSet = preparedStatement.executeQuery()){
                System.out.println(con.getClass());
                while (resultSet.next()){
                    films.add(fillFilm(resultSet));
                }
                for (Film film: films){
                    System.out.println(film.toString());
                }
        } catch (SQLException ex) {
            throw new FilmDaoException(ex);
        }
    }*/

    //собрать объект Film из строки таблици films в базе данных
    private static Film fillFilm (ResultSet resultSet) throws SQLException{
        Film film = new Film();
        film.setFilmId(resultSet.getInt("id"));
        film.setName(resultSet.getString("name"));
        int type = resultSet.getInt("type");
        film.setTypeVideo(TypeVideo.getType(type));
        film.setDuration(resultSet.getInt("duration"));
        return film;
    }
}
