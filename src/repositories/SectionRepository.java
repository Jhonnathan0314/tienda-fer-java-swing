/**
 * 
 */
package repositories;

import java.util.List;

import model.Section;

/**
 * @author JONATAN FRANCO
 *
 */
public interface SectionRepository {
	
	public List<Section> findAll();
	
	public Section findById(int id);
	
	public Section create(Section section);
	
	public Section update(int id, Section section);
	
	public boolean deleteById(int id);
	
}
