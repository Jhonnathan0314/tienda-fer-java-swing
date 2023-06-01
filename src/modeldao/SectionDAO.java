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

import model.Section;
import repositories.SectionRepository;

/**
 * @author JONATAN FRANCO
 * @author WILLIAM ROA
 * @apiNote RF1
 * @version V1 -> 24-03-2023
 */
public class SectionDAO implements SectionRepository {
	//Variables declaration
	private Connection connection = null;
	
	//Construct method that receive a database connection
	public SectionDAO(Connection connection) {
		this.connection = connection;
	}
	
	/**
	 * Method that find all sections
	 * @return sections finded
	 */
	@Override
	public List<Section> findAll() {
		List<Section> sections = new ArrayList<>();
        String query = "SELECT * FROM section";
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(query)) {
                int id;
                String name;
                Timestamp updateDate;
                while (resultSet.next()) {
                    id = resultSet.getInt("id");
                    name = resultSet.getString("name");
                    updateDate = resultSet.getTimestamp("update_date");
                    sections.add(new Section(id, name, updateDate));
                }
            }
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return sections;
	}
	
	/**
	 * Method that find section by name
	 * @param searchName -> section name string to search in database
	 * @return sections finded by name
	 */
	@Override
	public List<Section> findByName(String searchName) {
		List<Section> sections = new ArrayList<>();
		String query = "SELECT * FROM section WHERE name like ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, "%" + searchName + "%");
			try (ResultSet resultSet = statement.executeQuery()) {
	        	int id;
	        	String name;
	        	Timestamp updateDate;
	            while (resultSet.next()) {
	                id = resultSet.getInt("id");
	                name = resultSet.getString("name");
	                updateDate = resultSet.getTimestamp("update_date");
	                sections.add(new Section(id, name, updateDate));
	            }
	        }
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sections;
	}

	/**
	 * Method that find section by id
	 * @param id -> id to search
	 * @return section finded by id
	 */
	@Override
	public Section findById(int id) {
		String query = "SELECT * FROM section WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    Timestamp updateDate = resultSet.getTimestamp("update_date");
                    return new Section(id, name, updateDate);
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
	 * Method that create a section
	 * @param section -> section object to will be created
	 * @return section received or null if creation fails
	 */
	@Override
	public Section create(Section section) {
		String query = "INSERT INTO section (name) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, section.getName());
            statement.executeUpdate();
            return section;
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
        }
	}

	/**
	 * Method that update a section
	 * @param id -> id of the section to update
	 * @param section -> section object to will be updated
	 * @return section received or null if update fails
	 */
	@Override
	public Section update(int id, Section section) {
		String query = "UPDATE section SET name = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
        	section.setId(id);
            statement.setString(1, section.getName());
            statement.setInt(2, section.getId());
            statement.executeUpdate();
            return section;
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
        }
	}

	/**
	 * Method that delete a section by id
	 * @param id -> id of the section to delete
	 * @return true if delete was successful
	 */
	@Override
	public boolean deleteById(int id) {
		String query = "DELETE FROM section WHERE id = ?";
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
