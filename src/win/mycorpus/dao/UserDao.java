/**
 * 定义Dao层关于用户操作的接口
 */
package win.mycorpus.dao;

import java.util.List;

import win.mycorpus.domain.User;

public interface UserDao {
	//查找用户
	int add(User user);
	//根据用户名返回所有用户
	List<User> find(String username);
	//根据用户名和密码返回用户
	User find(String username, String password);
	//删除用户
	int delete(String username);
	//修改用户信息
	int update(String username, String newpsw);
    //根据身份查找用户
	List<User> findUser(String role);

}