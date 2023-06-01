/**
 * 
 */
package repositories;

import java.util.List;

import model.DetailBill;

/**
 * @author JONATAN FRANCO
 * @author WILLIAM ROA
 * @apiNote RF4
 * @version V1 -> 20-04-2023
 */
public interface DetailBillRepository {
	
	public List<DetailBill> findByBill(int billId);
	
	public DetailBill insert(DetailBill detailBill);
	
}
