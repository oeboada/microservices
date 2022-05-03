# Deck of Cards Microservice

API that will allow a user to generate a shuffled deck of cards and draw cards 1-by-1
or skip a card.

Run com.company.SpringDeckCardsApplication as a Java Application.

#### src/main/java/com/company/controller/DeckCardsController.yaml:
This file contents an Open Api Specification 

#### /open-api-docs/deckcards-api-documentation-generated.zip
This file contents an Open Api html2 docs. These docs show how running services from Api

```
url base: http://104.198.178.179:8091

service POST generateDeckId
/deckscards/generateDeckId

service PUT nextCard
/deckscards/nextCard/{id}

service PUT skipCard
/deckscards/skipCard/{id}
```




#### src/main/resources/application.properties

```
server.port=8091

spring.application.name=deckcards-api
spring.profiles.active=prod

deckscards.max-life-time-seconds=1800
deckscards.max-capacity-counter=1000

spring.cloud.config.import-check.enabled=false
```

This Property config seconds from last pop action in one deck for add mark as expired deck.

If deck.lastUpdate - currentTime > max-life-time-seconds then deck container position is marked to be overwritten  
```
deckscards.max-life-time-seconds=1800
```


This Property size of deck container

If max-capacity-counter == DataBase.decksCards.size then it won't be possible get new deckId  
```
deckscards.max-capacity-counter=1000
```


## Model Classes 

### Suit
Suit type for a card
### CardDefinition
Constants represent each card of 52 classic deck. Specifying general number and number by suit and suit  
### Card
A card of deck 
### Deck
Group of 52 cards
### Properties
Load config definitions

## Documentation about limitations/concerns

Decks created are maintained in memory within static variable Map<String, Deck> decksCards, belonging to DataBase class.


