package com.company.transformerobjects;

import com.company.model.Card;
import com.company.model.CardDefinition;
import org.springframework.stereotype.Component;

@Component
public class CardTO {

    public Card toCard(CardDefinition cardDefinition) {
        return new Card(cardDefinition.getId(),
                null,
                cardDefinition.getNumber(),
                cardDefinition.getSuit());
    }
}
