/**
 * 
 */
package model;

import java.sql.Timestamp;

/**
 * @author JONATAN FRANCO
 * @author WILLIAM ROA
 * @apiNote RF1
 * @version V1 -> 24-03-2023
 */
public class Section {
	//Variables declaration
	private int id;
	private String name;
	private Timestamp updateDate;
	
	//Construct method than receives a product attributes
	public Section(int id, String name, Timestamp updateDate) {
		super();
		this.id = id;
		this.name = name;
		this.updateDate = updateDate;
	}
	
	//Empty construct method
	public Section() { }

	//Get and set methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}
		
}
