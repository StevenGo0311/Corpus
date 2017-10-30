package win.mycorpus.test;

import java.util.ArrayList;
import java.util.List;

import win.mycorpus.dao.HighFrequencyDao;
import win.mycorpus.dao.HighFrequencyDao;
import win.mycorpus.daoImpl.HighFrequencyDaoimpl;
import win.mycorpus.domain.Word;

public class FrequencyDaoTest {
	public static void main(String args[]){
//		String category="计算机类";
//		List<Word> lists=new ArrayList<>();
		HighFrequencyDao highDao=new HighFrequencyDaoimpl();
//		lists=highDao.find(category);
//		for(int i=0;i<lists.size();i++){
//			System.out.println(lists.get(i).getwMean());
//		}
		
		Word newWord=new Word();
		Word oldWord=new Word();
		newWord.setwWord("zyy");
		newWord.setwMean("陈志远");
		newWord.setwNominal("形容词");
		newWord.setwCategory("计算机类");
		highDao.update(newWord);
		
		
		
	}

}
