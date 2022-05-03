package com.company.service.util;

import com.company.config.DeckCardsServiceConfig;
import com.company.model.Card;
import com.company.model.CardDefinition;
import com.company.model.Deck;
import com.company.model.Properties;
import com.company.persistence.DataBase;
import com.company.transformerobjects.CardTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

@Component
public class DecksUtil {

    @Autowired
    CardTO cardTO;

    public void initConfig(DeckCardsServiceConfig deckCardsServiceConfig) {
        com.company.model.Properties properties = new Properties(deckCardsServiceConfig.getMaxLifeTimeSeconds(),
                deckCardsServiceConfig.getMaxCapacityCounter());
        DataBase.MAX_LIFE_TIME_SECONDS = properties.getMaxLifeTimeSeconds();
        DataBase.MAX_CAPACITY_COUNTER = properties.getMaxCapacityCounter();
    }

    public Deck create() {
        Deck deck = new Deck();
        Date now = new Date();

        deck.setId(getId());
        deck.setCreatedAt(now);
        deck.setLastUpdated(now);
        deck.setOverwrite(false);

        AtomicReference<Stack<Card>> arStack = new AtomicReference<>(new Stack<>());

        IntStream.rangeClosed(1, 52).forEach(idCard ->
                arStack.get().push(cardTO.toCard(CardDefinition.getInstance(idCard))));

        deck.setStack(arStack.get());

        Collections.shuffle(deck.getStack());

        return deck;
    }

    public Card popCard(String deckId) {
        Date now = new Date();
        Card card;
        Deck deck = DataBase.decksCards.get(deckId);
        if (!Objects.isNull(deck)) {
            if (deck.getStack().size() >= 1) {
                card = deck.getStack().pop();
                card.setCardIndex(deck.getStack().size());

                deck.setLastUpdated(now);
            } else {
                throw new EmptyStackException();
            }
        } else {
            throw new NoSuchElementException();
        }
        return card;
    }

    private String getId() {
        String id;
        collectorLapsed();

        long size = DataBase.decksCards.values().stream().filter(deck ->
                !deck.getOverwrite()).count();

        if (size == DataBase.MAX_CAPACITY_COUNTER)
            throw new IndexOutOfBoundsException();

        do {
            id = UUID.randomUUID().toString();
        } while (DataBase.decksCards.containsKey(id));
        return id;
    }

    private void collectorLapsed() {
        DataBase.decksCards.values().stream().filter(deck ->
                        diffFromNow(deck.getLastUpdated()) >= DataBase.MAX_LIFE_TIME_SECONDS)
                .forEach(deckLapsed ->
                        deckLapsed.setOverwrite(true));
    }

    private long diffFromNow(Date lastUpdated) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime lastUpdateDateTime = LocalDateTime.ofInstant(lastUpdated.toInstant(), ZoneId.systemDefault());

        Duration duration = Duration.between(now, lastUpdateDateTime);
        return Math.abs(duration.toSeconds());
    }
}
