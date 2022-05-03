package com.company.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Stack;

@Getter
@Setter
public class Deck {

    private String id;

    private Stack<Card> stack;

    private Date createdAt;

    private Date lastUpdated;

    private Boolean overwrite;
}
