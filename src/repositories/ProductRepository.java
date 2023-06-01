/**
 * 
 */
package repositories;

import java.util.List;

import model.Product;

/**
 * @author JONATAN FRANCO
 * @author WILLIAM ROA
 * @apiNote RF2
 * @version V1 -> 24-03-2023
 */
public interface ProductRepository {

	public List<Product> findAll();
	
	public Product findById(int id);
	
	public List<Product> findByName(String name);
	
	public List<Product> findBySection(int idSection);
	
	public List<Product> findScarceProducts();
	
	public Product create(Product product);
	
	public Product update(int id, Product product);
	
	public boolean deleteById(int id);
	
}
