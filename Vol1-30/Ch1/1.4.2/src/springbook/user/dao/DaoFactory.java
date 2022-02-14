package springbook.user.dao;

public class DaoFactory {

	public UserDao userDao() {
		UserDao userDao = new UserDao(getConnectionMaker());
		return userDao;
	}

	public AccountDao accountDao() {
		AccountDao accountDao = new AccountDao(getConnectionMaker());
		return accountDao;
	}

	public MessageDao messageDao() {
		MessageDao messageDao = new MessageDao(getConnectionMaker());
		return messageDao;
	}

	private ConnectionMaker getConnectionMaker() {
		return new DConnectionMaker();
	}
}
