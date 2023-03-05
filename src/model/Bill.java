/**
 * 
 */
package model;

import java.sql.Date;

/**
 * @author JONATAN FRANCO
 *
 */
public class Bill {
	//Declaracion de variables
	private int id;
	private Date date;
	private float totalValue;
	private Date updateDate;
	
	//Metodos constructores
	public Bill(int id, Date date, float totalValue, Date updateDate) {
		super();
		this.id = id;
		this.date = date;
		this.totalValue = totalValue;
		this.updateDate = updateDate;
	}
	
	public Bill() { }

	//Metodos get y set
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(float totalValue) {
		this.totalValue = totalValue;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
