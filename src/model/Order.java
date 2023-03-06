/**
 * 
 */
package model;

import java.sql.Timestamp;

/**
 * @author JONATAN FRANCO
 *
 */
public class Order {
	//Declaracion de variables
	private int id;
	private Timestamp date;
	private float totalValue;
	private Supplier supplier;
	
	//Metodos constructores
	public Order(int id, Timestamp date, float totalValue, Supplier supplier) {
		super();
		this.id = id;
		this.date = date;
		this.totalValue = totalValue;
		this.supplier = supplier;
	}

	public Order() { }
	
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

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
}
