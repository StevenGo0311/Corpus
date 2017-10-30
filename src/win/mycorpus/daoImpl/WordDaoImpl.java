/**
 * 定义Dao层对单词的操作
 */
package win.mycorpus.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import win.mycorpus.dao.WordDao;
import win.mycorpus.domain.Word;
import win.mycorpus.utils.DatabaseUtil;

public class WordDaoImpl implements WordDao {
	public WordDaoImpl(){
		DatabaseUtil.loadDriver();
	}
	/* (non-Javadoc)
	 * @see win.mycorpus.daoImpl.WordDdao#add(win.mycorpus.domain.Word)
	 */
	@Override
	public int add(Word word ){
		Connection connection=DatabaseUtil.connection();
		int rows=0;
		PreparedStatement pstmt=null;
		String sql="insert into t_Word(word,nominal,mean,sentence,category) values(?,(select nominal from t_nominal where nominalName=?),?,?,(select category from t_category where categoryName=?))";
		try {
			pstmt=connection.prepareStatement(sql);
			pstmt.setString(1, word.getwWord());
			pstmt.setString(2, word.getwNominal());
			pstmt.setString(3,word.getwMean());
			pstmt.setString(4,word.getwSentence());
			pstmt.setString(5, word.getwCategory());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("添加数据异常");
		}
		DatabaseUtil.closeConnection();
		return rows;	
	}	

	
	/* (non-Javadoc)
	 * @see win.mycorpus.daoImpl.WordDdao#find(java.lang.String)
	 */
	@Override
	public Word find(String wWord){
		Connection connection=DatabaseUtil.connection();
		PreparedStatement pstmt=null;
		List<Word> words=new ArrayList<Word>();
		String sql="select word，n.nominalname，mean，sentence，c.categoryname，frequency "
				+ " from t_word w join t_nominal n on n.nominal=w.nominal "
				+ "join t_category c on c.category=w.category where word='"+wWord+"'";    //等待查询语句
		try {
			pstmt=connection.prepareStatement(sql);
			ResultSet resultSet=pstmt.executeQuery();
			while(resultSet.next()){
				Word word=new Word();
				word.setwWord(resultSet.getString("word"));
				word.setwNominal(resultSet.getString("nominalname"));
				word.setwMean(resultSet.getString("mean"));
				word.setwSentence(resultSet.getString("sentence"));
				word.setwCategory(resultSet.getString("categoryname"));
				word.setwFrequency(resultSet.getString("frequency"));
				words.add(word);
			}
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("查找数据异常");
		}
		DatabaseUtil.closeConnection();
		if(words.size()>0){
			return words.get(0);
		}
		else{
			return null;
		}
	}
	
	/* (non-Javadoc)
	 * @see win.mycorpus.daoImpl.WordDdao#delete(java.lang.String)
	 */
	@Override
	public int delete(String wWord){
		int rows=0;
		Connection connection=DatabaseUtil.connection();
		PreparedStatement pstmt=null;
		String sql="delete from t_word where uNum="+"'"+wWord+"'";                                //等待查询语句
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
	 * @see win.mycorpus.daoImpl.WordDdao#process(java.lang.String)
	 */
	@Override
	public void process(String wWord){
		Connection connection=DatabaseUtil.connection();
        try {
			CallableStatement c=connection.prepareCall("{call addfreq(?)}");
			c.setString(1, wWord);;   //将第一个参数的值设置成100
			c.execute();
		} catch (SQLException e) {
			System.out.println("调用存储过程异常");
		}
		DatabaseUtil.closeConnection();
	}

}
