package servlets;

import com.google.gson.Gson;
import exceptions.ScheduleServiceException;
import model.DTOFilms;
import model.DTOSeances;
import model.Schedule;
import services.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

public class GetSchedule extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        ScheduleService scheduleService = new ScheduleServiceImpl();

        Schedule schedule = null;

        String dateString = req.getParameter("date");
        LocalDate dateSchedule = LocalDate.parse(dateString);
        try {
            schedule = scheduleService.getSchedule(dateSchedule);
        } catch (ScheduleServiceException e) {
            e.printStackTrace();
        }

        List<DTOFilms> dtoSeances = ModelMapper.convertToDto(schedule);

        String jsonObject = new Gson().toJson(dtoSeances);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");


        out.print(jsonObject);
        out.flush();

    }
}
