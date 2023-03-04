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
	
	public List<DetailBill> findAll();
	
	public DetailBill findById(int id);
	
	public DetailBill create(DetailBill section);
	
	public DetailBill update(int id, DetailBill section);
	
	public boolean deleteById(int id);
	
}
