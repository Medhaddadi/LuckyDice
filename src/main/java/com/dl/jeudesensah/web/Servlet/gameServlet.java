package com.dl.jeudesensah.web.Servlet;

import com.dl.jeudesensah.Beans.User;
import com.dl.jeudesensah.database.mysqlDb.DaoFactory;
import com.dl.jeudesensah.database.userDao;
import com.dl.jeudesensah.web.Helpers.Game;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "play", value = "/play")
public class gameServlet extends HttpServlet {
    userDao gameDAO;
    public void init() throws ServletException {
        this.gameDAO = (userDao) this.getServletContext().getAttribute("gameData");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gamePage = "/WEB-INF/views/game/play.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(gamePage);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get the number of the dice
        int NumberDes = Integer.parseInt(request.getParameter("desNumber"));
        //get the session
        HttpSession session = request.getSession();
        String gameoverPage = "/WEB-INF/views/game/gameover.jsp";
        String gamePage = "/WEB-INF/views/game/play.jsp";
        User user = (User) session.getAttribute("user");
        Game game = (Game) session.getAttribute("gameState");
        //if the game is null, create a new game
        if (game == null) {
            game = new Game(-1, false, user);
        }
        //if the game is over, redirect to gameover page
        if (game.isGameover()){
            //update the score of the user and redirect to gameover page
            RequestDispatcher rd = request.getRequestDispatcher(gameoverPage);
            rd.forward(request, response);
            return;
        }
        int desValue = game.generateRandomNumber();
        game.addDesNumberValue(NumberDes, desValue);
        session.setAttribute("gameState", game);
        request.setAttribute("game", game);
        System.out.println(game);
        if (game.isGameover()) {
            gameDAO.updateScore(game.getUser());
            RequestDispatcher rd = request.getRequestDispatcher(gameoverPage);
            rd.forward(request, response);
            return;
        } else {
            RequestDispatcher rd = request.getRequestDispatcher(gamePage);
            rd.forward(request, response);
        }
    }
}