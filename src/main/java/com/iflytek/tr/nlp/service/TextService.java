package com.iflytek.tr.nlp.service;

import java.util.List;

/**
 * @ Author     ：yylan
 * @ Date       ：Created in 15:56 2019/4/12
 */
public interface TextService {

    List<String> getKeywords(String trackId, String text);

    float getSimilar(String tarckId, String keywords1, String keywords2);
}
