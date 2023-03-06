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
	
	public List<Order> findByYear(int year);

	public List<Order> findByYearAndMonth(int year, int month);

	public List<Order> findByYearAndMonthAndDay(int year, int month, int day);

	public List<Order> findBySupplier(String idSupplier);
	
	public Order create(Order order);
	
	public boolean deleteById(int id);
	
}
