/**
 * 
 */
package repositories;

import java.util.List;

import model.DetailOrder;

/**
 * @author JONATAN FRANCO
 *
 */
public interface DetailOrderRepository {

	public List<DetailOrder> findAll();
	
	public DetailOrder findById(int id);
	
	public DetailOrder create(DetailOrder section);
	
	public DetailOrder update(int id, DetailOrder section);
	
	public boolean deleteById(int id);
	
}
