package com.iflytek.tr.nlp.word2vec;

import com.iflytek.tr.nlp.common.base.ConstantUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;

public class Word2Vec {
    private static final Logger logger = LoggerFactory.getLogger(Word2Vec.class);

    private static LoadWord2VecModel word2vecModel = new LoadWord2VecModel();
    private static boolean loadWord2VecModel = false; // 是否已经加载模型

    public static void initModel() {
        if (loadWord2VecModel == false) {
            long startTime = Calendar.getInstance().getTimeInMillis();
            try {
                word2vecModel.loadGoogleModel(ConstantUtil.WORD2VEC_MODEL_PATH);
                loadWord2VecModel = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
            long endTime = Calendar.getInstance().getTimeInMillis();
            logger.info("加载 Word2Vec Google 模型耗时" + (endTime - startTime) / 1000.0 + "秒。");
        }
    }

    /**
     * 获得词向量
     *
     * @param word
     * @return
     */
    public static float[] getWordVector(String word) {
        if (loadWord2VecModel == false) {
            return null;
        }
        return word2vecModel.getWordVector(word);
    }

    /**
     * 计算向量内积
     *
     * @param vec1
     * @param vec2
     * @return
     */
    private static float calDist(float[] vec1, float[] vec2) {
        float dist = 0;
        for (int i = 0; i < vec1.length; i++) {
            dist += vec1[i] * vec2[i];
        }
        return dist;
    }

    /**
     * 计算词相似度
     *
     * @param word1
     * @param word2
     * @return
     */
    public static float wordSimilarity(String word1, String word2) {
        if (loadWord2VecModel == false) {
            return 0;
        }
        float[] word1Vec = getWordVector(word1);
        float[] word2Vec = getWordVector(word2);
        if (word1Vec == null || word2Vec == null) {
            return 0;
        }
        return calDist(word1Vec, word2Vec);
    }


    /**
     * 获取相似词语
     *
     * @param word
     * @param maxReturnNum
     * @return
     */
    public Set<WordEntry> getSimilarWords(String word, int maxReturnNum) {
        if (loadWord2VecModel == false)
            return null;
        float[] center = getWordVector(word);
        if (center == null) {
            return Collections.emptySet();
        }
        int resultSize = word2vecModel.getWords() < maxReturnNum ? word2vecModel.getWords()
                : maxReturnNum;
        TreeSet<WordEntry> result = new TreeSet<WordEntry>();
        double min = Double.MIN_VALUE;
        for (Map.Entry<String, float[]> entry : word2vecModel.getWordMap().entrySet()) {
            float[] vector = entry.getValue();
            float dist = calDist(center, vector);
            if (result.size() <= resultSize) {
                result.add(new WordEntry(entry.getKey(), dist));
                min = result.last().score;
            } else {
                if (dist > min) {
                    result.add(new WordEntry(entry.getKey(), dist));
                    result.pollLast();
                    min = result.last().score;
                }
            }
        }
        result.pollFirst();
        return result;
    }
}
