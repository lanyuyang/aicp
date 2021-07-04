package com.iflytek.tr.nlp.common.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConstantUtil {
	//public static String CONFIG_PATH = "E:\\workspace\\iflytek\\iflytek_text_recognition\\src\\main\\resources\\aiconfig.properties";
	public static String CONFIG_PATH = "/iflytek/sgy/config/aicp/tr/config.properties";
	public static final String SEPERATOR_LINE = System.lineSeparator();
	public static final String SEPERATOR_LINE_r = "\r";
	public static final String SEPERATOR_LINE_n = "\n";
	public static final String SEPERATOR_LINE_rn = "\r\n";
	public static String WORD2VEC_MODEL_PATH; // word2vec模型地址

	public static String DICT_FILE_PATH; // 字典文件路径
	public static int KEYWORD_NUM; // 关键词提取个数

	static {
		try {
			// InputStream configInputStream =
			// ConstantUtil.class.getClassLoader().getResourceAsStream("config/iexconfig.properties");

			InputStream configInputStream = new FileInputStream(new File(CONFIG_PATH));
			Properties p = new Properties();
			p.load(configInputStream);

			WORD2VEC_MODEL_PATH = p.getProperty("word2vec_model_path");
			DICT_FILE_PATH = p.getProperty("dict_file_path");

		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
