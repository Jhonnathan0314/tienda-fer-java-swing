/**
 * 
 */
package model;

import java.sql.Date;

/**
 * @author JONATAN FRANCO
 *
 */
public class Order {
	//Declaracion de variables
	private int id;
	private Date date;
	private float totalValue;
	private Date updateDate;
	private Supplier supplier;
	
	//Metodos constructores
	public Order(int id, Date date, float totalValue, Date updateDate, Supplier supplier) {
		super();
		this.id = id;
		this.date = date;
		this.totalValue = totalValue;
		this.updateDate = updateDate;
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

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
}
