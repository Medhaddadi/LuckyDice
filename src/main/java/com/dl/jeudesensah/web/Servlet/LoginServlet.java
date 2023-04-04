package com.dl.jeudesensah.web.Servlet;

import com.dl.jeudesensah.Beans.User;
import com.dl.jeudesensah.database.mysqlDb.DaoFactory;
import com.dl.jeudesensah.database.userDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Login", value = "/Login")
public class LoginServlet extends HttpServlet {
    userDao userDAO;

    public void init() throws ServletException {
        this.userDAO = (userDao) this.getServletContext().getAttribute("gameData");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect(request.getContextPath() + "/play");
            return;
        }
        String loginPage = "/WEB-INF/views/users/login.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(loginPage);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loginForm = "/WEB-INF/views/users/login.jsp";
        User user=(User) userDAO.getUserByLogin(request.getParameter("login"));
        if (user!=null){
            if (user.getPassword().equals(request.getParameter("password"))){
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                System.out.println("user logged in");
                response.sendRedirect(request.getContextPath() + "/play");
            }else {
                request.setAttribute("error", "Wrong password");
                System.out.println(request.getAttribute("error"));
                RequestDispatcher rd = request.getRequestDispatcher(loginForm);
                rd.forward(request, response);
            }
        }else {
            request.setAttribute("error", "Login not found");
            System.out.println(request.getAttribute("error"));
            RequestDispatcher rd = request.getRequestDispatcher(loginForm);
            rd.forward(request, response);
        }
    }
}
