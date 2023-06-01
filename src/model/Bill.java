/**
 * 
 */
package model;

import java.sql.Timestamp;

/**
 * @author JONATAN FRANCO
 * @author WILLIAM ROA
 * @apiNote RF4
 * @version V1 -> 20-04-2023
 */
public class Bill {
	//Variables declaration
	private int id;
	private Timestamp date;
	private float totalValue;
	
	//Construct method than receives a product attributes
	public Bill(int id, Timestamp date, float totalValue) {
		super();
		this.id = id;
		this.date = date;
		this.totalValue = totalValue;
	}
	
	//Empty construct method
	public Bill() { }

	//Get and set methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public float getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(float totalValue) {
		this.totalValue = totalValue;
	}
}
