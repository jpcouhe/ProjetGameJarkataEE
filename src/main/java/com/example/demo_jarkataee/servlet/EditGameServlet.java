package com.example.demo_jarkataee.servlet;

import com.example.demo_jarkataee.dao.Dao;
import com.example.demo_jarkataee.factory.DaoFactory;
import com.example.demo_jarkataee.model.Game;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "EditGameServlet", value = "/games/edit")
public class EditGameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Dao<Game> gameDao = DaoFactory.getGameFao();
        /*GameDao gameDao = new GameDao();*/
        Optional<Game> game = gameDao.get(Long.valueOf(id));

        if(game.isPresent()){
            request.setAttribute("game", game.get());
            request.getRequestDispatcher("/WEB-INF/form.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("gameName");
        String description = request.getParameter("gameDescription");
        String id = request.getParameter("id");
        Game game = new Game(Long.parseLong(id), name, description);
        Dao<Game> gameDao = DaoFactory.getGameFao();
       /* GameDao gameDao = new GameDao();*/
        gameDao.update(game);

        response.sendRedirect(request.getContextPath() + "/home");
    }
}
