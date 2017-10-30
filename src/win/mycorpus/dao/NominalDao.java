/**
 * 定义Dao层词性接口
 */
package win.mycorpus.dao;

import java.util.List;

public interface NominalDao {

	int add(String str);

	List<String> find();

}