package project.fish.service;

public class FishVO {
	private String userId;
	private String name;
	private String password;

	public String toString() {
		System.out.print(userId + "  :  ");
		System.out.print(name + "  :  ");
		System.out.println(password + " : ");
		return null;
		
		
		
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
