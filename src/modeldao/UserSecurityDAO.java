/**
 * 
 */
package modeldao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import repositories.UserSecurityRepository;

/**
 * @author JONATAN FRANCO
 * @author WILLIAM ROA
 * @apiNote RF6
 * @version V1 -> 13-03-2023
 */
public class UserSecurityDAO implements UserSecurityRepository{
	//Variables declaration
	private Connection connection = null;

	//Construct method that receive a database connection
	public UserSecurityDAO(Connection connection) {
		this.connection = connection;
	}
	
	/**
	 * Method that check credential of user that is trying to login
	 * @param username -> String user name
	 * @param password -> String password
	 * @return true if credentials are valid, else returns false
	 */
	@Override
	public boolean checkPassword(String username, String password) {
	    String sql = "SELECT password FROM user_security WHERE username = ?";
	    PreparedStatement statement;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
		    ResultSet resultSet = statement.executeQuery();

		    if (resultSet.next()) {
		    	String encodedPassword = convertSHA256(password);
		    	String encodedOriginalPassword = resultSet.getString("password");
		        return encodedPassword.equals(encodedOriginalPassword);
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @param password -> String password
	 * @return String password coverted in SHA256
	 */
	private String convertSHA256(String password) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		}
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
		byte[] hash = md.digest(password.getBytes());
		StringBuffer sb = new StringBuffer();
		for(byte b : hash) {
			sb.append(String.format("%02x", b));
		}
		return sb.toString();
	}
	
}
