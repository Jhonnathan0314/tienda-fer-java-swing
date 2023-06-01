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

import model.DetailBill;
import repositories.DetailBillRepository;

/**
 * @author JONATAN FRANCO
 * @author WILLIAM ROA
 * @apiNote RF4
 * @version V1 -> 20-04-2023
 */
public class DetailBillDAO implements DetailBillRepository {
	//Variables declaration
	private BillDAO billDAO;
	private ProductDAO productDAO;
	
	private Connection connection = null;

	//Construct method that receive a database connection
	public DetailBillDAO(Connection connection) {
		this.connection = connection;
	}
	
	/**
	 * Method that find detail order by supplier
	 * @param billId -> biull id to search in database
	 * @return detail orders finded by id
	 */
	@Override
	public List<DetailBill> findByBill(int billId) {
		List<DetailBill> detailBills = new ArrayList<>();
        String sql = "SELECT * FROM detail_bill WHERE bill = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, billId);
            try (ResultSet resultSet = statement.executeQuery()) {
            	int productId;
                while (resultSet.next()) {
                    DetailBill detailBill = new DetailBill();
                    detailBill.setId(resultSet.getInt("id"));
                    detailBill.setQuantity(resultSet.getInt("quantity"));
                    detailBill.setUnitValue(resultSet.getFloat("unit_value"));
                    detailBill.setTotalValue(resultSet.getFloat("total_value"));
                    productId = resultSet.getInt("product");
                    detailBill.setProduct(productDAO.findById(productId));
                    detailBill.setBill(billDAO.findById(billId));
                    detailBills.add(detailBill);
                }
            }
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
        return detailBills;
	}

	/**
	 * Method that create a detail bill
	 * @param detailBill -> detail bill object to will be created
	 * @return detail bill received or null if creation fails
	 */
	@Override
	public DetailBill insert(DetailBill detailBill) {
		String sql = "INSERT INTO detail_bill (quantity, unit_value, total_value, product, bill) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, detailBill.getQuantity());
            statement.setFloat(2, detailBill.getUnitValue());
            statement.setFloat(3, detailBill.getTotalValue());
            statement.setInt(4, detailBill.getProduct().getId());
            statement.setInt(5, detailBill.getBill().getId());
            statement.executeUpdate();
            return detailBill;
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	//Metodos get y set
	public BillDAO getBillDAO() {
		return billDAO;
	}

	public void setBillDAO(BillDAO billDAO) {
		this.billDAO = billDAO;
	}

	public ProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

}
