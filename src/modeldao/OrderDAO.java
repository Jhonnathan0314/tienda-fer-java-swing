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

import model.Order;
import model.Supplier;
import repositories.OrderRepository;

/**
 * @author JONATAN FRANCO
 *
 */
public class OrderDAO implements OrderRepository {
	//Declaracion de variables	
	private SupplierDAO supplierDAO;
	
	private Connection connection = null;

	public OrderDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Order> findAll() {
		List<Order> orders = new ArrayList<>();
		String query = "SELECT * FROM order_bill";
		try (Statement statement = connection.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery(query)) {
				int id;
				String supplierId;
				Timestamp date;
				float totalValue;
				Supplier supplier;
				Order order;
				while (resultSet.next()) {
					id = resultSet.getInt("id");
					date = resultSet.getTimestamp("date");
					totalValue = resultSet.getFloat("total_value");
					supplierId = resultSet.getString("supplier");
					supplier = supplierDAO.findById(supplierId);
					order = new Order(id, date, totalValue, supplier);
					orders.add(order);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;
	}

	@Override
	public Order findById(int id) {
		String query = "SELECT * FROM order_bill WHERE id = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, id);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					Timestamp date = resultSet.getTimestamp("date");
					float totalValue = resultSet.getFloat("total_value");
					String supplierId = resultSet.getString("supplier");
					Supplier supplier = supplierDAO.findById(supplierId);
					Order order = new Order(id, date, totalValue, supplier);
					return order;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Order> findByYear(int year) {
		List<Order> orders = new ArrayList<>();
		String sql = "SELECT * FROM order_bill WHERE YEAR(date) = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, year);
			try (ResultSet resultSet = statement.executeQuery()) {
				Order order;
				String supplierId;
				Supplier supplier;
				while (resultSet.next()) {
					order = new Order();
					order.setId(resultSet.getInt("id"));
					order.setDate(resultSet.getTimestamp("date"));
					order.setTotalValue(resultSet.getFloat("total_value"));
					supplierId = resultSet.getString("supplier");
					supplier = supplierDAO.findById(supplierId);
					order.setSupplier(supplier);
					orders.add(order);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;
	}

	public List<Order> findByYearAndMonth(int year, int month) {
		List<Order> orders = new ArrayList<>();
		String sql = "SELECT * FROM order_bill WHERE YEAR(date) = ? AND MONTH(date) = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, year);
			statement.setInt(2, month);
			try (ResultSet resultSet = statement.executeQuery()) {
				Order order;
				String supplierId;
				Supplier supplier;
				while (resultSet.next()) {
					order = new Order();
					order.setId(resultSet.getInt("id"));
					order.setDate(resultSet.getTimestamp("date"));
					order.setTotalValue(resultSet.getFloat("total_value"));
					supplierId = resultSet.getString("supplier");
					supplier = supplierDAO.findById(supplierId);
					order.setSupplier(supplier);
					orders.add(order);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;
	}

	public List<Order> findByYearAndMonthAndDay(int year, int month, int day) {
		List<Order> orders = new ArrayList<>();
		String sql = "SELECT * FROM order_bill WHERE YEAR(date) = ? AND MONTH(date) = ? AND DAY(date) = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, year);
			statement.setInt(2, month);
			statement.setInt(3, day);			
			try (ResultSet resultSet = statement.executeQuery()) {
				Order order;
				String supplierId;
				Supplier supplier;
				while (resultSet.next()) {
					order = new Order();
					order.setId(resultSet.getInt("id"));
					order.setDate(resultSet.getTimestamp("date"));
					order.setTotalValue(resultSet.getFloat("total_value"));
					supplierId = resultSet.getString("supplier");
					supplier = supplierDAO.findById(supplierId);
					order.setSupplier(supplier);
					orders.add(order);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;
	}
	
	@Override
	public List<Order> findBySupplier(String idSupplier) {
		List<Order> orders = new ArrayList<>();
		String sql = "SELECT * FROM order_bill WHERE supplier = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, idSupplier);
			try (ResultSet resultSet = statement.executeQuery()) {
				Order order;
				Supplier supplier;
				while (resultSet.next()) {
					order = new Order();
					order.setId(resultSet.getInt("id"));
					order.setDate(resultSet.getTimestamp("date"));
					order.setTotalValue(resultSet.getFloat("total_value"));
					supplier = supplierDAO.findById(idSupplier);
					order.setSupplier(supplier);
					orders.add(order);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;
	}

	@Override
	public Order create(Order order) {
		String query = "INSERT INTO order_bill (total_value, supplier) VALUES (?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			statement.setFloat(1, order.getTotalValue());
			statement.setString(2, order.getSupplier().getId());
			statement.executeUpdate();
			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					int id = generatedKeys.getInt(1);
					order.setId(id);
				}
				return order;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean deleteById(int id) {
		String query = "DELETE FROM order_bill WHERE id = ?";
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

	//Metodos get y set
	public SupplierDAO getSupplierDAO() {
		return supplierDAO;
	}

	public void setSupplierDAO(SupplierDAO supplierDAO) {
		this.supplierDAO = supplierDAO;
	}
}
