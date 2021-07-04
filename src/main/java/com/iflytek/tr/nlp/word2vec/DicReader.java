package com.iflytek.tr.nlp.word2vec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 文档读入工具
 *
 * @author sunjing
 */
public final class DicReader {

	private static final Logger logger = LoggerFactory.getLogger(DicReader.class);

	private DicReader() {
	}

	/**
	 * 返回BufferedReader
	 *
	 * @param name
	 *            文件名
	 * @return
	 */
	public static BufferedReader getReader(String name) {
		// InputStream in = DicReader.class.getResourceAsStream("/" + name);
		File file = new File(name);
		InputStream in = null;
		try {
			if (file.isFile() && file.exists()) { // 判断文件是否存在

				in = new FileInputStream(file);

			} else {
				logger.error("============ 找不到指定的文件:" + name);
			}

		} catch (FileNotFoundException e) {
			logger.error("============ 读取文件内容出错!");
			e.printStackTrace();
		}

		try {
			return new BufferedReader(new InputStreamReader(in, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			logger.error("编码格式不支持：" + e.getMessage());
		}
		return null;
	}

	public static Set<String> getWords(String path) {
		Set<String> words = new HashSet<String>();
		BufferedReader bf = DicReader.getReader(path);
		String line = null;
		try {
			while ((line = bf.readLine()) != null) {
				words.add(line.trim());
			}
		} catch (IOException e) {
			logger.error("IO错误：" + e.getMessage());
		} finally {
			if (null != bf) {
				try {
					bf.close();
				} catch (IOException e) {
					/* ignore */
				}
			}
		}
		return words;
	}
}
