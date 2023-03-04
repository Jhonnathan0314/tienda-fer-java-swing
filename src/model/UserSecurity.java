/**
 * 
 */
package model;

/**
 * @author JONATAN FRANCO
 *
 */
public class UserSecurity {
	//Declaracion de variables
	private int id;
	private String username;
	private String password;
	
	//Metodos constructores
	public UserSecurity(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	public UserSecurity() { }

	//Metodos get y set
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
