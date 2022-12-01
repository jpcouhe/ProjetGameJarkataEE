package com.example.demo_jarkataee.servlet;

import com.example.demo_jarkataee.dao.Dao;
import com.example.demo_jarkataee.dao.GameDao;
import com.example.demo_jarkataee.dao.GameDaoJpa;
import com.example.demo_jarkataee.factory.DaoFactory;
import com.example.demo_jarkataee.model.Game;
import com.example.demo_jarkataee.utilities.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.List;



/*@WebServlet(urlPatterns = "/games")*/
@WebServlet(urlPatterns = {"/home", "" })

public class GameListServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Dao<Game> gameDao = DaoFactory.getGameFao();
      /*  GameDao gameDao = new GameDao();*/
        List<Game> gameList = gameDao.getAll();

        req.setAttribute("games", gameList);
        this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);

    }
}
