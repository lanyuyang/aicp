package com.iflytek.tr.nlp.controller;

import com.iflytek.tr.nlp.service.TextService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @ Author     ：yylan
 * @ Date       ：Created in 9:54 2019/4/12
 */
@Slf4j
@RestController
@RequestMapping("/tr/nlp")
public class TextController {

    @Autowired
    private TextService textService;

    @PostMapping(value = "/keyword/{trackId}")
    @ResponseBody
    public Map<String, List<String>> getKeyword(@PathVariable(name = "trackId") String trackId,
                                                @RequestParam(name = "text") String text) {
//        log.info(">>>>>[trackId:{}] 开始获取关键字，参数为:{}",trackId, text);
        Map<String, List<String>> returnMap = new HashMap<String, List<String>>(1);
        List<String> list = textService.getKeywords(trackId, text);
        returnMap.put("keywords", list);
        return returnMap;
    }
    @PostMapping(value = "/keyword/similar/{trackId}")
    @ResponseBody
    public Map<String, Float> getSimilar(@PathVariable(name = "trackId") String trackId,
                                           @RequestParam(name = "keywords1") String keywords1,
                                           @RequestParam(name = "keywords2") String keywords2){
//        log.info(">>>>>[trackId:{}] 开始获取关键字，关键字为:{}，关键字为:{}",trackId, keywords1,keywords2);
        Map<String, Float> similarMap = new HashMap<String, Float>(1);
        float score = textService.getSimilar(trackId, keywords1, keywords2);
        similarMap.put("similar",score);
        return similarMap;
    }
}
