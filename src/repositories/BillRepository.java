/**
 * 
 */
package repositories;

import java.util.List;

import model.Bill;

/**
 * @author JONATAN FRANCO
 *
 */
public interface BillRepository {

	public List<Bill> findAll();
	
	public Bill findById(int id);

	public List<Bill> findByYear(int year);

	public List<Bill> findByYearAndMonth(int year, int month);

	public List<Bill> findByYearAndMonthAndDay(int year, int month, int day);
	
	public Bill create(Bill bill);
	
	public boolean deleteById(int id);
	
}
