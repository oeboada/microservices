package com.company.controller;

import com.company.model.Card;
import com.company.service.DeckCardsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;


@RestController
@RequestMapping("/deckscards")
public class DeckCardsController {

    private static final Logger log = LoggerFactory.getLogger(DeckCardsController.class);

    @Autowired
    private DeckCardsService deckCardsService;

    @PostMapping("/generateDeckId")
    Mono<String> generateDeckId() {
        log.info("deckscards.generateDeckId");
        try {
            return deckCardsService.generateDeckId();
        } catch (Exception e) {
            log.info("onErrorResume - " + e);
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/nextCard/{deckId}")
    Mono<Card> nextCard(
            @PathVariable @Valid String deckId,
            @RequestParam(name = "cardIndex", required = false) Integer lastCardIndex) {
        log.info("deckscards.nextCard");
        try {
            return deckCardsService.nextCard(deckId, lastCardIndex);
        } catch (Exception e) {
            log.info("onErrorResume - " + e);
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/skipNextCard/{deckId}")
    Mono<Integer> skipNextCard(
            @Valid @PathVariable String deckId,
            @RequestParam(name = "cardIndex", required = false) Integer lastCardIndex) {
        log.info("deckscards.skipNextCard");
        try {
            return deckCardsService.skipNextCard(deckId, lastCardIndex);
        } catch (Exception e) {
            log.info("onErrorResume - " + e);
            throw new RuntimeException(e);
        }
    }
}
