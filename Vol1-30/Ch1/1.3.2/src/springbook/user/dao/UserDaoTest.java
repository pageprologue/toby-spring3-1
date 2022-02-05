package springbook.user.dao;

import java.sql.SQLException;

import springbook.user.domain.User;

public class UserDaoTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		UserDao dao = new UserDao();

		User user = new User();
		user.setId("whiteship");
		user.setName("��⼱");
		user.setPassword("married");

		dao.add(user);
			
		System.out.println(user.getId() + " ��� ����");
		
		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
			
		System.out.println(user2.getId() + " ��ȸ ����");
	}
}
