package com.tulotero.chispazo.domain.bean;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ChispazoBetTest {

    @Test
    void newChispazoBet_whenCorrectNumbers_shouldDontThrowException() {
        new ChispazoBet(asList(1, 2, 3, 4, 28));
    }

    @Test
    void newChispazoBet_whenFourNumber_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new ChispazoBet(asList(1, 2, 3, 4)));
    }

    @Test
    void newChispazoBet_whenSixNumber_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new ChispazoBet(asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void newChispazoBet_whenRepeatedNumber_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new ChispazoBet(asList(1, 2, 3, 4, 4)));
    }

    @Test
    void newChispazoBet_whenNumberBiggerThan28_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new ChispazoBet(asList(1, 2, 3, 4, 29)));
    }

    @Test
    void newChispazoBet_whenNumberLowerThan1_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new ChispazoBet(asList(0, 2, 3, 4, 28)));
    }

    @Test
    void newChispazoBet_whenCorrectNumbers_shouldOrderNumbers() {
        ChispazoBet chispazoBet = new ChispazoBet(asList(5, 2, 4, 3, 1));

        assertThat(chispazoBet.getNumbers(), is(asList(1,2,3,4,5)));
    }
}