package com.company.service.impl;

import com.company.config.DeckCardsServiceConfig;
import com.company.model.Card;
import com.company.model.Deck;
import com.company.model.Properties;
import com.company.persistence.DataBase;
import com.company.service.DeckCardsService;
import com.company.service.util.DecksUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Base64;
import java.util.EmptyStackException;
import java.util.Objects;
import java.util.Optional;

@Service
public class DeckCardsServiceImpl implements DeckCardsService {

    @Autowired
    DecksUtil decksUtil;

    @Autowired
    DeckCardsServiceConfig deckCardsServiceConfig;

    @Override
    public Mono<String> generateDeckId() throws Exception {
        try {
            decksUtil.initConfig(deckCardsServiceConfig);
            Deck deck = decksUtil.create();
            Optional<Deck> deckToReplace = DataBase.decksCards.values().stream()
                            .filter(Deck::getOverwrite).findFirst();
            if (deckToReplace.isPresent()) {
                DataBase.decksCards.put(deckToReplace.get().getId(), deck);
            } else {
                DataBase.decksCards.put(deck.getId(), deck);
            }

            return Mono.just(deck.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Mono<Card> nextCard(String deckId, Integer cardIndex) throws Exception {
        try {
            decksUtil.initConfig(deckCardsServiceConfig);
            if (!Objects.isNull(cardIndex) && cardIndex.equals(0))
                throw new EmptyStackException();

            return Mono.just(decksUtil.popCard(deckId));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Mono<Integer> skipNextCard(String deckId, Integer cardIndex) throws Exception {
        try {
            int returnCardIndex = -1;
            decksUtil.initConfig(deckCardsServiceConfig);

            if (Objects.isNull(cardIndex) || cardIndex.compareTo(0) > 0) {
                Card card = decksUtil.popCard(deckId);
                returnCardIndex = card.getCardIndex() - 1;
            }

            return Mono.just(returnCardIndex);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
