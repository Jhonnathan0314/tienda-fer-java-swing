/**
 * 
 */
package repositories;

import java.util.List;

import model.Order;

/**
 * @author JONATAN FRANCO
 *
 */
public interface OrderRepository {

	public List<Order> findAll();
	
	public Order findById(int id);
	
	public List<Order> findByDate(int id);

	public List<Order> findBySupplier(int idSupplier);
	
	public Order create(Order section);
	
	public Order update(int id, Order section);
	
	public boolean deleteById(int id);
	
}
