package hash;

public class User implements Comparable<User>{
	private int id;
	private String userName;
	private String password;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String userName, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + "]";
	}
	/*@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof User))
			return false;
		User another = (User) obj;
		return (this.hashCode() == another.hashCode());
	}

	@Override
	public int hashCode() {
		return 21 + userName.hashCode() + Integer.hashCode(id);
	}*/

	@Override
	public int compareTo(User ob) {
		return this.userName.compareTo(ob.userName);
	}

}
