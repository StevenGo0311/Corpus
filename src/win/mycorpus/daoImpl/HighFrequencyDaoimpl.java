/**
 * ��Ƶ�ʹ���
 */
package win.mycorpus.daoImpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import win.mycorpus.dao.HighFrequencyDao;
import win.mycorpus.domain.Word;
import win.mycorpus.utils.DatabaseUtil;

public class HighFrequencyDaoimpl implements HighFrequencyDao {

	public HighFrequencyDaoimpl() {
		DatabaseUtil.loadDriver();
	}
	/* (non-Javadoc)
	 * @see win.mycorpus.daoImpl.HighFrequency#update(win.mycorpus.domain.Word, win.mycorpus.domain.Word)
	 *�޸ĸ�Ƶ���������
	 */
	@Override
	public boolean update(Word word){
		Connection connection=DatabaseUtil.connection();
		PreparedStatement pstmt=null;
		String sql="update t_Word set nominal=(select nominal from t_nominal where nominalname=?),mean=?,category=(select category from t_category where categoryname=?) where word=? ";    //�ȴ���ѯ���
		System.out.println(word.getwWord());
		System.out.println(word.getwNominal());
		System.out.println(word.getwMean());
		System.out.println(word.getwCategory());
		try {
			pstmt=connection.prepareStatement(sql);

			pstmt.setString(1,word.getwNominal());
			pstmt.setString(2,word.getwMean());
			pstmt.setString(3, word.getwCategory());
			pstmt.setString(4, word.getwWord());
			int count=pstmt.executeUpdate();
			System.out.println(count);
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("���������쳣");
			return false;
		}
		DatabaseUtil.closeConnection();
		return true;
		
	}
	/* (non-Javadoc)
	 * @see win.mycorpus.daoImpl.HighFrequency#find(java.lang.String)
	 * ���ݷ�����ҵ��ʣ�����list����
	 */
	@Override
	public List<Word> find(String category){
		Connection connection=DatabaseUtil.connection();
		PreparedStatement pstmt=null;
		List<Word> words=new ArrayList<Word>();
		String sql="select word,n.nominalname,mean,sentence,c.categoryname,frequency from t_word w "
				+ "join t_nominal n on n.nominal=w.nominal "
				+ "join t_category c on c.category=w.category where w.category=(select category from t_category where categoryname='"+category+"') order by frequency desc";    //�ȴ���ѯ���
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
				System.out.println("�Ѳ�Ѷ");
			}
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("���������쳣");
		}
		DatabaseUtil.closeConnection();
		return words;
		
	}
	


}
