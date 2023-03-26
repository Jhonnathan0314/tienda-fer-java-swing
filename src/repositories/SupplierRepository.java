/**
 * 
 */
package repositories;

import java.util.List;

import model.Supplier;

/**
 * @author JONATAN FRANCO
 * @author WILLIAM ROA
 * @apiNote RF3
 * @version V1 -> @ 24-03-2023
 */
public interface SupplierRepository {

	public List<Supplier> findAll();
	
	public List<Supplier> findByName(String searchName);
	
	public Supplier findById(String id);
	
	public Supplier create(Supplier supplier);
	
	public Supplier update(String id, Supplier supplier);
	
	public boolean deleteById(String id);
	
}
