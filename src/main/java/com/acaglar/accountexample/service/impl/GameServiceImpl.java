package com.acaglar.accountexample.service.impl;

import com.acaglar.accountexample.dto.GameDto;
import com.acaglar.accountexample.models.Game;
import com.acaglar.accountexample.repository.GameRepository;
import com.acaglar.accountexample.service.GameService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public GameDto createGame(GameDto gameDto){
        if(gameDto == null && StringUtils.isBlank(gameDto.getName())){
            throw new IllegalArgumentException("Game name can not be null!");
        }
        Game newGame = gameRepository.save(new Game(gameDto));
        return new GameDto(newGame);
    }

    @Override
    public GameDto updateGame(GameDto gameDto) {
        GameDto foundDto = getById(gameDto.getId());
        foundDto.setName(gameDto.getName());

        Game gameToUpdate = new Game(foundDto);

        gameRepository.save(gameToUpdate);

        return new GameDto(gameToUpdate);
    }

    @Override
    public GameDto getById(Long id) {
        Game foundGame = gameRepository.getById(id);
        return new GameDto(foundGame);
    }
}
