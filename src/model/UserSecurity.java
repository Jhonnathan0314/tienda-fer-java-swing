/**
 * 
 */
package model;

/**
 * @author JONATAN FRANCO
 * @author WILLIAM ROA
 * @apiNote RF6
 * @version V1 -> 13-03-2023
 */
public class UserSecurity {
	//Variables declaration
	private int id;
	private String username;
	private String password;
	
	//Construct method than receives a product attributes
	public UserSecurity(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	//Empty construct method
	public UserSecurity() { }

	//Get and set methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
