package com.example.demo_jarkataee.dao;

import com.example.demo_jarkataee.model.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class GameDao implements Dao<Game> {


    private static Long idSequence = 1L;

    private static List<Game> games = new ArrayList<Game>(){{
        add((new Game(idSequence++, "Counter Strike", "Jeux de Tir")));
        add((new Game(idSequence++, "Diablo", "Jeux de role")));
    }};


    @Override
    public Optional<Game> get(Long id) {
        return games.stream().filter(g -> Objects.equals(g.getId(), id)).findFirst();
    }

    @Override
    public List<Game> getAll() {
        return games;
    }

    @Override
    public void save(Game game) {
        game.setId(idSequence++);
        this.games.add(game);
    }

    @Override
    public void update(Game gamParam) {
        games
                .forEach(game -> {
                    if(Objects.equals(game.getId(), gamParam.getId())){
                         game.setName((gamParam.getName()));
                         game.setDescription(gamParam.getDescription());
                    }
        });
    }

    @Override
    public void delete(Game gameToDelete) {
        games = games.stream().filter(game -> game.getId() != gameToDelete.getId()).collect(Collectors.toList());
    }
}
