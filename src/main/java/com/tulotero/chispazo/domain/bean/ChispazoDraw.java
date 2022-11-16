package com.tulotero.chispazo.domain.bean;


import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

@Value
public class ChispazoDraw {

    long drawId;
    LocalDateTime date;
    List<Integer> winningNumbers;
    List<ScrutinyPrize> prizes;

    private ChispazoDraw(
            Long drawId,
            LocalDateTime date,
            List<Integer> winningNumbers,
            List<ScrutinyPrize> prizes
    ){
        this.drawId = drawId;
        this.date = date;
        this.winningNumbers = winningNumbers;
        this.prizes = prizes;
    }

    public static ChispazoDraw finished(
            Long drawId,
            LocalDateTime date,
            List<Integer> winningNumbers,
            List<ScrutinyPrize> prizes
    ){
        return new ChispazoDraw(drawId, date, winningNumbers, prizes);
    }

    public static ChispazoDraw opened(
            Long drawId,
            LocalDateTime date
    ){
        return new ChispazoDraw(drawId, date, null, null);
    }

    public boolean isFinished(){
        return winningNumbers!=null;
    }

    public boolean isOpened(){
        return date.isAfter(LocalDateTime.now());
    }

}
