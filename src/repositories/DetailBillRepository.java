/**
 * 
 */
package repositories;

import java.util.List;

import model.DetailBill;

/**
 * @author JONATAN FRANCO
 *
 */
public interface DetailBillRepository {
	
	public List<DetailBill> findByBill(int billId);
	
	public DetailBill insert(DetailBill detailBill);
	
}
