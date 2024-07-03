package com.tulotero.chispazo.usecase;

import com.tulotero.chispazo.domain.bean.ChispazoPrizeCheck;
import com.tulotero.chispazo.domain.bean.PrizeInfo;
import com.tulotero.chispazo.domain.bean.ScrutinyPrize;
import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ChispazoBetPrizeCalculator {

    public PrizeInfo calculatePrize(ChispazoPrizeCheck prizeCheck) {
        List<Integer> successes = getSuccesses(prizeCheck);
        return new PrizeInfo(getPrize(successes.size(), prizeCheck.getDraw().getPrizes()),successes);
    }

    private List<Integer> getSuccesses(ChispazoPrizeCheck prizeCheck) {
        List<Integer> winners = new ArrayList<>();
        prizeCheck.getDraw().getWinningNumbers().forEach(winNumber -> {
            if(prizeCheck.getBet().getNumbers().stream().anyMatch(choice -> choice==winNumber)){
                winners.add(winNumber);
            }
        });
        return winners;
    }

    private double getPrize(int totalSuccesses, List<ScrutinyPrize> prizes) {
        ScrutinyPrize prize = prizes.stream().filter(scrutinyPrize ->
                scrutinyPrize.getNumbersAchieved() == totalSuccesses).findFirst().orElse(null);
        return prize==null?0D:prize.getPrize();
    }
}