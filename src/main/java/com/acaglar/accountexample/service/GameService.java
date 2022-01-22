package com.acaglar.accountexample.service;

import com.acaglar.accountexample.dto.GameDto;

public interface GameService {
    GameDto createGame(GameDto gameDto);
    GameDto updateGame(GameDto gameDto);
    GameDto getById(Long id);
}
