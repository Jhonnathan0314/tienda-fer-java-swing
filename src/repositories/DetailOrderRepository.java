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

	public List<DetailOrder> findByOrder(int orderId);
	
	public DetailOrder insert(DetailOrder detailOrder);
	
}
