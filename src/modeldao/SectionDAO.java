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
 *
 */
public class SectionDAO implements SectionRepository {

	private Connection connection = null;
	
	public SectionDAO(Connection connection) {
		this.connection = connection;
	}
	
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
