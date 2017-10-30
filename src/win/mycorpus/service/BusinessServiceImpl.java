package win.mycorpus.service;
import java.util.List;

import win.mycorpus.dao.CategoryDao;
import win.mycorpus.dao.HighFrequencyDao;
import win.mycorpus.dao.UserDao;
import win.mycorpus.dao.WordDao;
import win.mycorpus.daoImpl.CategoryDaoImpl;
import win.mycorpus.daoImpl.HighFrequencyDaoimpl;
import win.mycorpus.daoImpl.UserDaoImpl;
import win.mycorpus.daoImpl.WordDaoImpl;
import win.mycorpus.domain.User;
import win.mycorpus.domain.Word;
import win.mycorpus.exception.CategoryExistException;
import win.mycorpus.exception.UserExistException;
import win.mycorpus.exception.WordExistException;

public class BusinessServiceImpl {
	
	private UserDao dao=new UserDaoImpl();
	private WordDao wordDao=new WordDaoImpl();
	private CategoryDao categoryDao=new CategoryDaoImpl();
	private HighFrequencyDao highFrequencyDao=new HighFrequencyDaoimpl();
	//��web���ṩע�����
	public void register(User user) throws UserExistException{
		
		//�ж�Ҫע����û��Ƿ����
		boolean b=(dao.find(user.getuName()).size()>0);//�ж��û��Ƿ��Ѿ�����
		if(b){
			throw new UserExistException();//����Ҫע����û��Ѿ����ڣ����web���׳�һ������ʱ�쳣
		}
		else{
			dao.add(user);
		}
		
	}
	//��web���ṩ��¼����
	public User login(String username,String password){
		
		return dao.find(username, password);
	}
	//��ӵ��ʵķ������ȼ���û��Ƿ���ڣ���������׳��쳣��������ʱִ�����
	public void addWord(Word word)throws WordExistException{
		boolean b=(wordDao.find(word.getwWord())!=null);
		if(b){
			throw new WordExistException();
		}
		else{
			wordDao.add(word);
		}
		
	}
	//��ѯ����
	public Word SearchWord(String wWord){
		return wordDao.find(wWord);
	}
	//��ӷ���
	public void addCategory(String category) throws CategoryExistException{
		boolean b=categoryDao.check(category);
		if(!b){
			throw new CategoryExistException();
		}
		else{
			categoryDao.add(category);
		}
	}
	//������
	public List<Word> SearchCategory(String category){
		return highFrequencyDao.find(category);
	}
	//���ҷ���
	public List<User> SeachUser(String role){
		return dao.findUser(role);
	}
	//�޸ĸ�Ƶ��
	public boolean AlterHigh(Word word){
		return highFrequencyDao.update(word);
		
	}
	

}
