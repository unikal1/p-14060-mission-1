package com.quoteBoard.dao;

import com.quoteBoard.entity.Quote;

import java.util.*;

/**
 * QuoteRepository 구현체
 * 로컬 메모리를 통해 데이터를 저장 및 관리한다.
 */
public class QuoteRepositoryImpl implements QuoteRepository {

    private final Map<Long, Quote> quoteDB = new HashMap<>();
    private Long cnt = 1L;

    @Override
    public Quote create(Quote quote) {
        quote.setId(cnt);
        quoteDB.put(cnt, quote);
        cnt++;

        return quote;
    }

    @Override
    public List<Quote> findAll() {
        return quoteDB.values().stream().toList();
    }

    @Override
    public Optional<Quote> find(Long id) {
        Quote quote = quoteDB.get(id);
        if(quote == null) return Optional.empty();
        return Optional.of(quote);
    }

    @Override
    public void delete(Long id) {
        Quote quote = quoteDB.remove(id);
        if(quote == null) throw new IllegalArgumentException();
    }

    @Override
    public void update(Long id, String word, String writer) {
        Quote quote = quoteDB.get(id);
        if(quote == null) throw new IllegalArgumentException();
        quote.update(word, writer);
    }
}
