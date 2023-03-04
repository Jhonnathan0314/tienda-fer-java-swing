/**
 * 
 */
package model;

import java.math.BigInteger;
import java.sql.Date;

/**
 * @author JONATAN FRANCO
 *
 */
public class Supplier {
	//Declaracion de variables
	private int id;
	private String supplierName;
	private String sellerName;
	private BigInteger phone;
	private Date updateDate;
	
	//Metodos constructores
	public Supplier(int id, String supplierName, String sellerName, BigInteger phone, Date updateDate) {
		super();
		this.id = id;
		this.supplierName = supplierName;
		this.sellerName = sellerName;
		this.phone = phone;
		this.updateDate = updateDate;
	}
	
	public Supplier() { }

	//Metodos get y set
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public BigInteger getPhone() {
		return phone;
	}

	public void setPhone(BigInteger phone) {
		this.phone = phone;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
