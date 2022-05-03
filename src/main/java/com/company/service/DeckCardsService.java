package com.company.service;

import com.company.model.Card;
import reactor.core.publisher.Mono;

public interface DeckCardsService {
	Mono<String> generateDeckId() throws Exception;

	Mono<Card> nextCard(String deckId, Integer cardIndex) throws Exception;

	Mono<Integer> skipNextCard(String deckId, Integer cardIndex) throws Exception;
}
