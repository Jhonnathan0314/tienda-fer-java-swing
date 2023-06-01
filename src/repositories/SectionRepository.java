/**
 * 
 */
package repositories;

import java.util.List;

import model.Section;

/**
 * @author JONATAN FRANCO
 * @author WILLIAM ROA
 * @apiNote RF1
 * @version V1 -> 24-03-2023
 */
public interface SectionRepository {
	
	public List<Section> findAll();
	
	public List<Section> findByName(String searchName);
	
	public Section findById(int id);
	
	public Section create(Section section);
	
	public Section update(int id, Section section);
	
	public boolean deleteById(int id);
	
}
