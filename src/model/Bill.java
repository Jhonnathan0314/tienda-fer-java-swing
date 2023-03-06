/**
 * 
 */
package model;

import java.sql.Timestamp;

/**
 * @author JONATAN FRANCO
 *
 */
public class Bill {
	//Declaracion de variables
	private int id;
	private Timestamp date;
	private float totalValue;
	
	//Metodos constructores
	public Bill(int id, Timestamp date, float totalValue) {
		super();
		this.id = id;
		this.date = date;
		this.totalValue = totalValue;
	}
	
	public Bill() { }

	//Metodos get y set
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
