/**
 * 
 */
package repositories;

/**
 * @author JONATAN FRANCO
 *
 */
public interface UserSecurityRepository {

	public boolean checkPassword(String username, String password);
	
}
