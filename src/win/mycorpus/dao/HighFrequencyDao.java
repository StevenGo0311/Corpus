/**
 * 定义Dao层高频词查询接口
 */
package win.mycorpus.dao;

import java.util.List;

import win.mycorpus.domain.Word;

public interface HighFrequencyDao {
	//修改高频词信息
	boolean update(Word word);
	//根据类别查找高频词
	List<Word> find(String category);

}