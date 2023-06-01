/**
 * 
 */
package repositories;

/**
 * @author JONATAN FRANCO
 * @author WILLIAM ROA
 * @apiNote RF6
 * @version V1 -> 13-03-2023
 */
public interface UserSecurityRepository {

	public boolean checkPassword(String username, String password);
	
}
