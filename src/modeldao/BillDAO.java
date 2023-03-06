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

import model.Bill;
import repositories.BillRepository;

/**
 * @author JONATAN FRANCO
 *
 */
public class BillDAO implements BillRepository {
	//Declaracion de variables	
	private Connection connection = null;

	public BillDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Bill> findAll() {
		List<Bill> bills = new ArrayList<>();
		String query = "SELECT * FROM bill";
		try (Statement statement = connection.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery(query)) {
				int id;
				Timestamp date;
				float totalValue;
				Bill bill;
				while (resultSet.next()) {
					id = resultSet.getInt("id");
					date = resultSet.getTimestamp("date");
					totalValue = resultSet.getFloat("total_value");
					bill = new Bill(id, date, totalValue);
					bills.add(bill);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bills;
	}

	@Override
	public Bill findById(int id) {
		String query = "SELECT * FROM bill WHERE id = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, id);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					Timestamp date = resultSet.getTimestamp("date");
					float totalValue = resultSet.getFloat("total_value");
					Bill bill = new Bill(id, date, totalValue);
					return bill;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Bill> findByYear(int year) {
		List<Bill> bills = new ArrayList<>();
	    String sql = "SELECT * FROM bill WHERE YEAR(date) = ?";
	    try (PreparedStatement statement = connection.prepareStatement(sql)) {
	        statement.setInt(1, year);
	        try (ResultSet resultSet = statement.executeQuery()) {
	        	Bill bill;
	        	while (resultSet.next()) {
	                bill = new Bill();
	                bill.setId(resultSet.getInt("id"));
	                bill.setDate(resultSet.getTimestamp("date"));
	                bill.setTotalValue(resultSet.getFloat("total_value"));
	                bills.add(bill);
	            }
	        }
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return bills;
	}
	
	public List<Bill> findByYearAndMonth(int year, int month) {
		List<Bill> bills = new ArrayList<>();
		String sql = "SELECT * FROM bill WHERE YEAR(date) = ? AND MONTH(date) = ?";
	    try (PreparedStatement statement = connection.prepareStatement(sql)) {
	    	statement.setInt(1, year);
	        statement.setInt(2, month);
	        try (ResultSet resultSet = statement.executeQuery()) {
	        	Bill bill;
	        	while (resultSet.next()) {
	                bill = new Bill();
	                bill.setId(resultSet.getInt("id"));
	                bill.setDate(resultSet.getTimestamp("date"));
	                bill.setTotalValue(resultSet.getFloat("total_value"));
	                bills.add(bill);
	            }
	        }
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return bills;
	}
	
	public List<Bill> findByYearAndMonthAndDay(int year, int month, int day) {
		List<Bill> bills = new ArrayList<>();
		String sql = "SELECT * FROM bill WHERE YEAR(date) = ? AND MONTH(date) = ? AND DAY(date) = ?";
	    try (PreparedStatement statement = connection.prepareStatement(sql)) {
	    	statement.setInt(1, year);
	        statement.setInt(2, month);
	        statement.setInt(3, day);
	        try (ResultSet resultSet = statement.executeQuery()) {
	        	Bill bill;
	        	while (resultSet.next()) {
	                bill = new Bill();
	                bill.setId(resultSet.getInt("id"));
	                bill.setDate(resultSet.getTimestamp("date"));
	                bill.setTotalValue(resultSet.getFloat("total_value"));
	                bills.add(bill);
	            }
	        }
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return bills;
	}

	@Override
	public Bill create(Bill bill) {
		String query = "INSERT INTO bill (total_value) VALUES (?)";
		try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			statement.setFloat(1, bill.getTotalValue());
			statement.executeUpdate();
			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					int id = generatedKeys.getInt(1);
					bill.setId(id);
				}
				return bill;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean deleteById(int id) {
		String query = "DELETE FROM bill WHERE id = ?";
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
}
