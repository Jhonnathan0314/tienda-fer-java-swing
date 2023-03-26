/**
 * 
 */
package model;

import java.sql.Timestamp;

/**
 * @author JONATAN FRANCO
 *
 */
public class Supplier {
	//Variables declaration
	private String id;
	private String supplierName;
	private String sellerName;
	private String phone;
	private Timestamp updateDate;
	

	//Construct method than receives a supplier attributes
	public Supplier(String id, String supplierName, String sellerName, String phone, Timestamp updateDate) {
		super();
		this.id = id;
		this.supplierName = supplierName;
		this.sellerName = sellerName;
		this.phone = phone;
		this.updateDate = updateDate;
	}

	//Empty construct method
	public Supplier() { }


	//Get and set methods
	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}
}
