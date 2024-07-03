package com.tulotero.chispazo.domain.bean;

import lombok.Builder;
import lombok.Value;

import java.util.Collections;
import java.util.List;

@Value
public class PrizeInfo {
    double prize;
    List<Integer> numbersAchieved;

    public static PrizeInfo empty() {
        return new PrizeInfo(0, Collections.emptyList());
    }
}
