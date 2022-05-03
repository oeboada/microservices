package com.company.model;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum CardDefinition {
    ONECLUBS(1, 1, Suit.CLUBS),
    TWOCLUBS(2, 2, Suit.CLUBS),
    THREECLUBS(3, 3, Suit.CLUBS),
    FOURCLUBS(4, 4, Suit.CLUBS),
    FIVECLUBS(5, 5, Suit.CLUBS),
    SIXCLUBS(6, 6, Suit.CLUBS),
    SEVENCLUBS(7, 7, Suit.CLUBS),
    EIGHTCLUBS(8, 8, Suit.CLUBS),
    NINECLUBS(9, 9, Suit.CLUBS),
    TENCLUBS(10, 10, Suit.CLUBS),
    ELEVENCLUBS(11, 11, Suit.CLUBS),
    TWELVECLUBS(12, 12, Suit.CLUBS),
    THIRDTEENCLUBS(13, 13, Suit.CLUBS),
    ONEDIAMONDS(14, 1, Suit.DIAMONDS),
    TWODIAMONDS(15, 2, Suit.DIAMONDS),
    THREEDIAMONDS(16, 3, Suit.DIAMONDS),
    FOURDIAMONDS(17, 4, Suit.DIAMONDS),
    FIVEDIAMONDS(18, 5, Suit.DIAMONDS),
    SIXDIAMONDS(19, 6, Suit.DIAMONDS),
    SEVENDIAMONDS(20, 7, Suit.DIAMONDS),
    EIGHTDIAMONDS(21, 8, Suit.DIAMONDS),
    NINEDIAMONDS(22, 9, Suit.DIAMONDS),
    TENDIAMONDS(23, 10, Suit.DIAMONDS),
    ELEVENDIAMONDS(24, 11, Suit.DIAMONDS),
    TWELVEDIAMONDS(25, 12, Suit.DIAMONDS),
    THIRDTEENDIAMONDS(26, 13, Suit.DIAMONDS),
    ONEHEARTS(27, 1, Suit.HEARTS),
    TWOHEARTS(28, 2, Suit.HEARTS),
    THREEHEARTS(29, 3, Suit.HEARTS),
    FOURHEARTS(30, 4, Suit.HEARTS),
    FIVEHEARTS(31, 5, Suit.HEARTS),
    SIXHEARTS(32, 6, Suit.HEARTS),
    SEVENHEARTS(33, 7, Suit.HEARTS),
    EIGHTHEARTS(34, 8, Suit.HEARTS),
    NINEHEARTS(35, 9, Suit.HEARTS),
    TENHEARTS(36, 10, Suit.HEARTS),
    ELEVENHEARTS(37, 11, Suit.HEARTS),
    TWELVEHEARTS(38, 12, Suit.HEARTS),
    THIRDTEENHEARTS(39, 13, Suit.HEARTS),
    ONESPADES(40, 1, Suit.SPADES),
    TWOSPADES(41, 2, Suit.SPADES),
    THREESPADES(42, 3, Suit.SPADES),
    FOURSPADES(43, 4, Suit.SPADES),
    FIVESPADES(44, 5, Suit.SPADES),
    SIXSPADES(45, 6, Suit.SPADES),
    SEVENSPADES(46, 7, Suit.SPADES),
    EIGHTSPADES(47, 8, Suit.SPADES),
    NINESPADES(48, 9, Suit.SPADES),
    TENSPADES(49, 10, Suit.SPADES),
    ELEVENSPADES(50, 11, Suit.SPADES),
    TWELVESPADES(51, 12, Suit.SPADES),
    THIRDTEENSPADES(52, 13, Suit.SPADES);

    private final Integer id;
    private final Integer number;
    private final Suit suit;

    CardDefinition(Integer id, Integer number, Suit suit) {
        this.id = id;
        this.number = number;
        this.suit = suit;
    }

    public static CardDefinition getInstance(Integer id) {
        return Arrays.stream(values()).filter(cardDefinition -> cardDefinition.getId().equals(id)).findFirst()
                .orElseThrow();
    }
}
