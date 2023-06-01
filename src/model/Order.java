/**
 * 
 */
package model;

import java.sql.Timestamp;

/**
 * @author JONATAN FRANCO
 * @author WILLIAM ROA
 * @apiNote RF5
 * @version V1 -> 20-04-2023
 */
public class Order {
	//Variables declaration
	private int id;
	private Timestamp date;
	private float totalValue;
	private Supplier supplier;
	
	//Construct method than receives a product attributes
	public Order(int id, Timestamp date, float totalValue, Supplier supplier) {
		super();
		this.id = id;
		this.date = date;
		this.totalValue = totalValue;
		this.supplier = supplier;
	}

	//Empty construct method
	public Order() { }
	
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

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
}
