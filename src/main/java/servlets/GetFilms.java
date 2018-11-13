package servlets;

import com.google.gson.Gson;
import dao.FilmDAO;
import dao.FilmDAOImpl;
import exceptions.FilmDaoException;
import model.Film;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class GetFilms extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        FilmDAO filmDAO = new FilmDAOImpl();
        List<Film> films = null;
        try {
            films = filmDAO.getAllFilms();

            String jsonObject = new Gson().toJson(films);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");

            out.print(jsonObject);

            out.flush();

        } catch (FilmDaoException e) {
            e.printStackTrace();
            out.print("error");
        }

    }
}
