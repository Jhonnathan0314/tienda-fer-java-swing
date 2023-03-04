/**
 * 
 */
package repositories;

import java.sql.Date;
import java.util.List;

import model.Bill;

/**
 * @author JONATAN FRANCO
 *
 */
public interface BillRepository {

	public List<Bill> findAll();
	
	public Bill findById(int id);

	public List<Bill> findByDate(Date date);
	
	public Bill create(Bill section);
	
	public Bill update(int id, Bill section);
	
	public boolean deleteById(int id);
	
}
