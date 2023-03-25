package com.dl.jeudesensah.web.Servlet;

import com.dl.jeudesensah.Beans.User;
import com.dl.jeudesensah.database.mysqlDb.DaoFactory;
import com.dl.jeudesensah.database.userDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Signing", value = "/Signing")
public class SigninServlet extends HttpServlet {

    private userDao userDAO;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.userDAO = daoFactory.getUserDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect(request.getContextPath() + "/play");
            return;
        }
        String signinPage = "/WEB-INF/views/users/register.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(signinPage);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String signinForm = "/WEB-INF/views/users/login.jsp";
        User user = new User();
        user.setLogin(request.getParameter("login"));
        user.setPassword(request.getParameter("password"));
        user.setNom(request.getParameter("nom"));
        user.setPrenom(request.getParameter("prenom"));
        user.setBestScore(-1);
        if (userDAO.insertUser(user)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect(request.getContextPath() + "/Login");
        } else {
            request.setAttribute("error", "Login already exist");
            RequestDispatcher rd = request.getRequestDispatcher(signinForm);
            rd.forward(request, response);
        }

    }
}
