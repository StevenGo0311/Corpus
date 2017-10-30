/**
 * 定义Dao层单词操作接口
 */

package win.mycorpus.dao;

import java.util.List;

import win.mycorpus.domain.Word;

public interface WordDao {

	int add(Word word);

	Word find(String wWord);

	int delete(String wWord);

	void process(String wWord);

}