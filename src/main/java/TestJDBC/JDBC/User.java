package TestJDBC.JDBC;

public class User {

	private String username;
	private String password;
	private int account;
	
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

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}
	
	public User(String username, String password, int account) {
		super();
		this.username = username;
		this.password = password;
		this.account = account;
	}
	
}
