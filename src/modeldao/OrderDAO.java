/**
 * 
 */
package modeldao;

import java.util.List;

import model.Order;
import repositories.OrderRepository;

/**
 * @author JONATAN FRANCO
 *
 */
public class OrderDAO implements OrderRepository {

	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findByDate(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findBySupplier(int idSupplier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order create(Order section) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order update(int id, Order section) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
