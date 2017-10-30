package win.mycorpus.web.form;

import java.util.HashMap;
import java.util.Map;

public class SigninForm {
	private String username;
	private String password;
	private String surepassword;
	
	private String rule;
	private String eMail;
	private String phone;
	private String question;
	private String answer;
	private String nickname;
	Map<String,String> errors=new HashMap<>();
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSurepassword() {
		return surepassword;
	}

	public void setSurepassword(String surepassword) {
		this.surepassword = surepassword;
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

	//У�����
	//1.�û����������ظ������ݿ⣩,����Ϊ�ո�
	//2.��������һ��
	//3.�ֻ���11λ
	//4.�û����Ϊͻͨ���߹���Ա
	//5.�����ʽ
	public boolean validata(){
		boolean isOK=true;
		if(this.username.trim().equals("")){
			isOK=false;
			errors.put("name", "�û�������Ϊ��");	
		}
		if(this.password.trim().equals("")||!this.password.trim().equals(this.surepassword.trim())){
			isOK=false;
			errors.put("password", "�������벻һ��");
		}
		if(this.phone.trim().length()!=11){
			isOK=false;
			errors.put("telphone", "�绰��������");
		}
		if(!(this.rule.trim().equals("��ͨ�û�")||this.rule.trim().equals("����Ա"))){
			isOK=false;
			errors.put("role", "�û����ѡ�����");
		}
		if(!(this.eMail.trim().matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$"))){
			isOK=false;
			errors.put("email", "�����ʽ����");
		}
		
		return isOK;
	}
	
	

}
