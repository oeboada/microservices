package com.company.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@Getter
@Setter
@ToString
@ConfigurationProperties(prefix = "deckscards")
public class DeckCardsServiceConfig {

    private Long maxLifeTimeSeconds;
    private Long maxCapacityCounter;
}
