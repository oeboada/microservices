package com.company.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Properties {

    private Long maxLifeTimeSeconds;
    private Long maxCapacityCounter;

    public Properties(Long maxLifeTimeSeconds, Long maxCapacityCounter) {
        this.maxLifeTimeSeconds = maxLifeTimeSeconds;
        this.maxCapacityCounter = maxCapacityCounter;
    }
}
