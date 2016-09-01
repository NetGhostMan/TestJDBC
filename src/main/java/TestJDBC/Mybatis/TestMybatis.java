package TestJDBC.Mybatis;

import java.io.InputStream;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import TestJDBC.Bean.User;

public class TestMybatis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 声明配置未见的目录属性

		// 加载应用配置文件
		InputStream inputStream = TestMybatis.class.getClassLoader().getResourceAsStream("TestJDBC/Mybatis/conf.xml");
		// 创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 获取Session
		Configuration configuration = sqlSessionFactory.getConfiguration();
		configuration.addMapper(GetUserInfoA.class); 
		SqlSession sqlSession = sqlSessionFactory.openSession();

		GetUserInfoA getUserInfoA = sqlSession.getMapper(GetUserInfoA.class);
		User user = getUserInfoA.getUser(10); 
		System.out.println(user.getId() + " " + user.getUsername() + " " + user.getAccount());
		sqlSession.close();
	}

}
