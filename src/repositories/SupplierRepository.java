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
	
	public Supplier findById(int id);
	
	public Supplier create(Supplier section);
	
	public Supplier update(int id, Supplier section);
	
	public boolean deleteById(int id);
	
}
