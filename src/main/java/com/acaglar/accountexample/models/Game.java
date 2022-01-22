package com.acaglar.accountexample.models;

import com.acaglar.accountexample.dto.GameDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Games", indexes = @Index(columnList = "user, accountType"))
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private BigDecimal commissionRate;


    public Game(GameDto gameDto){
        this.name = gameDto.getName();
        this.commissionRate = gameDto.getCommissionRate();
    }
}
