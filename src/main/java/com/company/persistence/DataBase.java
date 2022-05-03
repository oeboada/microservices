package com.company.persistence;

import com.company.config.DeckCardsServiceConfig;
import com.company.model.Deck;
import com.company.model.Properties;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class DataBase {
    public static Map<String, Deck> decksCards;
    public static long MAX_LIFE_TIME_SECONDS;
    public static long MAX_CAPACITY_COUNTER;


    static {
        decksCards = new HashMap<>();
    }
}

