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
 *
 */
public class SupplierDAO implements SupplierRepository {
	//Declaracion de variables
	private Connection connection = null;
	
	public SupplierDAO(Connection connection) {
		this.connection = connection;
	}
	
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
