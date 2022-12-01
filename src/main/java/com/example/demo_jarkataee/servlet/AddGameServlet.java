package com.example.demo_jarkataee.servlet;

import com.example.demo_jarkataee.dao.Dao;
import com.example.demo_jarkataee.factory.DaoFactory;
import com.example.demo_jarkataee.model.Game;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/games/add")
public class AddGameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      /*  req.getRequestDispatcher("/WEB-INF/add-game.jsp").forward(req, resp);*/
        req.getRequestDispatcher("/WEB-INF/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("gameName");
        String description = req.getParameter("gameDescription");

        Dao<Game> gameDao = DaoFactory.getGameFao();

        Game game = new Game(name, description);
        /*GameDao gameDao = new GameDao();*/
        gameDao.save(game);

        resp.sendRedirect(req.getContextPath() + "/home");




    }
}
