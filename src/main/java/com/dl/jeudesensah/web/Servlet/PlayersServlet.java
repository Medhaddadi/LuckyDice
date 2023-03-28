package com.dl.jeudesensah.web.Servlet;

import com.dl.jeudesensah.Beans.User;
import com.dl.jeudesensah.database.mysqlDb.DaoFactory;
import com.dl.jeudesensah.database.userDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "players", value = "/players")
public class PlayersServlet extends HttpServlet {
    userDao userDAO;
    public void init() throws ServletException {
        this.userDAO = (userDao) this.getServletContext().getAttribute("gameData");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> players = userDAO.getAllUsers();
        request.setAttribute("players", players);
        System.out.println(request.getAttribute("players"));
        String playersPage = "/WEB-INF/views/users/Players.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(playersPage);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
