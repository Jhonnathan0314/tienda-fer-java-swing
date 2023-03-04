/**
 * 
 */
package model;

import java.sql.Date;

/**
 * @author JONATAN FRANCO
 *
 */
public class Section {
	//Declaracion de variables
	private int id;
	private String name;
	private Date updateDate;
	
	//Metodos constructores
	public Section(int id, String name, Date updateDate) {
		super();
		this.id = id;
		this.name = name;
		this.updateDate = updateDate;
	}
	
	public Section() { }

	//Metodos get y set
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

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
	
}
