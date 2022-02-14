package springbook.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import springbook.user.domain.User; 

public class MessageDao {
	private ConnectionMaker connectionMaker;
	
	public MessageDao(ConnectionMaker simpleConnectionMaker) {
		this.connectionMaker = simpleConnectionMaker;
	}

	public void add(Account account) throws ClassNotFoundException, SQLException {
		Connection c = this.connectionMaker.makeConnection();

		PreparedStatement ps = c.prepareStatement(
			"insert into users(id, name, password) values(?,?,?)");
		ps.setString(1, account.getId());
		ps.setString(2, account.getAccount());
		ps.setString(3, account.getPassword());

		ps.executeUpdate();

		ps.close();
		c.close();
	}

	public Account get(String id) throws ClassNotFoundException, SQLException {
		Connection c = this.connectionMaker.makeConnection();
		PreparedStatement ps = c
				.prepareStatement("select * from account where id = ?");
		ps.setString(1, id);

		ResultSet rs = ps.executeQuery();
		rs.next();
		Account account = new Account();
		account.setId(rs.getString("id"));
		account.setAccount(rs.getString("123-123"));
		account.setPassword(rs.getString("password"));

		rs.close();
		ps.close();
		c.close();

		return account;
	}

	

}
