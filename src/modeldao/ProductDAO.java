/**
 * 
 */
package modeldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import model.Section;
import repositories.ProductRepository;

/**
 * @author JONATAN FRANCO
 *
 */
public class ProductDAO implements ProductRepository {
	//Variables declaration
	private Connection connection = null;
	private SectionDAO sectionDAO;
	
	
	//Construct method that receive a database connection
	public ProductDAO(Connection connection) {
		this.connection = connection;
	}
	
	
	/**
	 * Method that find all products
	 * @return products finded
	 */
	@Override
	public List<Product> findAll() {
		List<Product> products = new ArrayList<>();
	    String query = "SELECT * FROM product";
	    try (Statement statement = connection.createStatement()) {
	        try (ResultSet resultSet = statement.executeQuery(query)) {
	        	int id, quantityAvailable, sectionId;
	        	String name, packaging, quantityPackaging;
	        	float saleValue;
	        	Section section;
	        	Timestamp updateDate;
	            while (resultSet.next()) {
	                id = resultSet.getInt("id");
	                name = resultSet.getString("name");
	                quantityAvailable = resultSet.getInt("quantity_available");
	                saleValue = resultSet.getFloat("sale_value");
	                packaging = resultSet.getString("packaging");
	                quantityPackaging = resultSet.getString("quantity_packaging");
	                updateDate = resultSet.getTimestamp("update_date");
	                sectionId = resultSet.getInt("section");
	                section = sectionDAO.findById(sectionId);
	                products.add(new Product(id, name, quantityAvailable, saleValue, packaging, quantityPackaging, updateDate, section));
	            }
	        }
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return products;
	}

	/**
	 * Method that find product by id
	 * @param id -> id to search
	 * @return product finded by id
	 */
	@Override
	public Product findById(int id) {
		String query = "SELECT * FROM product WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
            	if (resultSet.next()) {
            		String name = resultSet.getString("name");
	                int quantityAvailable = resultSet.getInt("quantity_available");
	                float saleValue = resultSet.getFloat("sale_value");
	                String packaging = resultSet.getString("packaging");
	                String quantityPackaging = resultSet.getString("quantity_packaging");
	                Timestamp updateDate = resultSet.getTimestamp("update_date");
	                int sectionId = resultSet.getInt("section");
	                Section section = sectionDAO.findById(sectionId);
                    return new Product(id, name, quantityAvailable, saleValue, packaging, quantityPackaging, updateDate, section);
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Method that find product by name
	 * @param searchName -> product name string to search in database
	 * @return products finded by name
	 */
	@Override
	public List<Product> findByName(String name) {
		List<Product> products = new ArrayList<>();
		String query = "SELECT * FROM product WHERE name like ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, "%" + name + "%");
			try (ResultSet resultSet = statement.executeQuery()) {
	        	int id, quantityAvailable, sectionId;
	        	String packaging, quantityPackaging;
	        	float saleValue;
	        	Section section;
	        	Timestamp updateDate;
	            while (resultSet.next()) {
	                id = resultSet.getInt("id");
	                name = resultSet.getString("name");
	                quantityAvailable = resultSet.getInt("quantity_available");
	                saleValue = resultSet.getFloat("sale_value");
	                packaging = resultSet.getString("packaging");
	                quantityPackaging = resultSet.getString("quantity_packaging");
	                updateDate = resultSet.getTimestamp("update_date");
	                sectionId = resultSet.getInt("section");
	                section = sectionDAO.findById(sectionId);
	                products.add(new Product(id, name, quantityAvailable, saleValue, packaging, quantityPackaging, updateDate, section));
	            }
	        }
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

	/**
	 * Method that find product by section id
	 * @param idSection -> section id to search
	 * @return product finded by section id
	 */
	@Override
	public List<Product> findBySection(int idSection) {
		List<Product> products = new ArrayList<>();
		String query = "SELECT * FROM product WHERE section = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, idSection);
			try (ResultSet resultSet = statement.executeQuery()) {
	        	int id, quantityAvailable;
	        	String name, packaging, quantityPackaging;
	        	float saleValue;
	        	Section section;
	        	Timestamp updateDate;
	            while (resultSet.next()) {
	                id = resultSet.getInt("id");
	                name = resultSet.getString("name");
	                quantityAvailable = resultSet.getInt("quantity_available");
	                saleValue = resultSet.getFloat("sale_value");
	                packaging = resultSet.getString("packaging");
	                quantityPackaging = resultSet.getString("quantity_packaging");
	                updateDate = resultSet.getTimestamp("update_date");
	                section = sectionDAO.findById(idSection);
	                products.add(new Product(id, name, quantityAvailable, saleValue, packaging, quantityPackaging, updateDate, section));
	            }
	        }
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

	/**
	 * Method that find scarced products
	 * @return products finded
	 */
	@Override
	public List<Product> findScarceProducts() {
		List<Product> products = new ArrayList<>();
		String query = "SELECT * FROM product WHERE quantity_available < 4";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			try (ResultSet resultSet = statement.executeQuery()) {
	        	int id, quantityAvailable, sectionId;
	        	String name, packaging, quantityPackaging;
	        	float saleValue;
	        	Section section;
	        	Timestamp updateDate;
	            while (resultSet.next()) {
	                id = resultSet.getInt("id");
	                name = resultSet.getString("name");
	                quantityAvailable = resultSet.getInt("quantity_available");
	                saleValue = resultSet.getFloat("sale_value");
	                packaging = resultSet.getString("packaging");
	                quantityPackaging = resultSet.getString("quantity_packaging");
	                updateDate = resultSet.getTimestamp("update_date");
	                sectionId = resultSet.getInt("section");
	                section = sectionDAO.findById(sectionId);
	                products.add(new Product(id, name, quantityAvailable, saleValue, packaging, quantityPackaging, updateDate, section));
	            }
	        }
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

	/**
	 * Method that create a product
	 * @param product -> product object to will be created
	 * @return product received or null if creation fails
	 */
	@Override
	public Product create(Product product) {
		String query = "INSERT INTO product (name, quantity_available, sale_value, packaging, quantity_packaging, section) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, product.getName());
            statement.setInt(2, product.getQuantityAvailable());
            statement.setFloat(3, product.getSaleValue());
            statement.setString(4, product.getPackaging());
            statement.setString(5, product.getQuantityPackaging());
            statement.setInt(6, product.getSection().getId());
            statement.executeUpdate();
            return product;
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Method that update a product
	 * @param id -> id of the product to update
	 * @param product -> product object to will be updated
	 * @return product received or null if update fails
	 */
	@Override
	public Product update(int id, Product product) {
		String query = "UPDATE product SET name = ?, quantity_available = ?, sale_value = ?, packaging = ?, quantity_packaging = ?, section = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            product.setId(id);
        	statement.setString(1, product.getName());
            statement.setInt(2, product.getQuantityAvailable());
            statement.setFloat(3, product.getSaleValue());
            statement.setString(4, product.getPackaging());
            statement.setString(5, product.getQuantityPackaging());
            statement.setInt(6, product.getSection().getId());
            statement.setInt(7, product.getId());
            statement.executeUpdate();
            return product;
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Method that delete a product by id
	 * @param id -> id of the product to delete
	 * @return true if delete was successful
	 */
	@Override
	public boolean deleteById(int id) {
		String query = "DELETE FROM product WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {	
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
        }
	}

	//Get and set methods
	public SectionDAO getSectionDAO() {
		return sectionDAO;
	}

	public void setSectionDAO(SectionDAO sectionDAO) {
		this.sectionDAO = sectionDAO;
	}

}
