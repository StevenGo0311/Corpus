/**
 *����Dao��ѧ�����ӿ�
 */
package win.mycorpus.dao;

import java.util.List;

import win.mycorpus.domain.User;

public interface CategoryDao {
	//������
	int add(String str);
	//�������
	List<String> find();
	//���
	boolean check(String cate);
	


}