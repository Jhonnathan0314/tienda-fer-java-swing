/**
 * 
 */
package repositories;

import java.util.List;

import model.Product;

/**
 * @author JONATAN FRANCO
 *
 */
public interface ProductRepository {

	public List<Product> findAll();
	
	public Product findById(int id);
	
	public List<Product> findByName(String name);
	
	public List<Product> findBySection(int idSection);
	
	public Product create(Product product);
	
	public Product update(int id, Product product);
	
	public boolean deleteById(int id);
	
}
