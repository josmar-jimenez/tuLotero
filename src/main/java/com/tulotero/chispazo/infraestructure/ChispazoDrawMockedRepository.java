package com.tulotero.chispazo.infraestructure;

import com.tulotero.chispazo.domain.bean.ChispazoDraw;
import com.tulotero.chispazo.domain.bean.ScrutinyPrize;
import com.tulotero.chispazo.domain.ChispazoDrawRepository;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;

@ApplicationScoped
public class ChispazoDrawMockedRepository implements ChispazoDrawRepository {

    /**
     * Mocked draws for this exercise
     */
    private static final List<ChispazoDraw> DRAWS = asList(
            ChispazoDraw.finished(
                    1L,
                    LocalDateTime.now().minusDays(2),
                    asList(5, 10, 15, 20, 25),
                    asList(
                            new ScrutinyPrize(5, 1000000D),
                            new ScrutinyPrize(4, 100000D),
                            new ScrutinyPrize(3, 1000D),
                            new ScrutinyPrize(2, 10D),
                            new ScrutinyPrize(1, 1D)
                    )
            ),
            ChispazoDraw.finished(
                    2L,
                    LocalDateTime.now().minusDays(1),
                    asList(5, 10, 15, 20, 25),
                    asList(
                            new ScrutinyPrize(5, 1000000D),
                            new ScrutinyPrize(4, 100000D),
                            new ScrutinyPrize(3, 1000D),
                            new ScrutinyPrize(2, 10D),
                            new ScrutinyPrize(1, 1D)
                    )
            ),
            ChispazoDraw.opened(3L, LocalDateTime.now().plusDays(1)),
            ChispazoDraw.opened(4L, LocalDateTime.now().plusDays(2)),
            ChispazoDraw.opened(5L, LocalDateTime.now().plusDays(3))
    );

    public List<ChispazoDraw> findAll() {
        return DRAWS;
    }
}
