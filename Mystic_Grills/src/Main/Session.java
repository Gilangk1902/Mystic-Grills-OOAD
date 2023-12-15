package Main;

import Model.User;

public class Session {
	private static User user;
	
	public Session() {}
	
	public static User getUser() {
		return user;
	}
	
	public static void setUser(User _user) {
		user = _user;
	}
	
	public static void logout() {
		user = null;
	}
}
