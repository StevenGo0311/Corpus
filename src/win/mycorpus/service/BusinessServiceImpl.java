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
	//对web层提供注册服务
	public void register(User user) throws UserExistException{
		
		//判断要注册的用户是否存在
		boolean b=(dao.find(user.getuName()).size()>0);//判断用户是否已经存在
		if(b){
			throw new UserExistException();//发现要注册的用户已经存在，则给web层抛出一个编译时异常
		}
		else{
			dao.add(user);
		}
		
	}
	//对web层提供登录服务
	public User login(String username,String password){
		
		return dao.find(username, password);
	}
	//添加单词的服务，首先检查用户是否存在，如果存在抛出异常，不存在时执行添加
	public void addWord(Word word)throws WordExistException{
		boolean b=(wordDao.find(word.getwWord())!=null);
		if(b){
			throw new WordExistException();
		}
		else{
			wordDao.add(word);
		}
		
	}
	//查询单词
	public Word SearchWord(String wWord){
		return wordDao.find(wWord);
	}
	//添加分类
	public void addCategory(String category) throws CategoryExistException{
		boolean b=categoryDao.check(category);
		if(!b){
			throw new CategoryExistException();
		}
		else{
			categoryDao.add(category);
		}
	}
	//检查分类
	public List<Word> SearchCategory(String category){
		return highFrequencyDao.find(category);
	}
	//查找分类
	public List<User> SeachUser(String role){
		return dao.findUser(role);
	}
	//修改高频词
	public boolean AlterHigh(Word word){
		return highFrequencyDao.update(word);
		
	}
	

}
