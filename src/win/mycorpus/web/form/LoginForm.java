package win.mycorpus.web.form;

import java.util.HashMap;
import java.util.Map;

public class LoginForm {
	private String username;
	private String password;
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
	
	public Map<String, String> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	public boolean validate(){
		boolean isOK=true;
		if(username.trim().equals("")){
			errors.put("username","账户不能有空格" );
			isOK=false;
		}
		if(password.trim().equals("")){
			errors.put("password","密码不能有空格" );
			isOK=false;
		}
		return isOK;
	}
	

}
