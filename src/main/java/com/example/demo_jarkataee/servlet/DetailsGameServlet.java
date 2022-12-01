package com.example.demo_jarkataee.servlet;

import com.example.demo_jarkataee.dao.Dao;
import com.example.demo_jarkataee.dao.GameDao;
import com.example.demo_jarkataee.factory.DaoFactory;
import com.example.demo_jarkataee.model.Game;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "DetailsGameServlet", value = "/games/details")
public class DetailsGameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        /*GameDao gameDao = new GameDao();*/
        Dao<Game> gameDao = DaoFactory.getGameFao();
        Optional<Game> game = gameDao.get(Long.valueOf(id));

        if(game.isPresent()){
            request.setAttribute("game", game.get());
            request.getRequestDispatcher("/WEB-INF/detail-game.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
