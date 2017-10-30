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

	//校验规则
	//1.用户名：不能重复（数据库）,不能为空格
	//2.两次密码一致
	//3.手机号11位
	//4.用户身份为突通或者管理员
	//5.邮箱格式
	public boolean validata(){
		boolean isOK=true;
		if(this.username.trim().equals("")){
			isOK=false;
			errors.put("name", "用户名不能为空");	
		}
		if(this.password.trim().equals("")||!this.password.trim().equals(this.surepassword.trim())){
			isOK=false;
			errors.put("password", "两次密码不一致");
		}
		if(this.phone.trim().length()!=11){
			isOK=false;
			errors.put("telphone", "电话号码有误");
		}
		if(!(this.rule.trim().equals("普通用户")||this.rule.trim().equals("管理员"))){
			isOK=false;
			errors.put("role", "用户身份选择错误");
		}
		if(!(this.eMail.trim().matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$"))){
			isOK=false;
			errors.put("email", "邮箱格式有误");
		}
		
		return isOK;
	}
	
	

}
