package com.tulotero.chispazo.application;

import com.tulotero.chispazo.domain.ChispazoDraw;
import com.tulotero.chispazo.domain.ChispazoDrawRepository;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
@RequiredArgsConstructor
public class ChispazoDrawFinder {

    final ChispazoDrawRepository chispazoDrawRepository;

    public Optional<ChispazoDraw> find(Long drawId){
        return chispazoDrawRepository.findAll().stream()
                .filter(draw -> draw.getDrawId() == drawId)
                .findAny();
    }
}
