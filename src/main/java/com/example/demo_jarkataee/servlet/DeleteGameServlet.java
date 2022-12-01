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

@WebServlet(name = "DeleteGameServlet", value = "/deleteGame")
public class DeleteGameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("idGame");
        System.out.println(idStr);
        try{
            Long id = Long.parseLong(idStr);
            Dao<Game> gameDao = DaoFactory.getGameFao();
            /*GameDao gameDao = new GameDao();*/
            Optional<Game> game= gameDao.get(id);
            if(game.isPresent()){
                gameDao.delete(game.get());
                response.sendRedirect(request.getContextPath() + "/home");
            }else{
                request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
            }

        }catch (NumberFormatException e){
            System.err.println(e.getMessage());
        }



    }
}
