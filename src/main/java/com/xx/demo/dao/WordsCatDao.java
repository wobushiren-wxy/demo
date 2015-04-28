package com.xx.demo.dao;

import java.util.List;
import java.util.Map;
import com.xx.demo.model.pojo.WordCat;


// ##########################系统签名分类表########################### 
public interface WordsCatDao {

	Long countWordsCatByCondition(Map<String, Object> condition);

	public List<WordCat> getWordCatListByCondition(
			Map<String, Object> condition);
	
	public List<WordCat> getAllWordsCat();
	
	WordCat getWordCatById(Long id);

}
