/**
 * �û����ݿ����
 */
package win.mycorpus.test;

import java.util.List;

import win.mycorpus.dao.UserDao;
import win.mycorpus.daoImpl.UserDaoImpl;
import win.mycorpus.domain.User;

public class DaoTest {
	public static void main(String args[]){
		UserDao userDao=new UserDaoImpl();
		User user=new User();
		//���
//		user.setuName("Steven");
//		user.setuPassword("1234");
//		user.setuRole("����Ա");
//		user.setuEmail("143574903@qq.com");
//		user.setuTelNumber("6066110");
//		user.setuNickname("StevenGOGOGO");
//		user.setuPwbQuestion("2");
//		user.setuPwbAnswer("2423");
//		userDao.add(user);
		
		//����
//		List<User> users=userDao.find("StevenGo");
//		System.out.println(users.size());
//		for(int i=0;i<users.size();i++){
//			System.out.println(users.get(i).getuRole());
//		}
		
		//��¼��֤
//		User user2=userDao.find("StevenGo", "12345678");
//		System.out.println(user2.getuRole());
	
		List<User> users=userDao.findUser("��ͨ�û�");
		System.out.println(users.size());
		for(int i=0;i<users.size();i++){
			System.out.println(users.get(i).getuName());
		}
		
		
	}
	

}
