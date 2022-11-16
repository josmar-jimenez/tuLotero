package com.tulotero.chispazo.usecase;

import com.tulotero.chispazo.domain.bean.ChispazoDraw;
import com.tulotero.chispazo.domain.ChispazoDrawRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.LocalDateTime;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doReturn;
import static org.mockito.MockitoAnnotations.openMocks;

class ChispazoDrawFinderTest {

    @InjectMocks
    ChispazoDrawFinder chispazoDrawFinder;
    @Mock
    ChispazoDrawRepository repository;

    @BeforeEach
    public void setUp() {
        openMocks(this);
    }

    @Test
    public void find_whenIdExists_shouldReturnOptionalOfDraw() {
        ChispazoDraw draw1 = givenDraw(1L);
        ChispazoDraw draw2 = givenDraw(2L);
        doReturn(asList(draw1, draw2)).when(repository).findAll();

        Optional<ChispazoDraw> drawOpt = chispazoDrawFinder.find(draw1.getDrawId());

        assertThat(drawOpt.isPresent(), is(true));
        assertThat(drawOpt.get().getDrawId(), is(draw1.getDrawId()));
    }

    @Test
    public void find_whenIdNotExists_shouldReturnOptinalEmpty() {
        ChispazoDraw draw1 = givenDraw(1L);
        ChispazoDraw draw2 = givenDraw(2L);
        doReturn(asList(draw1, draw2)).when(repository).findAll();

        Optional<ChispazoDraw> drawOpt = chispazoDrawFinder.find(10L);

        assertThat(drawOpt.isPresent(), is(false));
    }

    private ChispazoDraw givenDraw(Long drawId) {
        return ChispazoDraw.finished(drawId, LocalDateTime.now().minusDays(1), asList(5, 10, 15, 20, 25), null);
    }
}