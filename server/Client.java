package server;

public class Client {
	
	
	private static final long serialVersionUID = -8807331723807741905L;
	private String _username , _password;
	// private sessionKey;
	
	
	Client(String username ,String password){
		_username = username;
		_password = username;
	}


	public boolean compareusername(String username) {
		return _username.equals(username);
	}


	public boolean comparepassword(String password) {
		return _password.equals(password);
	}
	
}
