package com.acaglar.accountexample.dto;

import com.acaglar.accountexample.models.Game;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameDto {
    private long id;
    private String name;
    private BigDecimal commissionRate;

    public GameDto(Game game){
        this.name = game.getName();
        this.commissionRate = game.getCommissionRate();
    }
}
