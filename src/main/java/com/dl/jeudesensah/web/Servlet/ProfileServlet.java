package com.dl.jeudesensah.web.Servlet;

import com.dl.jeudesensah.database.mysqlDb.DaoFactory;
import com.dl.jeudesensah.database.userDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "profile", value = "/profile")
public class ProfileServlet extends HttpServlet {
    userDao userDAO;
    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.userDAO = daoFactory.getUserDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String profilePage = "/WEB-INF/views/users/profile.jsp";
        request.setAttribute("player", request.getSession().getAttribute("user"));
        RequestDispatcher rd = request.getRequestDispatcher(profilePage);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
