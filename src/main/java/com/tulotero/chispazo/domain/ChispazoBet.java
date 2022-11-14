package com.tulotero.chispazo.domain;

import lombok.Value;

import java.util.List;

@Value
public class ChispazoBet {

    List<Integer> numbers;

    public ChispazoBet(List<Integer> numbers) throws IllegalArgumentException {
        //TODO: Validate numbers according ChispazoBetTest
        this.numbers = numbers;
    }
}
