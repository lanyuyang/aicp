package com.iflytek.tr.nlp.word2vec;


import com.iflytek.tr.nlp.common.base.ConstantUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Slf4j
public class LoadDictWords {
	private static final Logger logger = LoggerFactory.getLogger(LoadDictWords.class);

	private static boolean dictFlag = false; // 是否已经加载词典

	private static ConcurrentMap<String,  List<String>> dictMap = new ConcurrentHashMap<String,  List<String>>();

	public LoadDictWords() {
		if (dictFlag == false) {
			logger.info("===============  开始加载词典... ===============  ");
			long startTime = System.currentTimeMillis();
			dictMap = readTxt();
			dictFlag = true;
			long endTime = System.currentTimeMillis();
			logger.info("加载词典耗时：" + (endTime - startTime) / 1000.0 + "秒。");
		}
	}

	public static ConcurrentMap<String,  List<String>> getDictMap() {
		if (dictFlag == false) {
			return null;
		} else
			return dictMap;
	}

	/**
	 * 将词库加载到内存中
	 */
	private ConcurrentMap<String,  List<String>> readTxt(){
		String dictText = ConstantUtil.DICT_FILE_PATH ;
		ConcurrentMap<String,  List<String>> dictMap = new ConcurrentHashMap<String,  List<String>>();
		String key = null;
		List<String> keyWordList = null;
        /* 读取数据 */
		try {
//			log.info("字典路径为 ： {}", dictText);
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(dictText)),
					"utf-8"));
			String lineTxt = null;
			while ((lineTxt = br.readLine()) != null) {
				// 去除每一行的空格
				lineTxt = lineTxt.replace(" ", "");
				if (lineTxt.contains("[") && lineTxt.contains("]")){
					if (!StringUtils.isEmpty(key) && keyWordList.size() != 0){
						dictMap.put(key,keyWordList);
					}
					keyWordList = new ArrayList<String>();
					// 设置为Map的键
					key = lineTxt.replace("[","").replace("]","").trim();
				}else {
					// 循环加进键对应的List列表中
					if (!StringUtils.isEmpty(lineTxt)){
						keyWordList.add(lineTxt);
					}
				}
			}
			br.close();
		} catch (Exception e) {
			System.err.println("read errors :" + e);
		}
		return dictMap;
	}
}
