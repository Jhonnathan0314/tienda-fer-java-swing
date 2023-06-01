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

import model.Supplier;
import repositories.SupplierRepository;

/**
 * @author JONATAN FRANCO
 * @author WILLIAM ROA
 * @apiNote RF3
 * @version V1 -> 24-03-2023
 */
public class SupplierDAO implements SupplierRepository {
	//Variables declaration
	private Connection connection = null;
	
	//Construct method that receive a database connection
	public SupplierDAO(Connection connection) {
		this.connection = connection;
	}
	
	/**
	 * Method that find all suppliers
	 * @return suppliers finded
	 */
	@Override
	public List<Supplier> findAll() {
		List<Supplier> suppliers = new ArrayList<>();
        String query = "SELECT * FROM supplier";
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(query)) {
            	String id;
                String supplierName, sellerName;
                String phone;
                Timestamp updateDate;
                Supplier supplier;
            	while (resultSet.next()) {
                    id = resultSet.getString("id");
                    supplierName = resultSet.getString("supplier_name");
                    sellerName = resultSet.getString("seller_name");
                    phone = resultSet.getString("phone");
                    updateDate = resultSet.getTimestamp("update_date");
                    supplier = new Supplier(id, supplierName, sellerName, phone, updateDate);
                    suppliers.add(supplier);
                }
            }
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return suppliers;
	}
	
	/**
	 * Method that find supplier by name
	 * @param searchName -> supplier name string to search in database
	 * @return suppliers finded by name
	 */
	@Override
	public List<Supplier> findByName(String searchName) {
		List<Supplier> suppliers = new ArrayList<>();
		String query = "SELECT * FROM supplier WHERE supplier_name like ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, "%" + searchName + "%");
			try (ResultSet resultSet = statement.executeQuery()) {
            	String id;
                String supplierName, sellerName;
                String phone;
                Timestamp updateDate;
	            while (resultSet.next()) {
                    id = resultSet.getString("id");
                    supplierName = resultSet.getString("supplier_name");
                    sellerName = resultSet.getString("seller_name");
                    phone = resultSet.getString("phone");
                    updateDate = resultSet.getTimestamp("update_date");
	                suppliers.add(new Supplier(id, supplierName, sellerName, phone, updateDate));
	            }
	        }
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return suppliers;
	}

	/**
	 * Method that find supplier by id
	 * @param id -> id to search
	 * @return supplier finded by id
	 */
	@Override
	public Supplier findById(String id) {
		String query = "SELECT * FROM supplier WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String supplierName = resultSet.getString("supplier_name");
                    String sellerName = resultSet.getString("seller_name");
                    String phone = resultSet.getString("phone");
                    Timestamp updateDate = resultSet.getTimestamp("update_date");
                    Supplier supplier = new Supplier(id, supplierName, sellerName, phone, updateDate);
                    return supplier;
                }
            }
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
	}

	/**
	 * Method that create a supplier
	 * @param supplier -> supplier object to will be created
	 * @return supplier received or null if creation fails
	 */
	@Override
	public Supplier create(Supplier supplier) {
		String query = "INSERT INTO supplier (id, supplier_name, seller_name, phone) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, supplier.getId());
            statement.setString(2, supplier.getSupplierName());
            statement.setString(3, supplier.getSellerName());
            statement.setString(4, supplier.getPhone().toString());
            statement.executeUpdate();
            return supplier;
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Method that update a supplier
	 * @param id -> id of the supplier to update
	 * @param supplier -> supplier object to will be updated
	 * @return supplier received or null if update fails
	 */
	@Override
	public Supplier update(String id, Supplier supplier) {
		String query = "UPDATE supplier SET supplier_name = ?, seller_name = ?, phone = ?, update_date = current_timestamp WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            supplier.setId(id);
        	statement.setString(1, supplier.getSupplierName());
            statement.setString(2, supplier.getSellerName());
            statement.setString(3, supplier.getPhone().toString());
            statement.setString(4, supplier.getId());
            statement.executeUpdate();
            return supplier;
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Method that delete a supplier by id
	 * @param id -> id of the supplier to delete
	 * @return true if delete was successful
	 */
	@Override
	public boolean deleteById(String id) {
		String query = "DELETE FROM supplier WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
