/**
 * 
 */
package modeldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DetailOrder;
import repositories.DetailOrderRepository;

/**
 * @author JONATAN FRANCO
 * @author WILLIAM ROA
 * @apiNote RF5
 * @version V1 -> 20-04-2023
 */
public class DetailOrderDAO implements DetailOrderRepository {
	//Variables declaration
	private OrderDAO orderDAO;
	private ProductDAO productDAO;

	private Connection connection = null;

	//Construct method that receive a database connection
	public DetailOrderDAO(Connection connection) {
		this.connection = connection;
	}

	/**
	 * Method that find detail order by supplier
	 * @param orderId -> order id to search in database
	 * @return detail orders finded by id
	 */
	@Override
	public List<DetailOrder> findByOrder(int orderId) {
		List<DetailOrder> detailOrders = new ArrayList<>();
		String sql = "SELECT * FROM detail_order WHERE order_bill = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, orderId);
			try (ResultSet resultSet = statement.executeQuery()) {
				int productId;
				DetailOrder detailOrder = new DetailOrder();
				while (resultSet.next()) {
					detailOrder = new DetailOrder();
					detailOrder.setId(resultSet.getInt("id"));
					detailOrder.setOrderedQuantity(resultSet.getInt("ordered_quantity"));
					detailOrder.setReceivedQuantity(resultSet.getInt("received_quantity"));
					detailOrder.setUnitValue(resultSet.getFloat("unit_value"));
					detailOrder.setTotalValue(resultSet.getFloat("total_value"));
					detailOrder.setSaleValue(resultSet.getFloat("sale_value"));
					detailOrder.setPercentageProfit(resultSet.getFloat("percentage_profit"));
					productId = resultSet.getInt("product");
					detailOrder.setProduct(productDAO.findById(productId));
					detailOrder.setOrder(orderDAO.findById(orderId));
					detailOrders.add(detailOrder);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return detailOrders;
	}

	/**
	 * Method that create a detail order
	 * @param detailOrder -> detail order object to will be created
	 * @return detail order received or null if creation fails
	 */
	@Override
	public DetailOrder insert(DetailOrder detailOrder) {
		String sql = "INSERT INTO detail_order (ordered_quantity, received_quantity, unit_value, total_value, sale_value, percentage_profit, product, order_bill) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, detailOrder.getOrderedQuantity());
			statement.setInt(2, detailOrder.getReceivedQuantity());
			statement.setFloat(3, detailOrder.getUnitValue());
			statement.setFloat(4, detailOrder.getTotalValue());
			statement.setFloat(5, detailOrder.getSaleValue());
			statement.setFloat(6, detailOrder.getPercentageProfit());
			statement.setInt(7, detailOrder.getProduct().getId());
			statement.setInt(8, detailOrder.getOrder().getId());
			statement.executeUpdate();
			return detailOrder;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	//Get and set methods
	public OrderDAO getOrderDAO() {
		return orderDAO;
	}

	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	public ProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
}
