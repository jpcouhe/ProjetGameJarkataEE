package com.example.demo_jarkataee.dao;

import com.example.demo_jarkataee.model.Game;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GameDaoJpa implements Dao<Game> {
    @Override
    public Optional<Game> get(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction et = entityManager.getTransaction();

        try {
            et.begin();
            Game game = entityManager.createQuery("SELECT r FROM Game r WHERE r.id = :idParam", Game.class).setParameter("idParam", id).getSingleResult();
            et.commit();
            return Optional.of(game);
        }catch (Exception e){
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            entityManager.close();
        }
        return Optional.empty();

    }

    @Override
    public List<Game> getAll() {

        List<Game> gameList= new ArrayList<>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction et = entityManager.getTransaction();
        try{
            et.begin();
            TypedQuery<Game> query = entityManager.createQuery("SELECT r from Game r", Game.class);
            gameList = query.getResultList();
            et.commit();
        } catch (Exception e){
            e.printStackTrace();
            if(et.isActive()) {et.rollback();}
        } finally {
            entityManager.close();
        }
        return gameList;
    }

    @Override
    public void save(Game game) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction et = entityManager.getTransaction();

        try{
            et.begin();
            entityManager.persist(game);
            et.commit();
        }catch (Exception e){
            if (et.isActive()) et.rollback();
        } finally {
            emf.close();
        }
    }

    @Override
    public void update(Game game) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction et = entityManager.getTransaction();

        try{
            et.begin();
            Game gameToUpdate = entityManager.find(Game.class, game.getId());
            gameToUpdate.setDescription(game.getDescription());
            gameToUpdate.setName(game.getName());
            entityManager.merge(gameToUpdate);
            et.commit();
        }catch (Exception e){
            e.printStackTrace();
            if(et.isActive()) {et.rollback();}
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void delete(Game game) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction et = entityManager.getTransaction();

        try{
            et.begin();
            Game gameToDelete = entityManager.find(Game.class, game.getId());
            entityManager.remove(gameToDelete);
            et.commit();
        }catch (Exception e){
            e.printStackTrace();
            if(et.isActive()) {et.rollback();}
        } finally {
            entityManager.close();
        }
    }
}
