package com.iflytek.tr.nlp;

import com.iflytek.tr.nlp.word2vec.LoadDictWords;
import com.iflytek.tr.nlp.word2vec.Word2Vec;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ Author     ：yylan
 * @ Date       ：Created in 9:49 2019/4/12
 */
@Slf4j
@SpringBootApplication(scanBasePackages = "com.iflytek.tr")
public class TextServiceApplicationRunner {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(TextServiceApplicationRunner.class, args);
        // 加载模型 加载词典
//        Word2Vec.initModel();
//        LoadDictWords loadWords = new LoadDictWords();
//        log.info("nlp server started ....");

    }

}
