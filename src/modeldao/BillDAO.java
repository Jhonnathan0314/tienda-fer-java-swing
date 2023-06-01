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
 * @author WILLIAM ROA
 * @apiNote RF4
 * @version V1 -> 20-04-2023
 */
public class BillDAO implements BillRepository {
	//Variables declaration
	private Connection connection = null;

	//Construct method that receive a database connection
	public BillDAO(Connection connection) {
		this.connection = connection;
	}

	/**
	 * Method that find all bills
	 * @return bills finded
	 */
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

	/**
	 * Method that find bill by id
	 * @param id -> id to search
	 * @return bill finded by id
	 */
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

	/**
	 * Method that find bill by year
	 * @param year -> bill year to search in database
	 * @return bills finded by name
	 */
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
	
	/**
	 * Method that find bill by year and month
	 * @param year -> bill year to search in database
	 * @param month -> bill month to search in database
	 * @return bills finded by name
	 */
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
	
	/**
	 * Method that find bill by year, month and day
	 * @param year -> bill year to search in database
	 * @param month -> bill month to search in database
	 * @param day -> bill day to search in database
	 * @return bills finded by name
	 */
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

	/**
	 * Method that create a bill
	 * @param bill -> bill object to will be created
	 * @return bill received or null if creation fails
	 */
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

	/**
	 * Method that delete an bill by id
	 * @param id -> id of the bill to delete
	 * @return true if delete was successful
	 */
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
