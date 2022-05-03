package com.company.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Card {

    private Integer id;

    private Integer cardIndex;

    private Integer number;

    private Suit suit;
}
