/**
 * 词性
 */
package win.mycorpus.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import win.mycorpus.dao.NominalDao;
import win.mycorpus.utils.DatabaseUtil;

public class NominalDaoImpl implements NominalDao {

	public NominalDaoImpl() {
		DatabaseUtil.loadDriver();
	}
	/* (non-Javadoc)
	 * @see win.mycorpus.daoImpl.NominalDao#add(java.lang.String)
	 */
	@Override
	public int add(String str){
		int rows=0;
		PreparedStatement pstmt=null;
		Connection connection=DatabaseUtil.connection();
		String sql="insert into t_nominal values('',?)";
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
	 * @see win.mycorpus.daoImpl.NominalDao#find()
	 */
	@Override
	public List<String> find(){
		List<String> nominals=new ArrayList<>();
		PreparedStatement pstmt=null;
		Connection connection=DatabaseUtil.connection();
		String sql="select nominalname from t_nominal";
		ResultSet resultSet=null;
		try {
			pstmt=connection.prepareStatement(sql);
			resultSet=pstmt.executeQuery();
			while(resultSet.next()){
				String temp=resultSet.getString(1);
				nominals.add(temp);
			}
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("查询数据异常");
		}
		DatabaseUtil.closeConnection();
		return nominals;
	}
}
