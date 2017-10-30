/**
 * Dao层添加，查找，检查分类
 */
package win.mycorpus.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import win.mycorpus.dao.CategoryDao;
import win.mycorpus.domain.User;
import win.mycorpus.utils.DatabaseUtil;

public class CategoryDaoImpl implements CategoryDao {

	public CategoryDaoImpl() {
		DatabaseUtil.loadDriver();
	}
	/* (non-Javadoc)
	 * @see win.mycorpus.daoImpl.CateGoryDao#add(java.lang.String)
	 * 添加分类
	 */
	@Override
	public int add(String str){
		int rows=0;
		PreparedStatement pstmt=null;
		Connection connection=DatabaseUtil.connection();
		String sql="insert into t_category values('',?)";
		try {
			pstmt=connection.prepareStatement(sql);
			pstmt.setString(1, str);
			rows=pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("添加数据异常");
		}
		DatabaseUtil.closeConnection();
		return rows;
	}
	/* (non-Javadoc)
	 * @see win.mycorpus.daoImpl.CateGoryDao#find()
	 * 查找分类，返回以list的形式返回查询到的结果
	 */
	@Override
	public List<String> find(){
		List<String> categorys=new ArrayList<>();
		PreparedStatement pstmt=null;
		//建立连接
		Connection connection=DatabaseUtil.connection();
		String sql="select categoryname from t_category";
		ResultSet resultSet=null;
		try {
			pstmt=connection.prepareStatement(sql);
			resultSet=pstmt.executeQuery();
			while(resultSet.next()){
				String temp=resultSet.getString(1);
				categorys.add(temp);
			}
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("添加数据异常");
		}
		DatabaseUtil.closeConnection();
		return categorys;
	}
	/**
	 * 根据用户输入的类别检查是否存在
	 */
	@Override
	public boolean check(String cate){
		List<String> categorys=new ArrayList<>();
		PreparedStatement pstmt=null;
		Connection connection=DatabaseUtil.connection();
		String sql="select categoryname from t_category where categoryname='"+cate+"'";
		ResultSet resultSet=null;
		try {
			pstmt=connection.prepareStatement(sql);
			resultSet=pstmt.executeQuery();
			while(resultSet.next()){
				String temp=resultSet.getString(1);
				categorys.add(temp);
			}
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("添加数据异常");
		}
		DatabaseUtil.closeConnection();
		if(categorys.size()>0){
			return false;
		}
		else{
			return true;
		}
	}

}
