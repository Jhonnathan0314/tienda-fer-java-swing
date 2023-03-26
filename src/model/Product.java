/**
 * 
 */
package model;

import java.sql.Timestamp;

/**
 * @author JONATAN FRANCO
 *
 */
public class Product {
	//Variables declaration
	private int id;
	private String name;
	private int quantityAvailable;
	private float saleValue;
	private String packaging;
	private String quantityPackaging;
	private Timestamp updateDate;
	private Section section;
	
	
	//Construct method than receives a product attributes
	public Product(int id, String name, int quantityAvailable, float saleValue, String packaging, String quantityPackaging, Timestamp updateDate, Section section) {
		super();
		this.id = id;
		this.name = name;
		this.quantityAvailable = quantityAvailable;
		this.saleValue = saleValue;
		this.packaging = packaging;
		this.quantityPackaging = quantityPackaging;
		this.updateDate = updateDate;
		this.section = section;
	}
	
	//Empty construct method
	public Product() { }

	
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

	public int getQuantityAvailable() {
		return quantityAvailable;
	}

	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}

	public float getSaleValue() {
		return saleValue;
	}

	public void setSaleValue(float saleValue) {
		this.saleValue = saleValue;
	}

	public String getPackaging() {
		return packaging;
	}

	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}

	public String getQuantityPackaging() {
		return quantityPackaging;
	}

	public void setQuantityPackaging(String quantityPackaging) {
		this.quantityPackaging = quantityPackaging;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
}
