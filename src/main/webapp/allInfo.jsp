<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Film"%>
<%@ page import="model.TypeVideo"%>
<%@ page import="dao.FilmDAOImpl"%>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Java In HTML</title>
</head>
<body>

    <%Film film = new Film(1245, "Brother", TypeVideo.VIDEO, 90);%>
    <%FilmDAOImpl filmDao = new FilmDAOImpl();%>
    <%List<Film> films = filmDao.getAllFilms();%>

    <br/>
    <h3>Фильмы в прокате</h3>
    <%for(Film f: films){
    %><h2><%=f%></h2>
    </br><%
    }%>






</body>
</html>