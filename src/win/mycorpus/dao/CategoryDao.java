/**
 *定义Dao层学科类别接口
 */
package win.mycorpus.dao;

import java.util.List;

import win.mycorpus.domain.User;

public interface CategoryDao {
	//添加类别
	int add(String str);
	//查找类别
	List<String> find();
	//检查
	boolean check(String cate);
	


}