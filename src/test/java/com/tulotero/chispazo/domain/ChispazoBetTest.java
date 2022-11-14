package com.tulotero.chispazo.domain;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ChispazoBetTest {

    @Test
    void testShouldCreateOkIfBetWith5Numbers() {
        new ChispazoBet(asList(1,2,3,4,28));
    }

    @Test
    void testShouldThrowExceptionIf4Numbers(){
        assertThrows(IllegalArgumentException.class, () -> new ChispazoBet(asList(1, 2, 3, 4)));
    }

    @Test
    void testShouldThrowExceptionIf6Numbers(){
        assertThrows(IllegalArgumentException.class, () -> new ChispazoBet(asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void testShouldThrowExceptionIfNumberIsRepeated(){
        assertThrows(IllegalArgumentException.class, () -> new ChispazoBet(asList(1, 2, 3, 4, 4)));
    }

    @Test
    void testShouldThrowExceptionIfNumberIsBiggerThan28(){
        assertThrows(IllegalArgumentException.class, () -> new ChispazoBet(asList(1, 2, 3, 4, 29)));
    }

    @Test
    void testShouldThrowExceptionIfNumberIsLessThan1(){
        assertThrows(IllegalArgumentException.class, () -> new ChispazoBet(asList(0, 2, 3, 4, 28)));
    }

    @Test
    void testShouldOrderNumbersEven() {
        ChispazoBet chispazoBet = new ChispazoBet(asList(5, 2, 4, 3, 1));

        assertThat(chispazoBet.getNumbers(), is(asList(1,2,3,4,5)));
    }
}