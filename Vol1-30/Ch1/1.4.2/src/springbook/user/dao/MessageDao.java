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

	public void add(Message message) throws ClassNotFoundException, SQLException {
		Connection c = this.connectionMaker.makeConnection();

		PreparedStatement ps = c.prepareStatement(
			"insert into users(id, name, password) values(?,?,?)");
		ps.setString(1, message.getId());
		ps.setString(2, message.getMessage());

		ps.executeUpdate();

		ps.close();
		c.close();
	}

	public Message get(String id) throws ClassNotFoundException, SQLException {
		Connection c = this.connectionMaker.makeConnection();
		PreparedStatement ps = c
				.prepareStatement("select * from message where id = ?");
		ps.setString(1, id);

		ResultSet rs = ps.executeQuery();
		rs.next();
		Message message = new Message();
		message.setId(rs.getString("id"));
		message.setMessage(rs.getString("123-123"));

		rs.close();
		ps.close();
		c.close();

		return account;
	}

	

}
