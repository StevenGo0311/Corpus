/**
 * ����Dao���Ƶ�ʲ�ѯ�ӿ�
 */
package win.mycorpus.dao;

import java.util.List;

import win.mycorpus.domain.Word;

public interface HighFrequencyDao {
	//�޸ĸ�Ƶ����Ϣ
	boolean update(Word word);
	//���������Ҹ�Ƶ��
	List<Word> find(String category);

}