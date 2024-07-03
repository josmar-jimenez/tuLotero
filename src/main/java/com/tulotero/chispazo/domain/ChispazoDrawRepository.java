package com.tulotero.chispazo.domain;

import com.tulotero.chispazo.domain.bean.ChispazoDraw;

import java.util.List;

public interface ChispazoDrawRepository {
    List<ChispazoDraw> findAll();
    ChispazoDraw findNextOpen();
}
