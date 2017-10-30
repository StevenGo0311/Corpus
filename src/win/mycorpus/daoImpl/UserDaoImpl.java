package win.mycorpus.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import win.mycorpus.dao.UserDao;
import win.mycorpus.domain.User;
import win.mycorpus.utils.DatabaseUtil;

public class UserDaoImpl implements UserDao{
	//构造方法加载驱动
	public UserDaoImpl(){
		DatabaseUtil.loadDriver();
	}
	//添加用户，表示注册
	@Override
	public int add(User user){
		Connection connection=DatabaseUtil.connection();
		PreparedStatement pstmt=null;
		int rows=0;
		String name=user.getuName();
		String password=user.getuPassword();
		String role=user.getuRole();
		String email=user.getuEmail();
		String telNumber=user.getuTelNumber();
		String nickname=user.getuNickname();
		String pwbQuestion=user.getuPwbQuestion();
		String pwbAnswer=user.getuPwbAnswer();
//		System.out.println("====="+role);
//		System.out.println("====="+pwbQuestion);
		String sql="insert into t_user values('',?,?,(select urule from t_ruleman where urulename=?),?,?,?,?,?)";
		try {
			pstmt=connection.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			pstmt.setString(3, role);
			pstmt.setString(4, email);
			pstmt.setString(5, telNumber);
			pstmt.setString(6, nickname);
			pstmt.setString(7, pwbQuestion);
			pstmt.setString(8, pwbAnswer);
			//执行sql语句，向数据库添加用户
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("添加数据异常");
		}
		DatabaseUtil.closeConnection();
		return rows;	
	}	

	/* (non-Javadoc)
	 * @see win.mycorpus.daoImpl.UserDao#find(java.lang.String)
	 */
	@Override
	public List<User> find(String username){
		Connection connection=DatabaseUtil.connection();
		PreparedStatement pstmt=null;
		List<User> users=new ArrayList<User>();
		//System.out.println(username);
		String sql="select uNum,uPwd,r.uRulename,uEmail,uTelNum,uNickname,uPwdQuestion,uPwdAnswer from t_user u join t_ruleman r on u.urule=r.urule "
				+ "where uNum='"+username+"'";                                //等待查询语句
		try {
			pstmt=connection.prepareStatement(sql);
			ResultSet resultSet=pstmt.executeQuery();
			System.out.println("程序数据库部分已经执行");
			while(resultSet.next()){
				User user=new User();
				user.setuName(resultSet.getString(1));
				user.setuPassword(resultSet.getString(2));
				user.setuRole(resultSet.getString(3));
				user.setuEmail(resultSet.getString(4));
				user.setuTelNumber(resultSet.getString(5));
				user.setuNickname(resultSet.getString(6));
				user.setuPwbQuestion(resultSet.getString(7));
				user.setuPwbAnswer(resultSet.getString(8));
				users.add(user);
			}
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("查找数据异常");
		}
		DatabaseUtil.closeConnection();
		return users;
			
		
		
	}
	/* (non-Javadoc)
	 * @see win.mycorpus.daoImpl.UserDao#find(java.lang.String, java.lang.String)
	 */
	@Override
	public User find(String username,String password){
		Connection connection=DatabaseUtil.connection();
		PreparedStatement pstmt=null;
		List<User> users=new ArrayList<User>();
		String sql="select uNum,uPwd,r.uRulename,uEmail,uTelNum,uNickname,uPwdQuestion,uPwdAnswer from t_user u join t_ruleman r on u.urule=r.urule where uNum="+"'"+username+"' and uPwd="+"'"+password+"'";                                //等待查询语句
		try {
			pstmt=connection.prepareStatement(sql);
			ResultSet resultSet=pstmt.executeQuery();
			System.out.println("======查询结束");
			//读取结果集，存入list里
			while(resultSet.next()){
				User user=new User();
				user.setuName(resultSet.getString("uNum"));
				user.setuPassword(resultSet.getString("uPwd"));
				user.setuRole(resultSet.getString("uRulename"));
				user.setuEmail(resultSet.getString("uEmail"));
				user.setuTelNumber(resultSet.getString("uTelNum"));
				user.setuNickname(resultSet.getString("uNickname"));
				user.setuPwbQuestion(resultSet.getString("uPwdQuestion"));
				user.setuPwbAnswer(resultSet.getString("uPwdAnswer"));
				users.add(user);
			}
			
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("查找数据异常");
		}
		DatabaseUtil.closeConnection();
		if(users.size()>0){
			return users.get(0);
		}
		else{
			return null;
		}
			
		
		
	}

	/* (non-Javadoc)
	 * @see win.mycorpus.daoImpl.UserDao#delete(java.lang.String)
	 * 根据用户名删除用户，作为结构，功能扩展
	 */
	@Override
	public int delete(String username){
		int rows=0;
		Connection connection=DatabaseUtil.connection();
		PreparedStatement pstmt=null;
		String sql="delete from t_user where uNum="+"'"+username+"'";                                //等待查询语句
		try {
			pstmt=connection.prepareStatement(sql);
			rows=pstmt.executeUpdate();
			
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("删除数据异常");
		}
		DatabaseUtil.closeConnection();
		return rows;
	}

	/* (non-Javadoc)
	 * @see win.mycorpus.daoImpl.UserDao#update(java.lang.String, java.lang.String)
	 * 修改用户信息，功能扩展
	 */
	@Override
	public int update(String username,String newpsw){
		int rows=0;
		Connection connection=DatabaseUtil.connection();
		PreparedStatement pstmt=null;
		String sql="update t_user set uPwd="+newpsw+"where uNum="+username;                                //等待查询语句
		try {
			pstmt=connection.prepareStatement(sql);
			rows=pstmt.executeUpdate();
			
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("修改数据异常");
		}
		DatabaseUtil.closeConnection();
		return rows;
	}
	
	@Override
	/**
	 * 以身份为依据查询用户
	 */
	public List<User> findUser(String role){
		Connection connection=DatabaseUtil.connection();
		PreparedStatement pstmt=null;
		List<User> users=new ArrayList<User>();
		String sql=" select unum,upwd,r.urulename,uemail,utelnum,unickname,upwdquestion,upwdanswer from t_user u join t_ruleman r on r.urule=u.urule where u.urule=(select urule from t_ruleman where urulename='"+role+"')";                                //等待查询语句
		try {
			pstmt=connection.prepareStatement(sql);
			ResultSet resultSet=pstmt.executeQuery();
			while(resultSet.next()){
				User user=new User();
				user.setuName(resultSet.getString("uNum"));
				user.setuPassword(resultSet.getString("uPwd"));
				user.setuRole(resultSet.getString("uRulename"));
				user.setuEmail(resultSet.getString("uEmail"));
				user.setuTelNumber(resultSet.getString("uTelNum"));
				user.setuNickname(resultSet.getString("uNickname"));
				user.setuPwbQuestion(resultSet.getString("uPwdQuestion"));
				user.setuPwbAnswer(resultSet.getString("uPwdAnswer"));
				users.add(user);
			}
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("查找数据异常");
		}
		DatabaseUtil.closeConnection();
		return users;
	}

}
