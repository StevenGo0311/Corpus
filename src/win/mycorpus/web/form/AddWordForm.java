package win.mycorpus.web.form;

import java.util.HashMap;
import java.util.Map;

public class AddWordForm {
	private String word;
	private String category;
	private String mean;
	private String nominal;
	private String sentence;
	private Map<String,String> errors=new HashMap<>();
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getMean() {
		return mean;
	}
	public void setMean(String mean) {
		this.mean = mean;
	}
	public String getNominal() {
		return nominal;
	}
	public void setNominal(String nominal) {
		this.nominal = nominal;
	}
	public String getSentence() {
		return sentence;
	}
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
	public boolean validate(){
		boolean isOK=true;
		if(word.trim().equals("")||category.trim().equals("")||mean.trim().equals("")
				||nominal.trim().equals("")||sentence.trim().equals("")){
			isOK=false;
			errors.put("blank","不能包含空格");
		}
		return isOK;
	}
	public Map<String, String> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
}
