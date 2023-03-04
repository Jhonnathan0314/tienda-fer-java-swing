/**
 * 
 */
package modeldao;

import java.util.List;

import model.Product;
import repositories.ProductRepository;

/**
 * @author JONATAN FRANCO
 *
 */
public class ProductDAO implements ProductRepository {

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findBySection(int idSection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product create(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product update(int id, Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
