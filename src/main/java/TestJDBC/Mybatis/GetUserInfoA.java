package TestJDBC.Mybatis;

import org.apache.ibatis.annotations.Select;

import TestJDBC.Bean.User;

public interface GetUserInfoA {

	@Select("select Id,username,password,account from user where Id = #{id}")
	public User getUser(int id);
}
