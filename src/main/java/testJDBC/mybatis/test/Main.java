package testJDBC.mybatis.test;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream inputStream = Main.class.getClassLoader()
				.getResourceAsStream("testJDBC/mybatis/test/MybatisConf.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		try {
			Op op = sqlSession.getMapper(Op.class);
			Product product = op.getProduct(2);
			System.out.println(product);
			User user = op.getUser(2);
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

}
