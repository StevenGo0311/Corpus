/**
 * ����Dao������û������Ľӿ�
 */
package win.mycorpus.dao;

import java.util.List;

import win.mycorpus.domain.User;

public interface UserDao {
	//�����û�
	int add(User user);
	//�����û������������û�
	List<User> find(String username);
	//�����û��������뷵���û�
	User find(String username, String password);
	//ɾ���û�
	int delete(String username);
	//�޸��û���Ϣ
	int update(String username, String newpsw);
    //������ݲ����û�
	List<User> findUser(String role);

}