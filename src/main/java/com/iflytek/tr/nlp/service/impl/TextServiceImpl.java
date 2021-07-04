package com.iflytek.tr.nlp.service.impl;

import com.iflytek.tr.nlp.common.contants.ErrorCode;
import com.iflytek.tr.nlp.common.exception.BaseException;
import com.iflytek.tr.nlp.service.TextService;
import com.iflytek.tr.nlp.word2vec.LoadDictWords;
import com.iflytek.tr.nlp.word2vec.Word2Vec;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static com.iflytek.tr.nlp.word2vec.Word2Vec.wordSimilarity;

/**
 * @ Author     ：yylan
 * @ Date       ：Created in 15:57 2019/4/12
 */
@Slf4j
@Service
public class TextServiceImpl implements TextService {

    private ConcurrentMap<String,  List<String>> dictMap = new ConcurrentHashMap<String,  List<String>>();

    /**
     * 获取词库中的关键词
     * @param trackId
     * @param text
     * @return
     */
    @Override
    public List<String> getKeywords(String trackId, String text) {
        if (StringUtils.isEmpty(trackId)){
//            log.error("tarckId : {}, trackId is null", trackId);
            throw new BaseException(ErrorCode.PARAM_ERROR.getCode(), "请求参数不正确", ErrorCode.PARAM_ERROR.isSuccess());
        }
        if (StringUtils.isEmpty(text)){
//            log.error("tarckId : {}, 行为描述为空 ", trackId);
            throw new BaseException(ErrorCode.PARAM_ERROR.getCode(), "请求参数不正确", ErrorCode.PARAM_ERROR.isSuccess());
        }

        if (StringUtils.isEmpty(trackId) || StringUtils.isEmpty(text)){
            throw new BaseException(ErrorCode.PARAM_ERROR.getCode(), "请求参数不正确", ErrorCode.PARAM_ERROR.isSuccess());
        }
        // 字典加载
        dictMap = LoadDictWords.getDictMap();

        List<String> keyList = getKeywordsList(text, dictMap);

        return keyList;
    }

    /**
     *  获取相似度
     * @param trackId
     * @param keywords1
     * @param keywords2
     * @return
     */
    @Override
    public float getSimilar(String trackId, String keywords1, String keywords2) {
        if (StringUtils.isEmpty(keywords1)){
//            log.error("tarckId : {}, 行为关键词组为空", trackId);
            throw new BaseException(ErrorCode.PARAM_ERROR.getCode(), "请求参数不正确", ErrorCode.PARAM_ERROR.isSuccess());
        }
        if (StringUtils.isEmpty(keywords2)){
//            log.error("tarckId : {}, 行为关键词组为空", trackId);
            throw new BaseException(ErrorCode.PARAM_ERROR.getCode(), "请求参数不正确", ErrorCode.PARAM_ERROR.isSuccess());
        }

        String[] wordsArray1 = keywords1.split("，");
        String[] wordsArray2 = keywords2.split("，");
        int len1=wordsArray1.length;
        int len2=wordsArray2.length;
        if (len1 == 0 || len2 == 0) {
            return 0;
        }
        float[] vector1 = new float[len1];
        float[] vector2 = new float[len2];
        for (int i = 0; i < len1; i++) {
            vector1[i] = calMaxSimilarityForArray(wordsArray1[i], wordsArray2);
        }
        for (int i = 0; i < len2; i++) {
            vector2[i] = calMaxSimilarityForArray(wordsArray2[i], wordsArray1);
        }
        float sum1 = 0;
        for (int i = 0; i < len1; i++) {
            sum1 += vector1[i];
        }
        float sum2 = 0;
        for (int i = 0; i < len2; i++) {
            sum2 += vector2[i];
        }
        float averageScore = (sum1 + sum2) / (len1 + len2);
        // 保留两位小数
        return (float)(Math.round(averageScore*100))/100;
    }

    /**
     * 计算词语与词语列表中所有词语的最大相似度 (最小返回0)averageScore=(float)(Math.round(totalScore*100))/100;
     *
     * @param centerWord
     *            词语
     * @param wordList
     *            词语列表
     * @return
     */
    private float calMaxSimilarityForArray(String centerWord, String[] wordList) {
        float max = -1;
        for (String word : wordList) {
            if (word.equals(centerWord)) {
                return 1;
            }
            float temp = wordSimilarity(centerWord, word);
            if (temp == 0)
                continue;
            if (temp > max) {
                max = temp;
            }
        }
        if (max == -1)
            return 0;
        return max;
    }
    /**
     *  通过词库的行为描述的关键词  找到匹配度最高的词条
     * @param text
     * @param dictMap
     * @return
     */
    private List<String> getKeywordsList(String text, Map<String, List<String>> dictMap){
//        log.info("行为描述 ：{}", text);
        List<String> resultKeywordsList = new ArrayList<String>();
        for (Map.Entry<String, List<String>> map: dictMap.entrySet()){
            List<String> dictList = map.getValue();
            for (String keys : dictList){
                if (text.contains(keys)){
//                    log.info("检索到对应关键词 : {}", keys);
                    resultKeywordsList.add(keys);
                }
            }
        }
        return resultKeywordsList;
    }
    /**
     *  通过词库的行为描述的关键词  找到匹配度最高的词条
     * @param text
     * @param dictMap
     * @return
     */
    private List<String> getKeywordsListTemp(String text, Map<String, List<String>> dictMap){
//        log.info("行为描述 ：{}", text);
        Map<String,Integer> weightMap = new HashMap<String, Integer>();
        List<String> resultKeywordsList = new ArrayList<String>();
        for (Map.Entry<String, List<String>> map: dictMap.entrySet()){
            int weights = 0;
            List<String> dictList = map.getValue();
            for (String keys : dictList){
                if (text.contains(keys)){
//                    log.info("检索到对应关键词 : {}", keys);
                    resultKeywordsList.add(keys);
                    weights++;
                }
            }
            weightMap.put(map.getKey(), weights);
        }

        // weightMap 按值进行排序
        weightMap = sortByValueDescending(weightMap);

        String keyOptimal = null;
        for (Map.Entry<String, Integer> entry : weightMap.entrySet()) {
            keyOptimal = entry.getKey();
            break;
        }
        // 通过最优key， 从字典中查出对应的list<String>
        List<String> firstList = new ArrayList<String>();
        if (!StringUtils.isEmpty(keyOptimal)){
            firstList = dictMap.get(keyOptimal);
        }else {
//            log.info("keyOptimal is null");
        }
        if (firstList.size() == 0){
//            log.info("没有从字典中查到数据");
        }
        return resultKeywordsList;
    }

    /**
     * Map 按值的降序排序
     * @param map
     * @param <K>
     * @param <V>
     * @return
     */
    public <K, V extends Comparable<? super V>> Map<K, V> sortByValueDescending(Map<K, V> map)
    {
        List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>()
        {
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2)
            {
                int compare = (o1.getValue()).compareTo(o2.getValue());
                return -compare;
            }
        });

        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
