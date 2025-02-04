package com.tulotero.chispazo.usecase;

import com.tulotero.chispazo.domain.bean.ChispazoDraw;
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

    public Optional<ChispazoDraw> findNext(){
        return Optional.ofNullable(chispazoDrawRepository.findNextOpen());
    }
}
