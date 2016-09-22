package testJDBC.mybatis.test;

import java.util.List;

public class User {
	public int id;
	public String userName;
	public String tel;
	public List<Integer> products;

	public User(Integer id, String userName, String tel) {
		super();
		this.id = id;
		this.userName = userName;
		this.tel = tel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public List<Integer> getProducts() {
		return products;
	}

	public void setProducts(List<Integer> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		String string = "ID : ("+id+") UserName : (" + userName + ") TEL : (" + tel +") : ";
		
		String pro = "";
		
		
			pro = "####" + products.toString()+ "##";
		return string + pro;
	}
}
