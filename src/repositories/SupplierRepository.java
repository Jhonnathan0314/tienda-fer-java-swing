/**
 * 
 */
package repositories;

import java.util.List;

import model.Supplier;

/**
 * @author JONATAN FRANCO
 *
 */
public interface SupplierRepository {

	public List<Supplier> findAll();
	
	public Supplier findById(String id);
	
	public Supplier create(Supplier supplier);
	
	public Supplier update(String id, Supplier supplier);
	
	public boolean deleteById(String id);
	
}
