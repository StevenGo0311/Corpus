/**
 * �����Ƶ��Dao��ӿ�
 */
package win.mycorpus.dao;

import java.util.List;

import win.mycorpus.domain.Word;

public interface HighFrequency {

	boolean update(Word newWord, Word oldWord);

	List<Word> find(String category);

}