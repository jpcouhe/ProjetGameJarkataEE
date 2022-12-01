package com.example.demo_jarkataee.factory;

import com.example.demo_jarkataee.dao.Dao;
import com.example.demo_jarkataee.dao.GameDao;
import com.example.demo_jarkataee.dao.GameDaoJpa;
import com.example.demo_jarkataee.model.Game;

public class DaoFactory {
    private DaoFactory(){}

    public static Dao<Game> getGameFao(){
        return new GameDaoJpa();
        /* return new GameDao();*/
    }

}

