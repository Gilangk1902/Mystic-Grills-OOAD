package Main;

import Model.User;

public class Session {
	private static User user;
	
	public Session() {}
	
	public static User getUser() {
		return user;
	}
	
	public static void setUser(User _user) {
//		user.setId(_user.getId());
//		user.setRole(_user.getRole());
//		user.setEmail(_user.getEmail());
//		user.setUsername(_user.getUsername());
//		user.setPassword(_user.getPassword());
		user = _user;
	}
}
