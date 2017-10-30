package win.mycorpus.test;

import java.util.List;

import win.mycorpus.dao.WordDao;
import win.mycorpus.daoImpl.WordDaoImpl;
import win.mycorpus.domain.Word;

public class WordDaoTest {
	public static void main(String args[]){
		Word word=new Word();
		WordDao wordDao=new WordDaoImpl();
		
		//add()
		word.setwWord("hello");
		word.setwNominal("名词");
		word.setwMean("你好");
		word.setwSentence("hello，word");
		word.setwCategory("计算机类");
		wordDao.add(word);
		
		
		//find
//		List<Word> words=wordDao.find("hello");
//		System.out.println(words.size());
//		for(int i=0;i<words.size();i++){
//			System.out.println(words.get(i).getwMean());
//		}
		
		//process
		//wordDao.process("hello");
		
	}

}
