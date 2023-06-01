/**
 * 
 */
package repositories;

import java.util.List;

import model.DetailOrder;

/**
 * @author JONATAN FRANCO
 * @author WILLIAM ROA
 * @apiNote RF5
 * @version V1 -> 20-04-2023
 */
public interface DetailOrderRepository {

	public List<DetailOrder> findByOrder(int orderId);
	
	public DetailOrder insert(DetailOrder detailOrder);
	
}
